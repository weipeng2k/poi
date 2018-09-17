package com.murdock.tools.poi.support.impl;

import com.alibaba.fastjson.JSON;

import com.murdock.tools.poi.Entry;
import com.murdock.tools.poi.SourceEntry;
import com.murdock.tools.poi.support.Input;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * @author weipeng2k 2018年09月13日 下午19:10:18
 */
@Service
public class InputImpl implements Input {

    private XSSFSheet sheet;

    private Consumer<Entry> consumer;

    @Override
    public int load(File file) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(file);
        // 1. 创建工作簿
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        // 2. 创建工作类
        sheet = workbook.getSheetAt(0);

        return sheet.getLastRowNum() - 1;
    }

    @Override
    public int size() {
        return sheet.getLastRowNum() - 1;
    }

    @Override
    public void consumer(Consumer<Entry> consumer) {
        this.consumer = consumer;
    }


    @Override
    public void start() {
        sheet.forEach(row -> {
            try {
                Cell cell = row.getCell(1);
                String stringCellValue = cell.getStringCellValue();
                SourceEntry sourceEntry = JSON.parseObject(stringCellValue, SourceEntry.class);

                Cell reason = row.getCell(2);
                if (reason != null) {
                    sourceEntry.setReason(reason.getStringCellValue());
                }

                Cell note = row.getCell(3);
                if (note != null) {
                    sourceEntry.setNote(note.getStringCellValue());
                }

                sourceEntry.getPicUrls().stream()
                        .filter(Objects::nonNull)
                        .map(url -> {
                            Entry entry = new Entry();
                            entry.setUrl(url);
                            entry.setReason(sourceEntry.getReason());
                            entry.setNote(sourceEntry.getNote());
                            return entry;
                        })
                        .forEach(consumer);
            } catch (Exception ex) {
                // Ignore.
            }
        });
    }


}
