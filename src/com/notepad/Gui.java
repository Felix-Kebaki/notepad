package com.notepad;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Gui {

    JFrame frame;
    // TEXTAREA
    JTextArea textarea;
    JScrollPane scrollPane;
    // MENU
    JMenuBar menubar;
    JMenu menuFile, menuEdit, menuView;
    // FILE ITEM
    JMenuItem inew, iopen, isave, isaveas, iexit;
    // EDIT ITEM
    JMenuItem iAerial, iTimesRoman, iComicsan, iConsolas, iCorbel, i8, i12, i16, i20, i24, i28;
    JMenu isetFont, isetSize, isetStyle;
    // STYLE EDIT
    JMenuItem iregular, iitalics, ibold;
    // VIEW EDIT
    JMenu izoom,itheme;
    JMenuItem iwordwrapper,izoomIn,izoomOut,izoomDefault,idark,ilight,isystemTheme;

    Menu_Func menuFunc = new Menu_Func(this);
    Edit_Func editFunc = new Edit_Func(this);

    public int fontSize = 12;
    public String font = "Consolas";

    public Gui() {
        styleScrollBars();
        createWindow();
        createMenu();
        createFilemenu();
        createEditmenu();
        createViewmenu();
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

    public void createMenu() {
        menubar = new JMenuBar();
        frame.setJMenuBar(menubar);

        menuFile = new JMenu("File");
        menuEdit = new JMenu("Edit");
        menuView = new JMenu("View");

        menubar.add(menuFile);
        menubar.add(menuEdit);
        menubar.add(menuView);
    }

    public void createFilemenu() {

        inew = new JMenuItem("New");
        inew.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menuFunc.newClick();
            }
        });
        menuFile.add(inew);

        iopen = new JMenuItem("Open");
        iopen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menuFunc.openClick();
            }
        });
        menuFile.add(iopen);

        isave = new JMenuItem("Save");
        isave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menuFunc.saveClick();
            }
        });
        menuFile.add(isave);

        isaveas = new JMenuItem("Save as");
        isaveas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menuFunc.saveAsClick();
            }
        });
        menuFile.add(isaveas);

        iexit = new JMenuItem("Exit");
        iexit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menuFunc.exitClick();
            }
        });
        menuFile.add(iexit);
    }

    public void createEditmenu() {

        // set font
        isetFont = new JMenu("Font");

        iAerial = new JMenuItem("Aerial");
        iAerial.setActionCommand("Aerial");
        iAerial.addActionListener(editFunc.setFontListener);
        isetFont.add(iAerial);

        iComicsan = new JMenuItem("Comic Sans");
        iComicsan.setActionCommand("Comic Sans");
        iComicsan.addActionListener(editFunc.setFontListener);
        isetFont.add(iComicsan);

        iConsolas = new JMenuItem("Consolas");
        iConsolas.setActionCommand("Consolas");
        iConsolas.addActionListener(editFunc.setFontListener);
        isetFont.add(iConsolas);

        iTimesRoman = new JMenuItem("Times New Roman");
        iTimesRoman.setActionCommand("Times New Roman");
        iTimesRoman.addActionListener(editFunc.setFontListener);
        isetFont.add(iTimesRoman);

        iCorbel = new JMenuItem("Corbel");
        iCorbel.setActionCommand("Corbel");
        iCorbel.addActionListener(editFunc.setFontListener);
        isetFont.add(iCorbel);

        menuEdit.add(isetFont);

        // set size
        isetSize = new JMenu("Size");

        i8 = new JMenuItem("8");
        i8.setActionCommand("8");
        i8.addActionListener(editFunc.setSizeListener);
        isetSize.add(i8);

        i12 = new JMenuItem("12");
        i12.setActionCommand("12");
        i12.addActionListener(editFunc.setSizeListener);
        isetSize.add(i12);

        i16 = new JMenuItem("16");
        i16.setActionCommand("16");
        i16.addActionListener(editFunc.setSizeListener);
        isetSize.add(i16);

        i20 = new JMenuItem("20");
        i20.setActionCommand("20");
        i20.addActionListener(editFunc.setSizeListener);
        isetSize.add(i20);

        i24 = new JMenuItem("24");
        i24.setActionCommand("24");
        i24.addActionListener(editFunc.setSizeListener);
        isetSize.add(i24);

        i28 = new JMenuItem("28");
        i28.setActionCommand("28");
        i28.addActionListener(editFunc.setSizeListener);
        isetSize.add(i28);

        menuEdit.add(isetSize);

        // setStyle
        isetStyle = new JMenu("Style");

        iregular = new JMenuItem("Regular");
        iregular.setActionCommand("PLAIN");
        iregular.addActionListener(editFunc.setStyleListener);
        isetStyle.add(iregular);

        iitalics = new JMenuItem("Italics");
        iitalics.setActionCommand("ITALIC");
        iitalics.addActionListener(editFunc.setStyleListener);
        isetStyle.add(iitalics);

        ibold = new JMenuItem("Bold");
        ibold.setActionCommand("BOLD");
        ibold.addActionListener(editFunc.setStyleListener);
        isetStyle.add(ibold);

        menuEdit.add(isetStyle);
    }

    public void createViewmenu(){
        //word wrap
        iwordwrapper = new JMenuItem("Word wrap:(On)");
        menuView.add(iwordwrapper);

        //zoom
        izoom=new JMenu("Zoom");

        izoomIn=new JMenuItem("Zoom in");
        izoom.add(izoomIn);

        izoomOut=new JMenuItem("Zoom out");
        izoom.add(izoomOut);

        izoomDefault=new JMenuItem("Restore default zoom");
        izoom.add(izoomDefault);

        menuView.add(izoom);

        //theme
        itheme=new JMenu("Theme");

        ilight=new JMenuItem("Light");
        itheme.add(ilight);

        idark=new JMenuItem("Dark");
        itheme.add(idark);

        isystemTheme=new JMenuItem("Use system setting");
        itheme.add(isystemTheme);

        menuView.add(itheme);
    }

    public void createTextarea() {
        textarea = new JTextArea();
        textarea.setLineWrap(true);
        textarea.setWrapStyleWord(true);
        textarea.setFont(new Font("Consolas", Font.PLAIN, 12));
        textarea.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        scrollPane = new JScrollPane(textarea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
    }

}
