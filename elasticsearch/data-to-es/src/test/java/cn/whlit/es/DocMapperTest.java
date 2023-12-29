package cn.whlit.es;

import cn.whlit.es.mapper.DocMapper;
import cn.whlit.es.repository.DocRepository;
import cn.whlit.spring.es.models.Doc;
import cn.whlit.spring.es.models.DocSelectParam;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author WangHaiLong 2023/12/15 17:21
 */
@SpringBootTest
public class DocMapperTest {

    @Autowired
    private DocMapper docMapper;
    @Autowired
    private DocRepository docRepository;

    @Test
    public void selectById(){
        Doc doc = docMapper.selectById(66);
        System.out.println(doc);
    }
    @Test
    public void saveById(){
        Doc doc = docMapper.selectById(70);
        docRepository.save(doc);
    }

    @Test
    public void selectByIds(){
        DocSelectParam param = new DocSelectParam();
        param.setIds(Lists.list(66, 67));
        List<Doc> docs = docMapper.select(param);
        System.out.println();
    }
}
