package cn.whlit.classloader;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

/**
 * @author WangHaiLong 2023/8/5 18:55
 */
public class MyClassLoader extends ClassLoader{

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            //这里只是作为示例使用，文件地址以及class name直接写死了
            URL url = this.getClass().getResource("/DemoClass.class");
            URI uri = Objects.requireNonNull(url).toURI();
            byte[] data = Files.readAllBytes(Paths.get(uri));
            return defineClass("cn.whlit.classloader.DemoClass", data, 0, data.length);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        return super.findClass(name);
    }
}
