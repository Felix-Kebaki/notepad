package com.notepad;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;

public class View_Func {
    Gui gui;

    public View_Func(Gui gui) {
        this.gui = gui;
    }

    public void wordWrapFunc() {
        gui.wordWrapOn = !gui.wordWrapOn;
        if (gui.wordWrapOn) {
            gui.textarea.setLineWrap(true);
            gui.textarea.setWrapStyleWord(true);

            gui.scrollPaneVertical.setHorizontalScrollBarPolicy(
                    JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            gui.iwordwrapper.setText("Word wrap:(ON)");
        } else {
            gui.textarea.setLineWrap(false);
            gui.textarea.setWrapStyleWord(false);

            gui.scrollPaneVertical.setHorizontalScrollBarPolicy(
                    JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            gui.iwordwrapper.setText("Word wrap:(OFF)");
        }

        // Refresh the scroll pane and textarea
        gui.scrollPaneVertical.revalidate();
        gui.scrollPaneVertical.repaint();
    }

    ActionListener selectThemeListener = e -> {
        switch (e.getActionCommand()) {
            case "light":
                gui.menubar.setBackground(new Color(232,232,232));
                gui.menuFile.setForeground(Color.black);
                gui.menuEdit.setForeground(Color.black);
                gui.menuView.setForeground(Color.black);
                gui.textarea.setForeground(Color.black);
                gui.textarea.setBackground(Color.white);
                break;
            case "dark":
                gui.menubar.setBackground(new Color(32, 32, 32));
                gui.menuFile.setForeground(Color.white);
                gui.menuEdit.setForeground(Color.white);
                gui.menuView.setForeground(Color.white);
                gui.textarea.setForeground(Color.white);
                gui.textarea.setBackground(Color.black);
                break;
            case "system":
                System.out.println("System mode");
                break;
            default:
                System.out.println("Default response");
        }
    };
}
