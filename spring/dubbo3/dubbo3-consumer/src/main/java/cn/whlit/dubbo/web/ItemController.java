package cn.whlit.dubbo.web;

import cn.whlit.ItemService;
import cn.whlit.common.Result;
import cn.whlit.domain.ItemDTO;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther WangHaiLong 2023/8/14 23:16
 */
@RestController
public class ItemController {

    @DubboReference
    private ItemService itemService;

    @GetMapping("test")
    public Result<ItemDTO> test(){
        return Result.success(itemService.test());
    }
}
