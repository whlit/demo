package cn.whlit.maven.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.logging.log4j.util.Strings;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

/**
 * @author WangHaiLong 2024/5/30 10:47
 */
public class JsonFilter {

    private static final String fmt = "%s.%s";

    public String filter(final String source, String... filters) {
        JSONObject root = JSON.parseObject(source);
        List<String> list = Stream.of(filters).map(filter -> filter
                        .replace("$.", "")
                        .replaceAll("\\[\\d+\\]", ""))
                .toList();
        filter(root, "", list);
        return JSON.toJSONString(root);
    }

    private void filter(Object node, String parent, List<String> includes){
        if (node instanceof JSONObject){
            Set<String> propNames = new HashSet<>(((JSONObject) node).keySet());
            List<String> ins = Strings.isEmpty(parent) ? includes : includes.stream().filter(f -> f.startsWith(parent)).toList();
            for (String propName : propNames) {
                String path = Strings.isEmpty(parent) ? propName : String.format(fmt, parent, propName);
                boolean flag = false;
                for (String include : ins) {
                    if (include.startsWith(path)){
                        flag = true;
                        filter(((JSONObject) node).get(propName), path, includes);
                    }
                }
                if (!flag){
                    ((JSONObject) node).remove(propName);
                }
            }
        } else if (node instanceof JSONArray){
            JSONArray array = (JSONArray) node;
            for (Object o : array) {
                filter(o, parent, includes);
            }
        }
    }

    public static void main(String[] args) {
        String json = "{\n" +
                "    \"open\": 1,\n" +
                "    \"name\": \"热门故事\",\n" +
                "    \"items\": [\n" +
                "        {\n" +
                "            \"title\": \"桂林志异：龙王起水\",\n" +
                "            \"url\": \"https://www.jianshu.com/p/9f168be225b0\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"title\": \"离婚后，妈宝男前夫后悔了\",\n" +
                "            \"url\": \"https://www.jianshu.com/p/ea8d12548641\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"title\": \"救了他两次的神仙让他今天三更去死\",\n" +
                "            \"url\": \"https://www.jianshu.com/p/1ded57e57939\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"title\": \"我把眼角膜捐给丈夫的白月光后，他疯了 \",\n" +
                "            \"url\": \"https://www.jianshu.com/p/946923c8224f\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"title\": \"为了活命，我对病娇反派弟弟表白，他竟当真要做我夫君\",\n" +
                "            \"url\": \"https://www.jianshu.com/p/abb1ac30da8b\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"title\": \"“有个坐过牢的富豪老公是种什么体验？”“要不然你来试试？”\",\n" +
                "            \"url\": \"https://www.jianshu.com/p/0f38a77e0bd7\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"title\": \"前世渣男把我迷晕还叫我别怕，重生后我杀疯了\",\n" +
                "            \"url\": \"https://www.jianshu.com/p/e8cfb8f2154e\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"title\": \"妹妹过失杀人，警察来时，我捡起了那把滴血的刀\",\n" +
                "            \"url\": \"https://www.jianshu.com/p/3a1958255a4a\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"title\": \"我被校霸堵在巷口，却发现他是我谈了三个月的网恋对象\",\n" +
                "            \"url\": \"https://www.jianshu.com/p/875b89eba857\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"title\": \"我首富之女的身份居然被人偷了\",\n" +
                "            \"url\": \"https://www.jianshu.com/p/dbe39342ae8e\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        String filter = new JsonFilter().filter(json,
                "items.title",
                "items.number",
                "name",
                "age");
        System.out.println(filter);
    }
}
