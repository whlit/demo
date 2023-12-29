package cn.whlit.es.mapper;

import cn.whlit.spring.es.models.Doc;
import cn.whlit.spring.es.models.DocSelectParam;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.builder.annotation.ProviderMethodResolver;
import org.apache.ibatis.jdbc.SQL;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author WangHaiLong 2023/12/15 16:56
 */
@Mapper
public interface DocMapper {

    @Results(id = "doc", value = {
            @Result(column = "id", property = "id", id = true),
            @Result(column = "title", property = "title"),
            @Result(column = "ns", property = "ns"),
            @Result(column = "redirect", property = "redirect"),

            @Result(column = "rid", property = "revision.id"),
            @Result(column = "parent_id", property = "revision.parentId"),
            @Result(column = "timest", property = "revision.timestamp"),
            @Result(column = "comment", property = "revision.comment"),
            @Result(column = "model", property = "revision.model"),
            @Result(column = "format", property = "revision.format"),
            @Result(column = "sha1", property = "revision.sha1"),
            @Result(column = "size", property = "revision.size"),
            @Result(column = "content", property = "revision.text"),

            @Result(column = "uid", property = "revision.contributor.id"),
            @Result(column = "user_name", property = "revision.contributor.userName"),
    })
    @SelectProvider(SqlProvider.class)
    Doc selectById(Integer id);

    @SelectProvider(SqlProvider.class)
    Doc select(DocSelectParam param);

    class SqlProvider implements ProviderMethodResolver{
        private static final String columns = "p.id, p.title, p.ns, p.redirect, " +
                "r.id as rid, r.parent_id, r.timest, r.`comment`, r.model, r.format, r.sha1, r.size, r.content, " +
                "u.id as uid, u.user_name ";
        private static final String table = "page p " +
                "LEFT JOIN revision r on p.revision_id = r.id " +
                "LEFT JOIN `user` u on r.contributor_id = u.id";
        public static String selectById(Integer id){
            SQL sql = new SQL();
            sql.SELECT(columns).FROM(table).WHERE("p.id = #{id}");
            return sql.toString();
        }

        public static String select(DocSelectParam param){
            SQL sql = new SQL();
            sql.SELECT(columns).FROM(table);
            if (Objects.isNull(param)){
                return sql.toString();
            }
            if (Objects.nonNull(param.getId())){
                return sql.WHERE("id = #{id}").toString();
            }
            if (Objects.nonNull(param.getIds()) && !param.getIds().isEmpty()){
            }
            List<String> conditions = new ArrayList<>();
            return sql.toString();
        }

    }

}
