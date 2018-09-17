package com.murdock.tools.poi.support;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

import static org.junit.Assert.*;

/**
 * @author weipeng2k 2018年09月17日 上午11:11:09
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class InputTest {

    @Autowired
    private Input input;

    @Before
    public void init() throws Exception {
        File file = new File("/Users/weipeng2k/Documents/workspace/poi/src/test/resources/pass-one.xlsx");
        input.load(file);
    }

    @Test
    public void create() {
        assertNotNull(input);
    }

    @Test
    public void load() {
        assertEquals(2, input.size());
    }

    @Test
    public void consumer() {
        input.consumer(System.out::println);
    }

    @Test
    public void start() {
        input.consumer(System.out::println);

        input.start();
    }
}