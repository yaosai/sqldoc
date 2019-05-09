package com.yaosai.sqldoc.utils;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Cell;
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
    private static final String color = "CCFFFF";

    public Table createDatabaseTable(List<Map<String, Object>> list) throws BadElementException {
        Table table = new Table(2);
        table.setBorderWidth(1);
        table.setBorderColor(Color.BLACK);
        table.setPadding(0);
        table.setSpacing(0);
        Cell[] cell = new Cell[2];
        cell[0] = new Cell("数据库名");
        cell[1] = new Cell("注释");
        for (Cell cell2 : cell) {
            cell2.setBackgroundColor(new Color(Integer.parseInt(color, 16)));
        }
        table.addCell(cell[0]);
        table.addCell(cell[1]);


        for (Object obj : list) {
            Object[] cells = (Object[]) obj;
            addDatabaseRowCell(table, cells);
        }
        return table;
    }

    public static void addDatabaseRowCell(Table table, Object[] cells) throws BadElementException {
        table.addCell(new Paragraph((String) cells[0]));
        table.addCell(new Paragraph((String) cells[1]));
    }


    public Table createTable(List<Map<String, Object>> list) throws BadElementException {
        Table table = new Table(5);
        table.setBorderWidth(1);
        table.setBorderColor(Color.BLACK);
        table.setPadding(0);
        table.setSpacing(0);

        table.addCell("字段名");
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
    }
}