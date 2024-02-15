package cn.whlit.spring.md.config;

/**
 * @author WangHaiLong 2024/2/15 21:26
 */
public class DataSourceHolder {

    private static final ThreadLocal<String> DATA_SOURCES = new ThreadLocal<>();

    public static void setDataSource(String dataSource) {
        DATA_SOURCES.set(dataSource);
    }

    public static String getDataSource() {
        return DATA_SOURCES.get();
    }

    public static void removeDataSource() {
        DATA_SOURCES.remove();
    }
}
