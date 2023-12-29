package cn.whlit.es.manage;

import cn.whlit.es.mapper.DocMapper;
import cn.whlit.spring.es.models.Doc;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.function.Consumer;

/**
 * @author WangHaiLong 2023/12/19 21:28
 */
@Component
public class DocManager {
    @Resource
    private DocMapper docMapper;

    public void consumer(Consumer<Doc> docConsumer){

    }
}
