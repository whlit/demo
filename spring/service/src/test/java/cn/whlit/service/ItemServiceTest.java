package cn.whlit.service;

import cn.whlit.BaseTest;
import cn.whlit.ItemService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author WangHaiLong 2024/7/10 22:25
 */
@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
public class ItemServiceTest extends BaseTest {

    @Autowired
    private ItemService itemService;

    @Test
    public void test(){
        itemService.test();
    }

}
