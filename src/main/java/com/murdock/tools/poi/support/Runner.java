package com.murdock.tools.poi.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * @author weipeng2k 2018年09月13日 下午18:57:16
 */
@Component
public class Runner implements CommandLineRunner {

    @Autowired
    private Input input;

    @Autowired
    private Output output;

    @Override
    public void run(String... args) throws Exception {
        if (args.length == 2) {
            File source = new File(args[0]);
            File target = new File(args[1]);

            int load = input.load(source);
            output.create(target);

            input.consumer(output);

            input.start();

            int flush = output.flush();

            System.out.println(String.format("load %d entry, and write %d entry.", load, flush));
        } else {
            System.err.println("args length must be only two, source and target.");
        }
    }
}
