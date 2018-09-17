package com.murdock.tools.poi.support;

import com.murdock.tools.poi.Entry;

import java.io.File;
import java.util.function.Consumer;

/**
 * load excel file, and process it.
 *
 * @author weipeng2k 2018年09月13日 下午19:02:36
 */
public interface Input {

    /**
     * load excel
     *
     * @param file excel path
     * @return row numbers
     */
    int load(File file) throws Exception;

    /**
     * size
     *
     * @return size of rows.
     */
    int size();

    /**
     * consumer
     *
     * @param consumer consumer
     */
    void consumer(Consumer<Entry> consumer);

    /**
     * start consume
     */
    void start();
}
