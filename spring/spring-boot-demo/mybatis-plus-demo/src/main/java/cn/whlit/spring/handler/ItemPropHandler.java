package cn.whlit.spring.handler;


import cn.whlit.spring.entity.Prop;
import com.alibaba.fastjson2.JSON;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.postgresql.util.PGobject;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author WangHaiLong 2025/1/17 22:21
 */
@MappedJdbcTypes(JdbcType.OTHER)
@MappedTypes(Prop.class)
public class ItemPropHandler extends BaseTypeHandler<Prop> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Prop parameter, JdbcType jdbcType) throws SQLException {
        PGobject obj = new PGobject();
        obj.setType("json");
        obj.setValue(JSON.toJSONString(parameter));
        ps.setObject(i, obj);
    }

    @Override
    public Prop getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return JSON.parseObject(rs.getString(columnName), Prop.class);
    }

    @Override
    public Prop getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return JSON.parseObject(rs.getString(columnIndex), Prop.class);
    }

    @Override
    public Prop getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return JSON.parseObject(cs.getString(columnIndex), Prop.class);
    }
}
