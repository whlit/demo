package cn.whlit.dubbo.service;

import cn.whlit.ItemService;
import cn.whlit.domain.ItemDTO;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @auther WangHaiLong 2023/8/14 23:08
 */
@DubboService(registry = {"nacos"}, version = "1.0.0", timeout = 3000)
public class ItemServiceImpl implements ItemService {
    @Override
    public ItemDTO test() {
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setId(1L);
        itemDTO.setNumber("demo_item");
        itemDTO.setName("This is a Demo");
        return itemDTO;
    }

    @Override
    public void add(ItemDTO itemDTO) {

    }
}
