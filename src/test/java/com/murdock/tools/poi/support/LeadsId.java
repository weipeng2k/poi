package com.murdock.tools.poi.support;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

/**
 * @author weipeng2k 2019年12月09日 下午14:40:05
 */
public class LeadsId {

    @Test
    public void split() throws Exception {
        FileInputStream fileInputStream = new FileInputStream("/Users/weipeng2k/Desktop/1.xlsx");
        // 1. 创建工作簿
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        // 2. 创建工作类
        XSSFSheet sheet = workbook.getSheetAt(0);

        PrintWriter out = new PrintWriter(new FileOutputStream("/Users/weipeng2k/Desktop/1.txt"));

        sheet.forEach(row -> {
            if (row.getCell(0).getCellTypeEnum() == CellType.NUMERIC) {
                out.println((long)row.getCell(0).getNumericCellValue());
            }
        });

        out.flush();
    }

    @Test
    public void split_1() throws Exception {
        List<String> strings = Files.readAllLines(new File("/Users/weipeng2k/Downloads/s.csv").toPath());
        StringBuilder sb = new StringBuilder();
        for (String string : strings) {
            sb.append(string);
        }
        String content = sb.toString();

        PrintWriter printWriter = new PrintWriter("/Users/weipeng2k/Downloads/out.txt");
        Arrays.stream(content.split(","))
                .map(Long::parseLong)
                .forEach(printWriter::println);

        printWriter.flush();
    }
}
