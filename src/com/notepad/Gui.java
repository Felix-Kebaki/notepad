package com.notepad;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Gui {

    JFrame frame;
    //TEXTAREA
    JTextArea textarea;
    JScrollPane scrollPane;
    //MENU
    JMenuBar menubar;
    JMenu menuFile,menuEdit,menuView;
    //FILE ITEM
    JMenuItem inew,iopen,isave,isaveas,iexit;
    //EDIT ITEM
    JMenuItem iwordwrapper,iAerial,iTimesRoman,iComicsan,i8,i12,i16,i20,i24,i28;
    JMenu isetFont;
    JMenu isetSize;

    Menu_Func menuFunc=new Menu_Func(this);
    Edit_Func editFunc=new Edit_Func(this);

    public Gui() {
        styleScrollBars();
        createWindow();
        createMenu();
        createFilemenu();
        createEditmenu();
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

    public void createFilemenu(){

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

    public void createEditmenu(){
        iwordwrapper=new JMenuItem("Word wrap:(Off)");
        menuEdit.add(iwordwrapper);

        //set font
        isetFont=new JMenu("Font");

        iAerial=new JMenuItem("Aerial");
        isetFont.add(iAerial);

        iComicsan=new JMenuItem("Comic Sans");
        isetFont.add(iComicsan);

        iComicsan=new JMenuItem("Consolas");
        isetFont.add(iComicsan);

        iTimesRoman=new JMenuItem("Times New Roman");
        isetFont.add(iTimesRoman);

        menuEdit.add(isetFont);

        //set size
        isetSize=new JMenu("Size");

        i8=new JMenuItem("8");
        isetSize.add(i8);

        i12=new JMenuItem("12");
        isetSize.add(i12);

        i16=new JMenuItem("16");
        isetSize.add(i16);

        i20=new JMenuItem("20");
        isetSize.add(i20);

        i24=new JMenuItem("24");
        isetSize.add(i24);

        i28=new JMenuItem("28");
        isetSize.add(i28);

        menuEdit.add(isetSize);
    }



    public void createTextarea() {
        textarea = new JTextArea();
        textarea.setLineWrap(true);
        textarea.setWrapStyleWord(true);
        textarea.setFont(new Font("Consolas",Font.PLAIN,12));
        textarea.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        scrollPane = new JScrollPane(textarea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
    }

}
