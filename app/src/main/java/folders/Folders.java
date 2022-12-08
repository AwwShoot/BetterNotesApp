package folders;

import android.content.Intent;

import java.io.File;
import java.io.IOException;

public class Folders {
    static void newF() {
        String folderName = "String";
        // create new file in default
        try {
            String destination = "root/internal/Documents/" + folderName;
            File file = new File(destination);
            if (file.mkdirs()) {
                renameF();
                openF();
            }
            else {
                System.out.print("that note already exists");
            }
        }
        catch (Exception newE) {
            System.out.print("error");
            newE.printStackTrace();
        }
    }

    static void openF() {
        String folderName = "String";
        try {
            File target = new File("");
            // get file location
            File documentsFolder = new File("root/internal/Documents/" +folderName);
            String[] directoryList = documentsFolder.list();
            for (int counter = 1; counter < directoryList.length; counter++) {
            String check = documentsFolder.toString();
                if (check == directoryList[counter]) {
                    // open folder
                    Intent file = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                    file.addCategory(Intent.CATEGORY_OPENABLE);
                    file.setType("root/internal/Documents/" + folderName);
                }
            }
        }
        catch (Exception openE) {
            System.out.print("error");
            openE.printStackTrace();
        }
    }

    static void renameF() {
        String folderName = "String";
        try {
            // get folder location
            File target = new File("root/internal/Documents/" + folderName);
            // changing folder directory
            File change = new File("root/internal/Documents/" + folderName);
        }
        catch (Exception renameE) {
            System.out.print("error");
            renameE.printStackTrace();
        }
    }
    static void deleteF() {
        String folderName = "String";
        try {
            // get folder location
            File target = new File("root/internal/Documents/" + folderName);
            // remove folder from directory
            target.delete();
        }
        catch (Exception deleteE) {
            System.out.print("error");
            deleteE.printStackTrace();
        }
    }
    static void moveF() {
        String folderName = "String";
        try {
            // get folder location
            File target = new File("root/internal/Documents/" + folderName);
            // changing folder directory
            File change = new File("root/internal/Documents/" + folderName);
        }
        catch (Exception moveE) {
            System.out.print("error");
            moveE.printStackTrace();
        }
    }
}
