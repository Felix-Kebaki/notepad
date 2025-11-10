package com.notepad;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Gui {

    JFrame frame;
    JTextArea textarea;
    JScrollPane scrollPane;

    public Gui() {
        styleScrollBars();
        createWindow();
        createTextarea();

        frame.add(scrollPane);
        frame.setVisible(true);
    }

    private void styleScrollBars() {
        UIManager.put("ScrollBar.width", 10);
        UIManager.put("ScrollBar.thumb", Color.BLACK);
        UIManager.put("ScrollBar.track", Color.WHITE);
    }

    public void createWindow() {
        frame = new JFrame();
        frame.setTitle("Notepad");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setLocationRelativeTo(null);
        frame.setMinimumSize(new Dimension(400, 200));
        ImageIcon image = new ImageIcon("src/com/notepad/notepad.png");
        frame.setIconImage(image.getImage());
    }

    public void createTextarea() {
        textarea = new JTextArea();
        textarea.setLineWrap(true);
        textarea.setWrapStyleWord(true);
        textarea.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        scrollPane = new JScrollPane(textarea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
    }
}
