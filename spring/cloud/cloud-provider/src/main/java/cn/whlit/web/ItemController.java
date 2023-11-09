package cn.whlit.web;

import cn.whlit.common.Result;
import cn.whlit.domain.ItemDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther WangHaiLong 2023/8/12 22:12
 */
@RestController
public class ItemController {

    @GetMapping("test")
    public Result<ItemDTO> test(){
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setId(1L);
        itemDTO.setNumber("demo_item");
        itemDTO.setName("This is a Demo");
        return Result.success(itemDTO);
    }

}
