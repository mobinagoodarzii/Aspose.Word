package org.example;


public class Main {
        public static void main(String[] args) throws Exception {

            String fontName = "B Nazanin";
            // Checking the font installation in the system
            if (!FontChecker.isFontInstalled(fontName)) {
                // Install the font
                FontChecker.installFont("C:\\Windows\\Fonts\\B_Nazanin.ttf");
            }

            String documentPath = "D:\\sampleWord\\aspose.docx";
            //to create word document
            if (ExistenceCheckerOfDocument.isDocumentExists(documentPath)) {
                System.out.println("The Document is available");
            } else {
                DocumentCreator.createWordDocument(documentPath);
                System.out.println("Document created successfully!");
            }

            //to edit word document
            if (ExistenceCheckerOfDocument.isDocumentExists(documentPath)) {
                DocumentEditor.accessToTableCells(documentPath);
//                DocumentEditor.addTableToDocument(documentPath);
//                DocumentEditor.addImage(documentPath);
                System.out.println("Document edited successfully!");
            } else {
                System.out.println("The Document is not available!");
            }
        }
}