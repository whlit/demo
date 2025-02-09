package cn.whlit.spring.web;


import cn.whlit.spring.dao.ItemMapper;
import cn.whlit.spring.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author WangHaiLong 2025/1/17 18:16
 */
@RestController
@RequestMapping("item")
public class ItemController {

    @Autowired
    private ItemMapper itemMapper;

    @GetMapping("{id}")
    public Item getItem(@PathVariable Integer id) {
        return itemMapper.selectById(id);
    }

    @PostMapping("insert")
    public void insertItem(@RequestBody Item item) {
        itemMapper.insert(item);
    }

}
