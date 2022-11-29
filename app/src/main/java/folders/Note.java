package folders;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
            catch (IOException e) {
                System.out.print("error");
                e.printStackTrace();
            }
        }
    static void openN() {
        // get file location
        // open file
    }
    static void renameN() {
        // get file location
        // rename file
        // save changes
    }
    static void deleteN() {
        // get file location
        // delete file
    }
    static void moveN() {
        // get file location
        // select new file location
        // save changes
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
        catch (IOException e) {
            System.out.print("error");
            e.printStackTrace();
        }
    }
    static void convert() {
        // get file location
        // save as .md file
        // send to where?
    }

}

