package org.tn5250j.sessionsettings;

import java.awt.Color;
import java.net.URL;
import java.io.IOException;
import java.util.Properties;
import java.util.Hashtable;

public class Schema {

    private static Properties properties;

    private static String[] keys = new String[] {
        "colorBg",
        "colorCursor",
        "colorGUIField",
        "colorSep",
        "colorHexAttr",
        "colorCursor",

        "colorRed",
        "colorTurq",
        "colorWhite",
        "colorYellow",
        "colorGreen",
        "colorPink",
        "colorBlue",
    };

    private String title;
    private Hashtable colors = new Hashtable<String, String>();


    private static String getProperty(String key) {

        // If we've not loaded the properties yet then do so now
        if (properties == null) {
            properties = new Properties();
            URL file = ClassLoader.getSystemClassLoader().getResource("tn5250jSchemas.properties");
            try {
                properties.load(file.openStream());
            } catch (IOException e) {
                System.err.println(e);
            }
        }

        if (!properties.containsKey(key)) {
            return "";
        }

        return (String) properties.get(key);
    }


    private static String getProperty(String prefix, String key) {
        return getProperty(prefix + "." + key);
    }


    public static Schema[] getAll() {
        int max = Integer.parseInt(getProperty("schemas"));

        Schema[] schemas = new Schema[max];
        for (int i = 0; i < max; i++) {
            schemas[i] = get(i + 1);
        }

        return schemas;
    }


    public static Schema get(int i) {
        return getByPrefix("schema" + i);
    }


    public static Schema getDefault() {
        return getByPrefix(getProperty("schemaDefault"));
    }


    private static Schema getByPrefix(String prefix) {
        Schema schema = new Schema();

        schema.title = getProperty(prefix, "title");

        for (String key: keys) {
            schema.colors.put(key, getProperty(prefix, key));
        }

        return schema;
    }


    public String getString(String key) {
        if (!colors.containsKey(key)) {
            return "";
        }

        return (String) colors.get(key);
    }


    public String[] getKeys() {
        return keys;
    }


    public String toString() {
        return title;
    }


    public Color getColor(String key) {
        return new Color(Integer.parseInt(getProperty(key)));
    }


    public Color getBackgroundColor() {
        return getColor("colorBg");
    }
    public Color getCursorColor() {
        return getColor("colorCursor");
    }
    public Color getFieldColor() {
        return getColor("colorGUIField");
    }
    public Color getSeparatorColor() {
        return getColor("colorSep");
    }
    public Color getHexAttributeColor() {
        return getColor("colorHexAttr");
    }
    public Color getColorCursor() {
        return getColor("colorCursor");
    }
    public Color getRed() {
        return getColor("colorRed");
    }
    public Color getTurquoise() {
        return getColor("colorTurq");
    }
    public Color getWhite() {
        return getColor("colorWhite");
    }
    public Color getYellow() {
        return getColor("colorYellow");
    }
    public Color getGreen() {
        return getColor("colorGreen");
    }
    public Color getBlue() {
        return getColor("colorBlue");
    }
}
