package cn.whlit.mapper;

import cn.whlit.entity.Item;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author WangHaiLong 2024/1/1 16:58
 */
@Mapper
public interface ItemMapper {

    Item selectById(Integer id);

    void insert(Item item);

}
