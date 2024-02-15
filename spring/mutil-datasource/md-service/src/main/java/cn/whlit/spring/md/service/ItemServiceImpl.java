package cn.whlit.spring.md.service;

import cn.whlit.spring.md.dao.ItemMapper;
import cn.whlit.spring.md.entity.Item;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author WangHaiLong 2024/2/4 12:40
 */
@Service
public class ItemServiceImpl implements ItemService{
    @Resource
    private ItemMapper itemMapper;
    @Override
    public Item getById(Integer id) {
        return itemMapper.getById(id);
    }
}
