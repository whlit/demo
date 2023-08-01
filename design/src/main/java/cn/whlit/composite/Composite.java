package cn.whlit.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WangHaiLong 2023/5/6 21:29
 */
public class Composite extends Component{
    private List<Component> components = new ArrayList<>();
    //增加一个叶子或者树枝构件
    public void add(Component component){
        this.components.add(component);
    }
    //删除一个叶子或者树枝构件
    public void remove(Component component){
        this.components.remove(component);
    }
    //获得分支下的所有叶子构件和树枝构件
    public List<Component> getChildren(){
        return this.components;
    }
}
