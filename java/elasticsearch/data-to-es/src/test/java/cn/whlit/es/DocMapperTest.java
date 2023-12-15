package cn.whlit.es;

import cn.whlit.es.mapper.DocMapper;
import cn.whlit.spring.es.models.Doc;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author WangHaiLong 2023/12/15 17:21
 */
@SpringBootTest
public class DocMapperTest {

    @Autowired
    private DocMapper docMapper;

    @Test
    public void selectById(){
        Doc doc = docMapper.selectById(66);
        System.out.println(doc);
    }
}
