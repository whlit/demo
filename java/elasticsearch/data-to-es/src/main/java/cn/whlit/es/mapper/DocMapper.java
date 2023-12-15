package cn.whlit.es.mapper;

import cn.whlit.spring.es.models.Doc;
import org.apache.ibatis.annotations.*;

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
    @Select("SELECT p.id, p.title, p.ns, p.redirect, " +
            "r.id as rid, r.parent_id, r.timest, r.`comment`, r.model, r.format, r.sha1, r.size, r.content, " +
            "u.id as uid, u.user_name " +
            "from page p " +
            "LEFT JOIN revision r on p.revision_id = r.id " +
            "LEFT JOIN `user` u on r.contributor_id = u.id " +
            "WHERE p.id = #{id}")
    Doc selectById(Integer id);


}
