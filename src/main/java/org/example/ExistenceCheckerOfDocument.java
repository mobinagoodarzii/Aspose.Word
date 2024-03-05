package org.example;

import java.io.File;

public class ExistenceCheckerOfDocument {
    public static boolean isDocumentExists(String documentPath) {
        File file = new File(documentPath);
        return file.exists();
    }
}
