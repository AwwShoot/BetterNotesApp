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

}

