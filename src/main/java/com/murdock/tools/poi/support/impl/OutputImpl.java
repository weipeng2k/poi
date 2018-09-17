package com.murdock.tools.poi.support.impl;

import com.murdock.tools.poi.Entry;
import com.murdock.tools.poi.support.Output;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author weipeng2k 2018年09月13日 下午19:10:44
 */
@Service
public class OutputImpl implements Output {

    private File file;

    private PrintWriter printWriter;

    private AtomicInteger count = new AtomicInteger();

    @Override
    public void create(File file) {
        try {
            file.createNewFile();
            this.file = file;
            printWriter = new PrintWriter(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int flush() {
        printWriter.flush();
        return count.get();
    }

    @Override
    public void accept(Entry s) {
        if (s != null) {
            printWriter.println(s.render());
            count.incrementAndGet();
        }
    }
}
