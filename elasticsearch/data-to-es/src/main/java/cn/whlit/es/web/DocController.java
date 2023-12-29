package cn.whlit.es.web;

import cn.whlit.es.mapper.DocMapper;
import cn.whlit.spring.es.models.Doc;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author WangHaiLong 2023/12/15 18:15
 */
@RestController
@RequestMapping("doc")
public class DocController {

    @Resource
    private DocMapper docMapper;

    @GetMapping("{id}")
    public Doc getById(@PathVariable Integer id){
        return docMapper.selectById(id);
    }

}
