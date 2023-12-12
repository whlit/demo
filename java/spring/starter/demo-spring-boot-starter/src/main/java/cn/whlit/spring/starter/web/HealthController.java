package cn.whlit.spring.starter.web;

import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther WangHaiLong 2023/9/10 10:44
 */
@RestController
@ConditionalOnWebApplication
public class HealthController {

    @GetMapping("health")
    public String health(){
        return "success";
    }
}
