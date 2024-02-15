package cn.whlit.spring.md.web;

import cn.whlit.spring.md.entity.Item;
import cn.whlit.spring.md.service.ItemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author WangHaiLong 2024/2/4 12:41
 */
@RestController
@RequestMapping("item")
public class ItemController {
    @Resource
    private ItemService itemService;
    @GetMapping("/{id}")
    public Item getById(@PathVariable("id") Integer id){
        return itemService.getById(id);
    }
}
