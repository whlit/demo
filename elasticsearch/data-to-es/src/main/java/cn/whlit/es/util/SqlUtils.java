package cn.whlit.es.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.AbstractSQL;

import java.util.List;
import java.util.Objects;

/**
 * @author WangHaiLong 2023/12/29 15:47
 */
public class SqlUtils {


    public static <T extends AbstractSQL<T>> void isNotNull(T sql, Object value, String column, String property) {
        where(sql, Objects.isNull(value), column, property);
    }

    public static <T extends AbstractSQL<T>> void isNotEmpty(T sql, String value, String column, String property) {
        where(sql, StringUtils.isEmpty(value), column, property);
    }

    public static <T extends AbstractSQL<T>> void isNotBlank(T sql, String value, String column, String property) {
        where(sql, StringUtils.isNotBlank(value), column, property);
    }



    public static <T extends AbstractSQL<T>> void where(T sql, boolean test, String column, String property) {
        where(sql, test, String.format("%s = #{%s}", column, property));
    }

    public static <T extends AbstractSQL<T>> void where(T sql, boolean test, String condition) {
        if (test) {
            sql.WHERE(condition);
        }
    }

    public static <T> String in(String keyword, List<T> items, ForEachFunction<T> function) {
        return in(keyword, items, "(", ")", ",", function);
    }

    public static <T> String in(String keyword, List<T> items, String open, String close,
                                String conjunction, ForEachFunction<T> function) {
        StringBuilder sb = new StringBuilder();
        sb.append(keyword).append(" in ").append(open);
        for (int i = 0; i < items.size(); i++) {
            if (i > 0) {
                sb.append(conjunction).append(" ");
            }
            sb.append(function.apply(items.get(i), i));
        }
        sb.append(close);
        return sb.toString();
    }

    public static <T extends AbstractSQL<T>> void limit(T sql, Integer page, Integer pageSize) {
        if (page == null) {
            return;
        }
        if (page < 1) {
            page = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        sql.LIMIT(page).OFFSET((long) pageSize * (page - 1));
    }

    public interface ForEachFunction<E> {
        String apply(E element, int index);
    }


}
