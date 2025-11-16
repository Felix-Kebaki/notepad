package com.notepad;

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
            gui.iwordwrapper.setText( "Word wrap:(OFF)");
        }

        // Refresh the scroll pane and textarea
        gui.scrollPaneVertical.revalidate();
        gui.scrollPaneVertical.repaint();
    }
}
