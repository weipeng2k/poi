package com.murdock.tools.poi.support;

import com.murdock.tools.poi.Entry;

import java.io.File;
import java.util.function.Consumer;

/**
 * @author weipeng2k 2018年09月13日 下午19:05:21
 */
public interface Output extends Consumer<Entry> {

    /**
     * just create file for output
     *
     * @param file output file
     */
    void create(File file);

    /**
     * flush content to disk.
     *
     * @return row number
     */
    int flush();
}
