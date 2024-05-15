package cn.whlit.maven.tree;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * @author WangHaiLong 2024/5/14 22:18
 */
public class BpTreeTest {

    @Test
    public void test()
    {
        BpTree<Integer> tree = new BpTree<>(3);
        tree.add(12);
        tree.add(22);
        tree.add(34);
        tree.add(45);
        tree.add(15);
        tree.add(16);
        tree.add(37);
        tree.add(38);
        Assert.assertEquals(2, tree.root.values.size());
        Assert.assertEquals(22, tree.root.values.get(0).intValue());
        Assert.assertEquals(37, tree.root.values.get(1).intValue());

        List<BpTree<Integer>.Node> children1 = tree.root.children;
        Assert.assertEquals(3, children1.size());
        
        Assert.assertEquals(1, children1.get(0).values.size());
        Assert.assertEquals(15, children1.get(0).values.get(0).intValue());
        List<BpTree<Integer>.Node> children1_0 = children1.get(0).children;
        Assert.assertEquals(2, children1_0.size());

        Assert.assertEquals(1, children1_0.get(0).values.size());
        Assert.assertEquals(12, children1_0.get(0).values.get(0).intValue());
        Assert.assertEquals(2, children1_0.get(1).values.size());
        Assert.assertEquals(15, children1_0.get(1).values.get(0).intValue());
        Assert.assertEquals(16, children1_0.get(1).values.get(1).intValue());

        Assert.assertEquals(1, children1.get(1).values.size());
        Assert.assertEquals(34, children1.get(1).values.get(0).intValue());
        List<BpTree<Integer>.Node> children1_1 = children1.get(1).children;
        Assert.assertEquals(2, children1_1.size());

        Assert.assertEquals(1, children1_1.get(0).values.size());
        Assert.assertEquals(22, children1_1.get(0).values.get(0).intValue());
        Assert.assertEquals(1, children1_1.get(1).values.size());
        Assert.assertEquals(34, children1_1.get(1).values.get(0).intValue());
        
        Assert.assertEquals(1, children1.get(2).values.size());
        Assert.assertEquals(38, children1.get(2).values.get(0).intValue());
        List<BpTree<Integer>.Node> children1_2 = children1.get(2).children;
        Assert.assertEquals(2, children1_2.size());

        Assert.assertEquals(1, children1_2.get(0).values.size());
        Assert.assertEquals(37, children1_2.get(0).values.get(0).intValue());
        Assert.assertEquals(2, children1_2.get(1).values.size());
        Assert.assertEquals(38, children1_2.get(1).values.get(0).intValue());
        Assert.assertEquals(45, children1_2.get(1).values.get(1).intValue());
    }
}
