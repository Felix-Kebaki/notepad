package com.notepad;

import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JOptionPane;

public class Menu_Func {
    Gui gui;
    String fileName;
    String fileAddress;

    public Menu_Func(Gui gui) {
        this.gui = gui;
    }

    public void newClick() {
        gui.textarea.setText("");
        gui.frame.setTitle("Untitled.txt");
        fileName = null;
        fileAddress = null;
    }

    public void openClick() {
        FileDialog fd = new FileDialog(gui.frame, "Open", FileDialog.LOAD);
        fd.setVisible(true);

        if (fd.getFile() != null) {
            fileName = fd.getFile();
            fileAddress = fd.getDirectory();
            gui.frame.setTitle(fileName);
        }

        try (BufferedReader bf = new BufferedReader(new FileReader(fileAddress + fileName))) {
            gui.textarea.setText("");
            String line = null;

            while ((line = bf.readLine()) != null) {
                gui.textarea.append(line + "\n");
            }
        } catch (Exception e) {
            System.out.println("File not opened!! " + e.getMessage());
            JOptionPane.showMessageDialog(gui.frame, "An error occured ,we couldn't open your file.", "Error Alert!!",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void saveClick() {
        if (fileName == null) {
            saveAsClick();
        } else {
            if (!fileName.toLowerCase().endsWith(".txt")) {
                fileName += ".txt";
            }
            try (FileWriter fw = new FileWriter(fileAddress + fileName)) {
                fw.write(gui.textarea.getText());
            } catch (Exception e) {
                System.out.println("Something went wrong!! " + e.getMessage());
            }
        }
    }

    public void saveAsClick() {
        FileDialog fd = new FileDialog(gui.frame, "Save as", FileDialog.SAVE);
        fd.setFile("Untitled.txt");
        fd.setVisible(true);

        if (fd.getFile() != null) {
            fileName = fd.getFile();
            fileAddress = fd.getDirectory();
            gui.frame.setTitle(fileName);
            if (!fileName.toLowerCase().endsWith(".txt")) {
                fileName += ".txt";
            }
        }

        try (FileWriter fw = new FileWriter(fileAddress + fileName)) {
            fw.write(gui.textarea.getText());
        } catch (Exception e) {
            System.out.println("Error occured, " + e.getMessage());
        }
    }

    public void exitClick(){
        System.exit(0);
    }
}
