package cn.whlit.visitor;

import java.util.Random;

/**
 * @author WangHaiLong 2023/5/8 16:45
 */
public class ObjectStructure {
    public static Element createElement(){
        Random random = new Random();
        if (random.nextInt(100) > 50) {
            return new ConcreteElement1();
        }else {
            return new ConcreteElement2();
        }
    }
}
