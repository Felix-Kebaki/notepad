package com.notepad;

import java.awt.Font;
import java.awt.event.ActionListener;

public class Edit_Func {
    Gui gui;

    public Edit_Func(Gui gui){
        this.gui=gui;
    }

    ActionListener setSizeListener=e->{
        int size=Integer.parseInt(e.getActionCommand());
        Font current=gui.textarea.getFont();
        Font newFont=new Font(current.getName(),current.getStyle(),size);
        gui.textarea.setFont(newFont);
    };

    ActionListener setFontListener=e->{
        String font=e.getActionCommand();
        Font current=gui.textarea.getFont();
        Font newFont=new Font(font,current.getStyle(),current.getSize());
        gui.textarea.setFont(newFont);
    };

    ActionListener setStyleListener=e->{
        String style=e.getActionCommand();
        Font current=gui.textarea.getFont();
        int fontStyle;
        switch(style){
            case "PLAIN":
                fontStyle=Font.PLAIN;
                break;
            case "ITALIC":
                fontStyle=Font.ITALIC;
                break;
            case "BOLD":
                fontStyle=Font.BOLD;
                break;
            default:
                fontStyle=Font.PLAIN;
        };
        Font newFont=new Font(current.getName(),fontStyle,current.getSize());
        gui.textarea.setFont(newFont);
    };
}
