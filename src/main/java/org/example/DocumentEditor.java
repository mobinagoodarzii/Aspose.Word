package org.example;

import com.aspose.words.*;
import com.aspose.words.Shape;

import java.awt.*;

public class DocumentEditor {
    public static void accessToTableCells(String documentPath) throws Exception {

        Document doc = new Document(documentPath);

        //Getting information from the first table
        Table table = (Table) doc.getChild(NodeType.TABLE, 0, true);

        if (table != null) {
            //Get the first cell of first row
            Cell cell = (Cell)table.getRows().get(0).getCells().get(0);

            Paragraph paragraph = cell.getFirstParagraph();
            //cell.getParagraphs().get(0); //or use this
            paragraph.removeAllChildren(); // Delete all content inside the paragraph
            paragraph.appendChild(new Run(doc, "New cell content"));

            //Change the color of text
            for (Run run : (Iterable<Run>)cell.getChildNodes(NodeType.RUN, true))
            {
                run.getFont().setColor(Color.BLUE);
            }

            try {
                doc.save(documentPath);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("The desired table was not found!");
        }
    }
    public static void addTableToDocument(String documentPath) throws Exception {

        Document doc = new Document(documentPath);
        DocumentBuilder builder = new DocumentBuilder(doc);

        //Move additional items to the next line.
        builder.writeln();
        Tables.formattedTable(builder);

        try {
            doc.save(documentPath);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void addImage(String documentPath) throws Exception {

        Document doc = new Document(documentPath);
        DocumentBuilder builder = new DocumentBuilder(doc);

        Shape shape = builder.insertImage("E:\\pictures\\animations\\mango.jpg");
        shape.setWrapType(WrapType.NONE);
        shape.setHorizontalAlignment(HorizontalAlignment.CENTER);

        try {
            doc.save(documentPath);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}


