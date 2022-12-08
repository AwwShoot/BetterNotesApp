package folders;

import android.content.Intent;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.Exception;

public class Note {
    static void newN() {
        String fileName = "String";
        // create new file in default
        try {
            // create new file
            Intent create = new Intent(Intent.ACTION_CREATE_DOCUMENT);
            create.addCategory(Intent.CATEGORY_OPENABLE);
            create.setType(fileName + ".md");
            create.putExtra(Intent.EXTRA_TITLE,  fileName + ".md");
            // read/write whatever is in template
            FileReader reader = new FileReader(fileName + ".md");
            FileWriter writer = new FileWriter(fileName + ".md");
            writer.write(reader.read());
            // change file name and location
            renameN();
            moveN();
            // open file
            openN();
        } catch (IOException newE) {
            System.out.print("error");
            newE.printStackTrace();
        }
    }

    static void openN() {
        String fileName = "String";
        String folderName = "String";
        String newFolderName = "String";
        try {
            File target = new File("root/internal/Documents/" + folderName + "/" + fileName + ".md");
            // get file location
            File documentsFolder = new File("root/internal/Documents/" + newFolderName + "/" + fileName + ".md");
            String[] directoryList = documentsFolder.list();
            for (int counter = 1; counter < directoryList.length; counter++) {
                String check = documentsFolder.toString();
                if (check == directoryList[counter]) {
                    // open file
                    Intent file = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                    file.addCategory(Intent.CATEGORY_OPENABLE);
                    file.setType("root/internal/Documents/" + newFolderName + "/" + fileName + ".md");
                }
            }
        }
        catch (Exception openE) {
            System.out.print("error");
            openE.printStackTrace();
        }
    }
    static void renameN() {
        String fileName = "String";
        String folderName = "String";
        try {
            // get file location
            File target = new File("root/internal/Documents/" + folderName + "/" + fileName + ".md");
            // changing file directory
            File change = new File("root/internal/Documents/" + folderName + "/" + fileName + ".md");
        }
        catch (Exception renameE) {
            System.out.print("error");
            renameE.printStackTrace();
        }
    }
    static void deleteN() {
        String fileName = "String";
        String folderName = "String";
        try {
            // get file location
            File target = new File("root/internal/Documents/" + folderName + "/" + fileName + ".md");
            // remove file from directory
            target.delete();
        }
        catch (Exception deleteE) {
            System.out.print("error");
            deleteE.printStackTrace();
        }
    }
    static void moveN() {
        String fileName = "String";
        String folderName = "String";
        String newFolderName = "String";

        try {
            // get file location
            File target = new File("root/internal/Documents/" + folderName + "/" + fileName + ".md");
            // changing file directory
            File change = new File("root/internal/Documents/" + newFolderName + "/" + fileName + ".md");
        }
        catch (Exception moveE) {
            System.out.print("error");
            moveE.printStackTrace();
        }
    }
    static void editN() {
        String fileName = "String";
        String folderName = "String";
        String userInput = "String";
        // get file location
        try {
            FileWriter editor = new FileWriter("root/internal/Documents/" + folderName + "/" + fileName + ".md");
            // allow editing access
            editor.write(userInput);
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

