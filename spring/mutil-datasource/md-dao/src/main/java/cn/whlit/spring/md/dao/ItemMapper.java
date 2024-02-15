package cn.whlit.spring.md.dao;

import cn.whlit.spring.md.entity.Item;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.builder.annotation.ProviderMethodResolver;
import org.apache.ibatis.jdbc.SQL;

/**
 * @author WangHaiLong 2024/2/4 12:32
 */
@Mapper
public interface ItemMapper {

    @SelectProvider(SqlProvider.class)
    Item getById(Integer id);

    class SqlProvider implements ProviderMethodResolver {
        public static String getById(Integer id) {
            SQL sql = new SQL();
            sql.SELECT("id, name, type")
                    .FROM("item")
                    .WHERE("id = #{id}");
            return sql.toString();
        }
    }
}
