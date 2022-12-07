package folders;

import android.content.Intent;

import java.io.File;
import java.io.IOException;

public class Folders {
    static void newF() {
        // create new file in default
        try {
            String destination = "root/internal/Documents/newFold";
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
        try {
            File target = new File("");
            // get file location
            File documentsFolder = new File("root/internal/Documents/");
            String[] directoryList = documentsFolder.list();
            for (int counter = 1; counter < directoryList.length; counter++) {
            String check = documentsFolder.toString();
                if (check == directoryList[counter]) {
                    // open folder
                    Intent file = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                    file.addCategory(Intent.CATEGORY_OPENABLE);
                    file.setType("root/internal/Documents/");
                }
            }
        }
        catch (Exception openE) {
            System.out.print("error");
            openE.printStackTrace();
        }
    }

    static void renameF() {
        try {
            // get folder location
            File target = new File("");
            // changing folder directory
            File change = new File("");
        }
        catch (Exception renameE) {
            System.out.print("error");
            renameE.printStackTrace();
        }
    }
    static void deleteF() {
        try {
            // get folder location
            File target = new File("");
            // remove folder from directory
            target.delete();
        }
        catch (Exception deleteE) {
            System.out.print("error");
            deleteE.printStackTrace();
        }
    }
    static void moveF() {
        try {
            // get folder location
            File target = new File("");
            // changing folder directory
            File change = new File("");
        }
        catch (Exception moveE) {
            System.out.print("error");
            moveE.printStackTrace();
        }
    }
}
