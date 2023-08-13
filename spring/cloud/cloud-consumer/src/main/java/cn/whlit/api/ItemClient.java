package cn.whlit.api;

import cn.whlit.common.Result;
import cn.whlit.domain.ItemDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @auther WangHaiLong 2023/8/12 23:25
 */
@FeignClient("provider")
public interface ItemClient {


    @GetMapping("/test")
    Result<ItemDTO> test();

}
