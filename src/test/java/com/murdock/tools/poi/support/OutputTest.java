package com.murdock.tools.poi.support;

import com.murdock.tools.poi.Entry;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

import static org.junit.Assert.*;

/**
 * @author weipeng2k 2018年09月17日 下午14:18:28
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OutputTest {

    @Autowired
    private Output output;

    @Test
    public void create() {
        File file = new File("test");
        output.create(file);

        file.deleteOnExit();
    }

    @Test
    public void flush() {
        File file = new File("test");
        output.create(file);
        Entry entry = new Entry();
        entry.setUrl("http://www.sohu.com");

        output.accept(entry);
        output.accept(entry);
        output.accept(entry);
        output.accept(entry);

        int flush = output.flush();
        assertEquals(4, flush);
        file.deleteOnExit();
    }
}