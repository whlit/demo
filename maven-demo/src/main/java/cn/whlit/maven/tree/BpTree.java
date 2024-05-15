package cn.whlit.maven.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WangHaiLong 2024/5/14 18:38
 */
public class BpTree<T extends Comparable<T>> {

    protected Node root;
    protected int max;
    protected static final int DEFAULT_MAX = 2;
    protected Node head;

    public BpTree() {
        this.max = DEFAULT_MAX;
    }

    public BpTree(int max) {
        this.max = max;
    }

    public void add(T value) {
        // 根节点为空
        if (root == null) {
            root = new Node(value);
            return;
        }
        Node node = root;
        A:
        for (; ; ) {
            if (!node.isLeaf) {
                // 不是叶子节点则遍历节点
                for (int i = 0; i < node.values.size(); i++) {
                    if (node.values.get(i).compareTo(value) >= 0) {
                        node = node.children.get(i);
                        continue A;
                    }
                }
                node = node.children.getLast();
                continue;
            }
            // 如果是叶子节点直接添加值
            node.values.add(value);
            node.values.sort(T::compareTo);
            // 已经添加值到叶子节点
            B:
            for (; ; ) {
                // 如果节点中存储的值个数没有超最大值则直接返回
                if (node.values.size() <= max - 1) {
                    return;
                }
                // 叶子节点中值个数超过最大值则需要分裂节点
                Node parent = node.parent;
                T key = node.values.get(max / 2);
                // 创建右节点
                Node r = new Node(new ArrayList<>(node.values.subList(node.isLeaf ? max / 2 : max / 2 + 1, node.values.size())), parent);
                r.isLeaf = node.isLeaf;
                // 更改左节点
                node.values = new ArrayList<>(node.values.subList(0, max / 2));
                // 索引节点添加子节点
                if (!node.isLeaf) {
                    r.children = new ArrayList<>(node.children.subList(max / 2 + 1, node.children.size()));
                    // 更改子节点的父节点为创建的右节点
                    for (Node child : r.children) {
                        child.parent = r;
                    }
                    node.children = new ArrayList<>(node.children.subList(0, max / 2 + 1));
                }
                // 添加父节点
                if (parent == null) {
                    // 为空则node为根节点 分裂后创建新的根节点
                    parent = new Node(key);
                    parent.isLeaf = false;
                    parent.children = new ArrayList<>();
                    parent.children.add(node);
                    parent.children.add(r);
                    node.parent = parent;
                    r.parent = parent;
                    root = parent;
                } else {
                    // 不是根节点的将分裂后的节点添加到父节点中
                    for (int i = 0; i < parent.values.size(); i++) {
                        if (parent.values.get(i).compareTo(key) >= 0) {
                            parent.values.add(i, key);
                            parent.children.add(i+1, r);
                            node = parent;
                            continue B;
                        }
                    }
                    parent.values.add(key);
                    parent.children.add(r);
                }
                node = parent;
            }
        }

    }




    class Node {
        /**
         * 节点是否是叶子节点
         */
        protected boolean isLeaf;
        /**
         * 父节点
         */
        protected Node parent;
        /**
         * 叶节点中前一个节点
         */
        protected Node prev;
        /**
         * 叶节点中后一个节点
         */
        protected Node next;
        /**
         * 节点中存储的值
         */
        protected List<T> values;
        /**
         * 节点中存储的子节点
         */
        protected List<Node> children;

        public Node(T value) {
            this.values = new ArrayList<>();
            this.values.add(value);
            this.isLeaf = true;
        }

        public Node(List<T> values, Node parent) {
            this.values = values;
            this.parent = parent;
            this.isLeaf = true;
        }

    }
}
