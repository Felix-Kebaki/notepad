package com.notepad;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Gui {

    JFrame frame;
    JTextArea textarea;
    JScrollPane scrollPane;
    JMenuBar menubar;
    JMenu menuFile,menuEdit,menuView;
    JMenuItem inew,iopen,isave,isaveas,iexit;

    Menu_Func menuFunc=new Menu_Func(this);

    public Gui() {
        styleScrollBars();
        createWindow();
        createMenu();
        createSubmenu();
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

    public void createMenu(){
        menubar=new JMenuBar();
        frame.setJMenuBar(menubar);

        menuFile=new JMenu("File");
        menuEdit=new JMenu("Edit");
        menuView=new JMenu("View");

        menubar.add(menuFile);
        menubar.add(menuEdit);
        menubar.add(menuView);
    }

    public void createSubmenu(){

        inew=new JMenuItem("New");
        inew.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                menuFunc.newClick();
            }
        });
        menuFile.add(inew);

        iopen=new JMenuItem("Open");
        iopen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                menuFunc.openClick();
            }
        });
        menuFile.add(iopen);

        isave=new JMenuItem("Save");
        isave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                menuFunc.saveClick();
            }
        });
        menuFile.add(isave);

        isaveas=new JMenuItem("Save as");
        isaveas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                menuFunc.saveAsClick();
            }
        });
        menuFile.add(isaveas);

        iexit=new JMenuItem("Exit");
        iexit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                menuFunc.exitClick();
            }
        });
        menuFile.add(iexit);
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
