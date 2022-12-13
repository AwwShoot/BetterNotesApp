package io.github.awwshoot.betternotesapp.folders;

import android.content.Intent;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.util.Log;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.Exception;
import java.util.Scanner;

public class Note {
    static File defaultPath = new File(Environment.getExternalStorageDirectory() + "/Documents/BetterNotes/Docs");
    public static void newNote(String path) {
        // create new file in default
        try {
            // create new file
            Log.i("Notes", defaultPath.toString());
            File newNote = new File(path + ".txt");
            // File.createNewFile() does not seem to want to play nice, so I have taken to alternative methods
            FileWriter fileCreator = new FileWriter(newNote);
            fileCreator.write("\n"); // write anything to create the file because for some reason THAT'S not a security issue but createNewFile is
            fileCreator.close();

            // If a template has been selected, read its contents and paste them into the new document

        } catch (IOException newE) {
            Log.e("error","error");
            newE.printStackTrace();
        }
    }



    static void openNote(String fileName, String folderName) {
        try {
            // get file location
            File documentsFolder = new File("root/internal/Documents/" + folderName + "/" + fileName + ".md");
            String[] directoryList = documentsFolder.list();
            for (int counter = 1; counter < directoryList.length; counter++) {
                String check = documentsFolder.toString();
                if (check.equals(directoryList[counter])) {
                    // open file
                    Intent file = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                    file.addCategory(Intent.CATEGORY_OPENABLE);
                    file.setType("root/internal/Documents/" + folderName + "/" + fileName + ".md");
                    // specifying URI directory to be opened by system file picker
                    file.putExtra(DocumentsContract.EXTRA_INITIAL_URI, "root/internal/Documents/" + folderName + "/");
                    // **

                }
            }
        }
        catch (Exception openE) {
            Log.e("error","error");
            openE.printStackTrace();
        }
    }



    static void renameNote(String fileName, String folderName) {
        try {
            // get file location
            File target = new File("root/internal/Documents/" + folderName + "/" + fileName + ".md");
            // changing file directory
            File change = new File("root/internal/Documents/" + folderName + "/" + fileName + ".md");
        }
        catch (Exception renameE) {
            Log.e("error","error");
            renameE.printStackTrace();
        }
    }
    static void deleteNote(String fileName, String folderName) {
        try {
            // get file location
            File target = new File("root/internal/Documents/" + folderName + "/" + fileName + ".md");
            // remove file from directory
            target.delete();
        }
        catch (Exception deleteE) {
            Log.e("error","error");
            deleteE.printStackTrace();
        }
    }
    static void moveNote(String fileName, String currentFolder, String newFolder) {


        try {
            // get file location
            File target = new File("root/internal/Documents/" + currentFolder + "/" + fileName + ".md");
            // changing file directory
            File change = new File("root/internal/Documents/" + newFolder + "/" + fileName + ".md");
        }
        catch (Exception moveE) {
            Log.e("error","error");
            moveE.printStackTrace();
        }
    }
    static void editNote(String fileName, String folderName, char[] data) {
        // get file location
        try {
            FileWriter editor = new FileWriter("root/internal/Documents/" + folderName + "/" + fileName + ".md");
            // allow editing access
            editor.write(data);
            editor.close();
            // save changes
        }
        catch (IOException editE) {
            Log.e("error","error");
            editE.printStackTrace();
        }
    }
    static void convert() {
        // get file location
        // save as .md file
        // send to where?
    }
}

