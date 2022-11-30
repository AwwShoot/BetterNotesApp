package folders;

import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.lang.Exception;
import java.nio.file.Files;

public class Note {
    static void newN() {
        // create new file in default
            try {
                File note = new File("root/internal/Documents/newNote.md");
                if (note.createNewFile()) {
                    // change file to template, make this a switch case statement
                    // change file name and location
                    // open file
                    openN();
                }
                else {
                    System.out.print("that note already exists");
                }
            }
            catch (IOException newE) {
                System.out.print("error");
                newE.printStackTrace();
            }
        }
    static void openN() {
        try {
            File target = new File("");
            // get file location
            if ( == null) {
                System.out.print("note does not exist");
            }
            else {
                // open file
            }
        }
        catch (IOException openE) {
            System.out.print("error");
            openE.printStackTrace();
        }
    }
    static void renameN() {
        try {
            // get file location
            File target = new File("");
            // changing file directory
            File change = new File("");
        }
        catch (Exception renameE) {
            System.out.print("error");
            renameE.printStackTrace();
        }
    }
    static void deleteN() {
        try {
            // get file location
            File target = new File("");
            // remove file from directory
            target.delete();
        }
        catch (Exception deleteE) {
            System.out.print("error");
            deleteE.printStackTrace();
        }
    }
    static void moveN() {
        try {
            // get file location
            File target = new File("");
            // changing file directory
            File change = new File("");
        }
        catch (Exception moveE) {
            System.out.print("error");
            moveE.printStackTrace();
        }
    }
    static void editN() {
        // get file location
        try {
            FileWriter editor = new FileWriter("root/internal/Documents/");
            // allow editing access
            editor.write("");
            editor.close();
            // save changes
        }
        catch (IOException editE) {
            System.out.print("error");
            editE.printStackTrace();
        }
    }
    static void convert() {
        // get file location
        // save as .md file
        // send to where?
    }
}

