package cn.whlit.cloud.alibaba.web;

import cn.whlit.common.Result;
import cn.whlit.domain.ItemDTO;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @auther WangHaiLong 2023/8/13 21:10
 */
@RestController
public class ItemController {

    @Resource(name = "balancedRestTemp")
    private RestTemplate restTemplate;

    @Resource(name = "restTemp")
    private RestTemplate restTemplate2;

    @Resource
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("test")
    public Result<ItemDTO> test(){
        return restTemplate.exchange("http://cloud-alibaba-provider/test", HttpMethod.GET, null, new ParameterizedTypeReference<Result<ItemDTO>>() {}).getBody();
    }

    @GetMapping("test2")
    public Result<ItemDTO> test2(){
        ServiceInstance instance = loadBalancerClient.choose("cloud-alibaba-provider");
        String url = String.format("http://%s:%s/test", instance.getHost(), instance.getPort());
        return restTemplate2.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<Result<ItemDTO>>() {}).getBody();
    }
}
