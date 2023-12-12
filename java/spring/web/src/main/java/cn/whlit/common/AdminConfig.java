package cn.whlit.common;

import cn.whlit.domain.User;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author WangHaiLong 2023/12/13 0:00
 */
@Configuration
@ConfigurationProperties(prefix = "admin")
public class AdminConfig {

    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
