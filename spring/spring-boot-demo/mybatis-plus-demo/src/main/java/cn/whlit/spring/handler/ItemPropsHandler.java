package cn.whlit.spring.handler;


import cn.whlit.spring.entity.Prop;
import com.alibaba.fastjson2.JSON;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.postgresql.util.PGobject;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author WangHaiLong 2025/1/17 22:05
 */
@MappedTypes(List.class)
public class ItemPropsHandler extends BaseTypeHandler<List<Prop>> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, List<Prop> parameter, JdbcType jdbcType) throws SQLException {
        PGobject obj = new PGobject();
        obj.setType("json");
        obj.setValue(JSON.toJSONString(parameter));
        ps.setObject(i, obj);
    }

    @Override
    public List<Prop> getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return JSON.parseArray(rs.getString(columnName), Prop.class);
    }

    @Override
    public List<Prop> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return JSON.parseArray(rs.getString(columnIndex), Prop.class);
    }

    @Override
    public List<Prop> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return JSON.parseArray(cs.getString(columnIndex), Prop.class);
    }
}
