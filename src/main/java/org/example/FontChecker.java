package org.example;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class FontChecker {
    public static boolean isFontInstalled(String fontName) {
        String[] fontNames = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        for (String name : fontNames) {
            if (name.equals(fontName)) {
                return true;
            }
        }
        return false;
    }

    public static void installFont(String fontFilePath) {
        try {
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File(fontFilePath)));
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
    }
}
