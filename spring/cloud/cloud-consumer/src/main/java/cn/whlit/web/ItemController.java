package cn.whlit.web;

import cn.whlit.api.ItemClient;
import cn.whlit.common.Result;
import cn.whlit.domain.ItemDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @auther WangHaiLong 2023/8/12 22:58
 */
@RestController
public class ItemController {

    private static final String REST_PROVIDER_URL_PREFIX = "http://provider";
    @Resource
    private RestTemplate restTemplate;

    @Resource
    private ItemClient itemClient;

    @GetMapping("test")
    public Result<ItemDTO> test(){
//        return restTemplate.exchange(
//                REST_PROVIDER_URL_PREFIX + "/test",
//                HttpMethod.GET,
//                null,
//                new ParameterizedTypeReference<Result<ItemDTO>>(){}
//        ).getBody();
        return itemClient.test();
    }
}
