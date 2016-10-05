package org.tn5250j.sessionsettings;

import java.awt.Color;

class Schema {


    public String toString() {

        return description;

    }

    public void setDescription(String desc) {

        description = desc;
    }

    public void setColorBg(int color) {

        bg = new Color(color);
    }

    public Color getColorBg() {

        return bg;
    }

    public void setColorBlue(int color) {

        blue = new Color(color);
    }

    public Color getColorBlue() {

        return blue;
    }

    public void setColorRed(int color) {

        red = new Color(color);
    }

    public Color getColorRed() {

        return red;
    }

    public void setColorPink(int color) {

        pink = new Color(color);
    }

    public Color getColorPink() {

        return pink;
    }

    public void setColorGreen(int color) {

        green = new Color(color);
    }

    public Color getColorGreen() {

        return green;
    }

    public void setColorTurq(int color) {

        turq = new Color(color);
    }

    public Color getColorTurq() {

        return turq;
    }

    public void setColorYellow(int color) {

        yellow = new Color(color);
    }

    public Color getColorYellow() {

        return yellow;
    }

    public void setColorWhite(int color) {

        white = new Color(color);
    }

    public Color getColorWhite() {

        return white;
    }

    public void setColorGuiField(int color) {

        gui = new Color(color);
    }

    public Color getColorGuiField() {

        return gui;
    }

    public void setColorCursor(int color) {

        cursor = new Color(color);
    }

    public Color getColorCursor() {


        return cursor;
    }

    public void setColorCursor(int color) {

      cursor = new Color(color);
    }

    public Color getColorCursor() {


      return cursor;
    }

    public void setColorSeparator(int color) {

        columnSep = new Color(color);
    }

    public Color getColorSeparator() {


        return columnSep;
    }

    public void setColorHexAttr(int color) {

        hexAttr = new Color(color);
    }

    public Color getColorHexAttr() {


        return hexAttr;
    }

    private String description;
    private Color bg;
    private Color blue;
    private Color red;
    private Color pink;
    private Color green;
    private Color turq;
    private Color white;
    private Color yellow;
    private Color gui;
    private Color cursor;
    private Color columnSep;
    private Color hexAttr;
}
