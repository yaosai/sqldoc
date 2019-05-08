package com.yaosai.sqldoc.utils;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.List;
import java.util.Map;

/**
 * 创建word文档 步骤:
 * 1,建立文档
 * 2,创建一个书写器
 * 3,打开文档
 * 4,向文档中写入数据
 * 5,关闭文档
 *
 * @author YaoS
 * @date 2019-05-08 14:08
 */
@Component
public class WordUtils {
    public Table createTable(List<Map<String, Object>> list) throws BadElementException {
        /*
         * 创建有六列的表格
         */
        Table table = new Table(6);
        table.setBorderWidth(1);
        table.setBorderColor(Color.BLACK);
        table.setPadding(0);
        table.setSpacing(0);

        table.addCell("字段名");
        table.addCell("字段中文名");
        table.addCell("数据类型");
        table.addCell("是否为键 ");
        table.addCell("默认为空");
        table.addCell("注释");
        for (Object obj : list) {
            Object[] cells = (Object[]) obj;
            addRowCell(table, cells);
        }
        return table;
    }

    public static void addRowCell(Table table, Object[] cells) throws BadElementException {
        table.addCell(new Paragraph((String) cells[0]));
        table.addCell(new Paragraph((String) cells[1]));
        table.addCell(new Paragraph((String) cells[2]));
        table.addCell(new Paragraph((String) cells[3]));
        table.addCell(new Paragraph((String) cells[4]));
        table.addCell(new Paragraph((String) cells[5]));
    }
}