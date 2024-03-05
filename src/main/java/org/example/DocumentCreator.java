package org.example;

import com.aspose.words.Document;
import com.aspose.words.DocumentBuilder;
import com.aspose.words.SaveFormat;

public class DocumentCreator {
    public static void createWordDocument(String documentPath) throws Exception {
        Document doc = new Document();
        // DocumentBuilder provides members to easily addImage content to a document.
        DocumentBuilder builder = new DocumentBuilder(doc);
        // Write a new paragraph in the document with some text as "Sample Content..."
        builder.writeln("Aspose Sample Content for Word file.");
        // Save the document in DOCX format. The format to save as is inferred from the extension of the file name.
        // Aspose.Words supports saving any document in many more formats.
        doc.save(documentPath, SaveFormat.DOCX);
    }
}
