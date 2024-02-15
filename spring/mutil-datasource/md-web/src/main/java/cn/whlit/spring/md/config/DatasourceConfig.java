package cn.whlit.spring.md.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.transaction.SpringManagedTransactionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

import java.util.HashMap;
import java.util.Map;

/**
 * @author WangHaiLong 2024/2/4 12:49
 */
@MapperScan(basePackages = "cn.whlit.spring.md.dao", sqlSessionFactoryRef = "sqlSessionFactory")
@Configuration
public class DatasourceConfig {

    @ConfigurationProperties("spring.datasource.test")
    @Bean("testDataSource")
    public DataSource test() {
        return DataSourceBuilder.create().build();
    }

    @ConfigurationProperties("spring.datasource.test2")
    @Bean("test2DataSource")
    public DataSource test2() {
        return DataSourceBuilder.create().build();
    }

    @Bean("dynamicDataSource")
    public DynamicDataSource dynamicDataSource(@Qualifier("testDataSource") DataSource testDataSource,
                                               @Qualifier("test2DataSource") DataSource test2DataSource) {
        Map<Object, Object> dataSourceMap = new HashMap<>();
        dataSourceMap.put("test", testDataSource);
        dataSourceMap.put("test2", test2DataSource);
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        dynamicDataSource.setTargetDataSources(dataSourceMap);
        return dynamicDataSource;
    }

    @Bean("sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dynamicDataSource") DynamicDataSource dynamicDataSource)
            throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dynamicDataSource);
        sqlSessionFactoryBean.setTransactionFactory(new SpringManagedTransactionFactory());
        return sqlSessionFactoryBean.getObject();
    }

}
