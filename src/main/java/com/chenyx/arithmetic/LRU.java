package com.chenyx.arithmetic;

import com.sun.org.apache.bcel.internal.generic.NEW;
import org.apache.commons.lang3.StringUtils;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/***
 * @desc LRU（最近最少使用算法）：
 * 思路：
 *  1假设我们使用哈希链表来缓存用户信息，目前缓存了4个用户，这4个用户是按照时间顺序依次从链表右端插入的。
 *  2.此时，业务方访问用户5，由于哈希链表中没有用户5的数据，我们从数据库中读取出来，插入到缓存当中。
 *  这时候，链表中最右端是最新访问到的用户5，最左端是最近最少访问的用户1。
 *  3、接下来，业务方访问用户2，哈希链表中存在用户2的数据，我
 *  们把用户2从它的前驱节点和后继节点之间移除，
 *  重新插入到链表最右端。这时候，链表中最右端变成了最新访问到的用户2，最左端仍然是最近最少访问的用户1。
 *  4.接下来，业务方请求修改用户4的信息。同样道理，我们把用户4从原来的位置移动到链表最右侧，
 *  并把用户信息的值更新。这时候，链表中最右端是最新访问到的用户4，最左端仍然是最近最少访问的用户1。
 *  5.后来业务方换口味了，访问用户6，用户6在缓存里没有，需要插入到哈希链表。假设这时候缓存容量已经达到上限，
 *  必须先删除最近最少访问的数据，那么位于哈希链表最左端的用户1就会被删除掉，然后再把用户6插入到最右端
 *
 * @author  chenyx
 *  @date  2018-11-07
 * */
public class LRU <T>{


    private final static Integer MAX_LENGTH = Integer.MAX_VALUE;//最大存储

    private Map<String ,Node> elementMap = new HashMap<>();//元素结合

    private Node headNode ;//头结点
    private int limlt;//目前已存储的节点

    private int removeCount = 16;//需要移除的个数


    /**
     * 初始化存储大小
     * */
    public LRU(int limlt, int removeCount) {
        if (limlt > MAX_LENGTH) {
            limlt = MAX_LENGTH;
        }
        this.limlt = limlt;
        int total = limlt/2;
        if (removeCount < total) {
            this.removeCount = removeCount;
        }
    }

    /**
     *  存储
     * */
    public void put(String key,T t){
        if (StringUtils.isEmpty(key)) {
            throw  new RuntimeException("key 不能为空值！");
        }
        int length = this.length() + 1;
        if (length > limlt) {
            removeNode(removeCount);
        }
        Node node = this.elementMap.get(key);
        if (node == null) {
            Node newNode = new Node(t, key);
            addNode(newNode);
            this.elementMap.put(key,newNode);
        }else {
            node.setEle(t);
        }
    }

    /**
     * 移除节点
     * */
    private void removeNode(int removeNum) {
        int size = this.length();
        if (removeNum >= size) {
            removeNum = size / 2;
        }
        Node currntNode = headNode;
        int i = 0;
        while ( i < removeNum) {
            removeNode(currntNode);
            currntNode = currntNode.getNextNode();
            i ++;
        }
        headNode = currntNode;
        headNode.setPrevNode(null);
    }

    /**
     * 删除单个节点
     *
     * */
    private void removeNode(Node currntNode) {
        if (currntNode.getPrevNode() == null) {
            headNode = currntNode.getNextNode();
        }else {
            currntNode.getPrevNode().setNextNode(currntNode.getNextNode());
            currntNode.getNextNode().setPrevNode(currntNode.getPrevNode());
        }
        this.elementMap.remove(currntNode.getKey());
    }

    /**
     * 移除
     * */
    public void remove(String key) {
       Node node = this.elementMap.get(key);
       if (node == null) {
           return;
       }
       removeNode(node);
    }
    /**
     * 更新
     * */
    public void update(String key,T newEle) {
        Node node = this.elementMap.get(key);
        if (node == null) {
           put(key,newEle);
        }else {
            node.setEle(newEle);
            removeNode(node);
            put(key,newEle);
        }
    }

    /**
     * 新增节点
     *
     * */
    private void addNode(Node newNode) {
        if (newNode == null) {
            throw new RuntimeException("新插入节点不能为空！");
        }
        Node currentNode = headNode;
        if (currentNode == null) {
            headNode = newNode;
        }else {
            while (currentNode.getNextNode() != null) {
                currentNode = currentNode.getNextNode();
            }
            currentNode.setNextNode(newNode);
            newNode.setPrevNode(currentNode);
        }
    }

    /**
     * 存储量
     *
     * */
    public int length(){
        int length = 0;
        if (this.elementMap == null) {
            return length;
        }
        Set set = this.elementMap.keySet();
        if (set == null) {
            return length;
        }
        length = set.size();
        return length;
    }

    /**
     * 节点
     *
     * */
    private final class Node {

        private T ele;//元素
        private String key;
        private Node prevNode;//前驱
        private Node nextNode;//后继

        public Node(T ele, String key) {
            this.ele = ele;
            this.key = key;
        }

        public Node(T ele, String key, Node prevNode, Node nextNode) {
            this.ele = ele;
            this.key = key;
            this.prevNode = prevNode;
            this.nextNode = nextNode;
        }

        public T getEle() {
            return ele;
        }

        public void setEle(T ele) {
            this.ele = ele;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public Node getPrevNode() {
            return prevNode;
        }

        public void setPrevNode(Node prevNode) {
            this.prevNode = prevNode;
        }

        public Node getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }
    }
}

