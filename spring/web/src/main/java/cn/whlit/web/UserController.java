package cn.whlit.web;

import cn.whlit.common.AdminConfig;
import cn.whlit.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author WangHaiLong 2023/12/13 0:02
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private AdminConfig adminConfig;

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;
    @Autowired
    private RedisTemplate<String, String> stringRedisTemplate;

    @GetMapping("admins")
    public List<User> admins(){
        String s = "";
        List<User> users = adminConfig.getUsers();
        return users;
    }
}
