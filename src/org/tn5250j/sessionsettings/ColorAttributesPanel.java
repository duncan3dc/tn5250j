package org.tn5250j.sessionsettings;
/*
 * Title: ColorAttributesPanel
 * Copyright:   Copyright (c) 2001
 * Company:
 *
 * @author Kenneth J. Pouncey
 * @version 0.5
 * <p>
 * Description:
 * <p>
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2, or (at your option)
 * any later version.
 * <p>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License
 * along with this software; see the file COPYING.  If not, write to
 * the Free Software Foundation, Inc., 59 Temple Place, Suite 330,
 * Boston, MA 02111-1307 USA
 */

import org.tn5250j.SessionConfig;
import org.tn5250j.tools.LangTool;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ColorAttributesPanel extends AttributesPanel {

  private static final long serialVersionUID = 1L;
  private JComboBox colorList;
  private JColorChooser jcc;
  private Schema colorSchema;

  ColorAttributesPanel(SessionConfig config) {
    super(config, "Colors");
  }

  /**
   * Component initialization
   */
  public void initPanel() throws Exception {

    JPanel cp = new JPanel();
    cp.setLayout(new BorderLayout());

    JPanel cschp = new JPanel();
    TitledBorder tb = BorderFactory.createTitledBorder(LangTool.getString("sa.colorSchema"));
    cschp.setBorder(tb);
    JComboBox colorSchemaList = new JComboBox();

    colorSchemaList.addItem(LangTool.getString("sa.colorDefault"));
    for (Schema schema: Schema.getAll()) {
      colorSchemaList.addItem(schema);
    }

    colorSchemaList.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        JComboBox cb = (JComboBox) e.getSource();
        Object obj = cb.getSelectedItem();
        if (obj instanceof Schema) {

          System.out.println(" we got a schema ");
          colorSchema = (Schema) obj;
        } else {
          colorSchema = null;
        }

      }
    });


    cschp.add(colorSchemaList);

    tb = BorderFactory.createTitledBorder(LangTool.getString("sa.colors"));
    cp.setBorder(tb);
    colorList = new JComboBox();
    colorList.addItem(LangTool.getString("sa.bg"));
    colorList.addItem(LangTool.getString("sa.blue"));
    colorList.addItem(LangTool.getString("sa.red"));
    colorList.addItem(LangTool.getString("sa.pink"));
    colorList.addItem(LangTool.getString("sa.green"));
    colorList.addItem(LangTool.getString("sa.turq"));
    colorList.addItem(LangTool.getString("sa.yellow"));
    colorList.addItem(LangTool.getString("sa.white"));
    colorList.addItem(LangTool.getString("sa.guiField"));
    colorList.addItem(LangTool.getString("sa.cursorColor"));
    colorList.addItem(LangTool.getString("sa.columnSep"));
    colorList.addItem(LangTool.getString("sa.hexAttrColor"));

    jcc = new JColorChooser();

    // set the default color for display as that being for back ground
    jcc.setColor(getColorProperty("colorBg"));

    colorList.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        JComboBox cb = (JComboBox) e.getSource();
        String newSelection = (String) cb.getSelectedItem();
        if (newSelection.equals(LangTool.getString("sa.bg"))) {
          if (colorSchema != null)
            jcc.setColor(colorSchema.getColor("background"));
          else
            jcc.setColor(getColorProperty("colorBg"));
        }
        if (newSelection.equals(LangTool.getString("sa.blue"))) {
          if (colorSchema != null)
            jcc.setColor(colorSchema.getColor("blue"));
          else
            jcc.setColor(getColorProperty("colorBlue"));
        }
        if (newSelection.equals(LangTool.getString("sa.red"))) {
          if (colorSchema != null)
            jcc.setColor(colorSchema.getColor("red"));
          else
            jcc.setColor(getColorProperty("colorRed"));

        }
        if (newSelection.equals(LangTool.getString("sa.pink"))) {
          if (colorSchema != null)
            jcc.setColor(colorSchema.getColor("pink"));
          else
            jcc.setColor(getColorProperty("colorPink"));

        }
        if (newSelection.equals(LangTool.getString("sa.green"))) {
          if (colorSchema != null)
            jcc.setColor(colorSchema.getColor("green"));
          else
            jcc.setColor(getColorProperty("colorGreen"));

        }
        if (newSelection.equals(LangTool.getString("sa.turq"))) {
          if (colorSchema != null)
            jcc.setColor(colorSchema.getColor("turquoise"));
          else
            jcc.setColor(getColorProperty("colorTurq"));

        }
        if (newSelection.equals(LangTool.getString("sa.yellow"))) {
          if (colorSchema != null)
            jcc.setColor(colorSchema.getColor("yellow"));
          else
            jcc.setColor(getColorProperty("colorYellow"));

        }
        if (newSelection.equals(LangTool.getString("sa.white"))) {
          if (colorSchema != null)
            jcc.setColor(colorSchema.getColor("white"));
          else
            jcc.setColor(getColorProperty("colorWhite"));
        }

        if (newSelection.equals(LangTool.getString("sa.guiField"))) {
          if (colorSchema != null)
            jcc.setColor(colorSchema.getColor("field"));
          else
            jcc.setColor(getColorProperty("colorGUIField", Color.white));
        }
        if (newSelection.equals(LangTool.getString("sa.cursorColor"))) {
          if (colorSchema != null)
            jcc.setColor(colorSchema.getColor("background"));
          else
            jcc.setColor(getColorProperty("colorCursor",
                getColorProperty("colorBg")));
        }
        if (newSelection.equals(LangTool.getString("sa.columnSep"))) {
          if (colorSchema != null)
            jcc.setColor(colorSchema.getColor("separator"));
          else
            jcc.setColor(getColorProperty("colorSep",
                getColorProperty("colorWhite")));
        }

        if (newSelection.equals(LangTool.getString("sa.hexAttrColor"))) {
          if (colorSchema != null)
            jcc.setColor(colorSchema.getColor("attribute"));
          else
            jcc.setColor(getColorProperty("colorHexAttr",
                getColorProperty("colorWhite")));
        }
      }
    });


    cp.add(colorList, BorderLayout.NORTH);
    cp.add(jcc, BorderLayout.CENTER);

    add(cschp, BorderLayout.NORTH);
    add(cp, BorderLayout.CENTER);

  }

  public void applyAttributes() {

    String newSelection = (String) colorList.getSelectedItem();

    if (colorSchema != null) {
      for (String key: colorSchema.getKeys()) {
        Color color = colorSchema.getColor(key);
        if (!getColorProperty(key).equals(color)) {
          changes.firePropertyChange(this, key, getColorProperty(key), color);
          setProperty(key, colorSchema.getString(key));
        }
      }
      return;
    }

    Color nc = jcc.getColor();
    if (newSelection.equals(LangTool.getString("sa.bg"))) {
      if (!getColorProperty("colorBg").equals(nc)) {
        changes.firePropertyChange(this, "colorBg",
            getColorProperty("colorBg"),
            nc);

        setProperty("colorBg", Integer.toString(nc.getRGB()));

      }
    }
    if (newSelection.equals(LangTool.getString("sa.blue"))) {
      if (!getColorProperty("colorBlue").equals(nc)) {
        changes.firePropertyChange(this, "colorBlue",
            getColorProperty("colorBlue"),
            nc);
        setProperty("colorBlue", Integer.toString(nc.getRGB()));

      }
    }
    if (newSelection.equals(LangTool.getString("sa.red"))) {
      if (!getColorProperty("colorRed").equals(nc)) {
        changes.firePropertyChange(this, "colorRed",
            getColorProperty("colorRed"),
            nc);
        setProperty("colorRed", Integer.toString(nc.getRGB()));

      }
    }
    if (newSelection.equals(LangTool.getString("sa.pink"))) {
      if (!getColorProperty("colorPink").equals(nc)) {
        changes.firePropertyChange(this, "colorPink",
            getColorProperty("colorPink"),
            nc);
        setProperty("colorPink", Integer.toString(nc.getRGB()));

      }
    }
    if (newSelection.equals(LangTool.getString("sa.green"))) {
      if (!getColorProperty("colorGreen").equals(nc)) {
        changes.firePropertyChange(this, "colorGreen",
            getColorProperty("colorGreen"),
            nc);

        setProperty("colorGreen", Integer.toString(nc.getRGB()));

      }
    }
    if (newSelection.equals(LangTool.getString("sa.turq"))) {
      if (!getColorProperty("colorTurq").equals(nc)) {
        changes.firePropertyChange(this, "colorTurq",
            getColorProperty("colorTurq"),
            nc);

        setProperty("colorTurq", Integer.toString(nc.getRGB()));

      }

    }
    if (newSelection.equals(LangTool.getString("sa.yellow"))) {
      if (!getColorProperty("colorYellow").equals(nc)) {
        changes.firePropertyChange(this, "colorYellow",
            getColorProperty("colorYellow"),
            nc);
        setProperty("colorYellow", Integer.toString(nc.getRGB()));

      }
    }
    if (newSelection.equals(LangTool.getString("sa.white"))) {
      if (!getColorProperty("colorWhite").equals(nc)) {
        changes.firePropertyChange(this, "colorWhite",
            getColorProperty("colorWhite"),
            nc);

        setProperty("colorWhite", Integer.toString(nc.getRGB()));

      }
    }

    if (newSelection.equals(LangTool.getString("sa.guiField"))) {
      if (!getColorProperty("colorGUIField").equals(nc)) {
        changes.firePropertyChange(this, "colorGUIField",
            getColorProperty("colorGUIField"),
            nc);

        setProperty("colorGUIField", Integer.toString(nc.getRGB()));

      }
    }

    if (newSelection.equals(LangTool.getString("sa.cursorColor"))) {
      if (!getColorProperty("colorCursor").equals(nc)) {
        changes.firePropertyChange(this, "colorCursor",
            getColorProperty("colorCursor"),
            nc);

        setProperty("colorCursor", Integer.toString(nc.getRGB()));

      }
    }
    if (newSelection.equals(LangTool.getString("sa.columnSep"))) {
      if (!getColorProperty("colorSep").equals(nc)) {
        changes.firePropertyChange(this, "colorSep",
            getColorProperty("colorSep"),
            nc);

        setProperty("colorSep", Integer.toString(nc.getRGB()));

      }
    }
    if (newSelection.equals(LangTool.getString("sa.cursorColor"))) {
      if (!getColorProperty("colorCursor").equals(nc)) {
        changes.firePropertyChange(this, "colorCursor",
            getColorProperty("colorCursor"),
            nc);

        setProperty("colorCursor", Integer.toString(nc.getRGB()));

      }
    }

    if (newSelection.equals(LangTool.getString("sa.hexAttrColor"))) {
      if (!getColorProperty("colorHexAttr").equals(nc)) {
        changes.firePropertyChange(this, "colorHexAttr",
            getColorProperty("colorHexAttr"),
            nc);

        setProperty("colorHexAttr", Integer.toString(nc.getRGB()));

      }
    }
  }
}
