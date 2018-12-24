package com.chenyx.arithmetic;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LRUTest {

    private LRU<String> lru ;

    @Before
    public void setUp(){
        lru = new LRU<>(3,1);
    }
    @After
    public void tear() {
     lru = null;
    }
    @Test
    public void put() throws Exception {
        lru.put("1","1");
        System.out.println(lru.length());
        lru.put("2","2");
        System.out.println(lru.length());
        lru.put("3","3");
        System.out.println(lru.length());
        lru.put("4","4");
        lru.update("3","6");
        System.out.println(lru.length());
    }

    @Test
    public void remove() throws Exception {
    }

    @Test
    public void update() throws Exception {
    }





}