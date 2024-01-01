package cn.whlit.mapper;

import cn.whlit.BaseTest;
import cn.whlit.ItemType;
import cn.whlit.entity.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author WangHaiLong 2024/1/1 17:24
 */
public class ItemMapperTest extends BaseTest {

    @Autowired
    private ItemMapper itemMapper;
    @Test
    public void testSelectById(){
        Item item = itemMapper.selectById(1);
        System.out.println(item.toString());
    }

    @Test
    public void testInsert(){
        Item item = new Item();
        item.setName("苹果");
        item.setType(ItemType.FRUIT);
        itemMapper.insert(item);
        System.out.println(item.getId());
    }
}
