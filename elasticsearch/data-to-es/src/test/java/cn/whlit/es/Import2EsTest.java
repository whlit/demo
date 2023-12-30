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
 * @author WangHaiLong 2023/12/30 13:28
 */
@SpringBootTest
public class Import2EsTest {

    @Autowired
    private DocMapper docMapper;

    @Autowired
    private DocRepository docRepository;

    @Test
    public void importTest() {
        DocSelectParam param = new DocSelectParam();
        param.setIds(Lists.list(45, 48, 51, 53, 56, 57, 59, 62, 66, 67, 70, 72, 74, 76, 78, 79, 81, 83, 86, 87, 89, 94));
        List<Doc> docs = docMapper.select(param);
        docRepository.saveAll(docs);
    }

}
