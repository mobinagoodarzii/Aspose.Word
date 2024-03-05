package org.example;

import com.aspose.words.*;

import java.awt.*;

public class Tables {
    public static void formattedTable(DocumentBuilder builder) throws Exception {

        Table table = builder.startTable();
        builder.insertCell();

        // Table wide formatting must be applied after at least one row is present in the formattedTable.
        table.setLeftIndent(20.0);

        // Set height and define the height rule for the header row.
        builder.getRowFormat().setHeight(40.0);
        builder.getRowFormat().setHeightRule(HeightRule.AT_LEAST);

        builder.getCellFormat().getShading().setBackgroundPatternColor(new Color((198), (217), (241)));
        builder.getParagraphFormat().setAlignment(ParagraphAlignment.CENTER);
        builder.getFont().setSize(16.0);
        builder.getFont().setName("B Nazanin");
        builder.getFont().setBold(true);

        builder.getCellFormat().setWidth(100.0);
        builder.write("سبزیجات");

        // We don't need to specify this cell's width because it's inherited from the previous cell.
        builder.insertCell();
        builder.write("پروتئین");

        builder.insertCell();
        builder.getCellFormat().setWidth(200.0);
        builder.write("لبنیات");
        builder.endRow();

        builder.getCellFormat().getShading().setBackgroundPatternColor(Color.WHITE);
        builder.getCellFormat().setWidth(100.0);
        builder.getCellFormat().setVerticalAlignment(CellVerticalAlignment.CENTER);

        // Reset height and define a different height rule for formattedTable body.
        builder.getRowFormat().setHeight(30.0);
        builder.getRowFormat().setHeightRule(HeightRule.AUTO);
        builder.insertCell();

        // Reset font formatting.
        builder.getFont().setSize(12.0);
        builder.getFont().setBold(false);

        builder.write("اسفناج");
        builder.insertCell();
        builder.write("سویا");

        builder.insertCell();
        builder.getCellFormat().setWidth(200.0);
        builder.write("کره");
        builder.endRow();

        builder.insertCell();
        builder.getCellFormat().setWidth(100.0);
        builder.write("کاهو");

        builder.insertCell();
        builder.write("گوشت");

        builder.insertCell();
        builder.getCellFormat().setWidth(200.0);
        builder.write("ماست");
        builder.endRow();
        builder.endTable();
    }
    public static void singleCellTable(DocumentBuilder builder) throws Exception {
        Table table = builder.startTable();
        builder.insertCell();

        RowFormat rowFormat = builder.getRowFormat();
        rowFormat.setHeight(100.0);
        rowFormat.setHeightRule(HeightRule.EXACTLY);

        // These formatting properties are set on the table and are applied to all rows in the table.
        table.setLeftPadding(30.0);
        table.setRightPadding(30.0);
        table.setTopPadding(30.0);
        table.setBottomPadding(30.0);

        builder.writeln("I'm a wonderful formatted row.");

        builder.endRow();
        builder.endTable();
    }

    public static void autoFitTable(DocumentBuilder builder) throws Exception {
        // Insert a table with a width that takes up half the page width.
        Table table = builder.startTable();

        builder.insertCell();
        table.setPreferredWidth(PreferredWidth.fromPercent(50.0));
        builder.writeln("Cell #1");

        builder.insertCell();
        builder.writeln("Cell #2");

        builder.insertCell();
        builder.writeln("Cell #3");
    }

    public static void borderedTable(DocumentBuilder builder) throws Exception {
        Table table = builder.startTable();
        builder.insertCell();

        // Set the borders for the entire table.
        table.setBorders(LineStyle.SINGLE, 2.0, Color.BLACK);

        // Set the cell shading for this cell.
        builder.getCellFormat().getShading().setBackgroundPatternColor(Color.RED);
        builder.writeln("Cell #1");

        builder.insertCell();

        // Specify a different cell shading for the second cell.
        builder.getCellFormat().getShading().setBackgroundPatternColor(Color.GREEN);
        builder.writeln("Cell #2");

        builder.endRow();

        // Clear the cell formatting from previous operations.
        builder.getCellFormat().clearFormatting();

        builder.insertCell();

        // Create larger borders for the first cell of this row. This will be different
        // compared to the borders set for the table.
        builder.getCellFormat().getBorders().getLeft().setLineWidth(4.0);
        builder.getCellFormat().getBorders().getRight().setLineWidth(4.0);
        builder.getCellFormat().getBorders().getTop().setLineWidth(4.0);
        builder.getCellFormat().getBorders().getBottom().setLineWidth(4.0);
        builder.writeln("Cell #3");

        builder.insertCell();
        builder.getCellFormat().clearFormatting();
        builder.writeln("Cell #4");
    }
}
