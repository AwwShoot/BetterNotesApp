package folders;

import android.content.Intent;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.util.Log;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.Exception;

public class Note {

    public static void newNote(String fileName, String folderName, String templateName) {
        // create new file in default
        try {
            // create new file
            String documentPath = Environment.getExternalStorageDirectory().getPath();
            Log.i("Notes", documentPath);
            File newNote = new File(documentPath + folderName + fileName + ".txt");
            if (!newNote.createNewFile()) {
                Log.e("Notes", "Filename already in use or file cannot be created");
                Log.i("Notes", documentPath);
                return;
            }
            Log.i("Notes", "Successfully created file: " + newNote);
            // read/write whatever is in template
            FileReader reader = new FileReader(templateName + ".txt");
            FileWriter writer = new FileWriter(newNote);
            char[] buffer = new char[1];
            while (reader.read(buffer, 0, 1) != -1) {
                writer.write(buffer, 0, 1); // magic numbers because I can't be bothered right now
            }



            // change file name and location

            // open file
            openNote();
        } catch (IOException newE) {
            Log.e("error","error");
            newE.printStackTrace();
        }
    }

    // request code for picking .md file
    private static final int PICK_MD_FILE = 2;

    static void openNote() {
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
                if (check.equals(directoryList[counter])) {
                    // open file
                    Intent file = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                    file.addCategory(Intent.CATEGORY_OPENABLE);
                    file.setType("root/internal/Documents/" + newFolderName + "/" + fileName + ".md");
                    // specifying URI directory to be opened by system file picker
                    file.putExtra(DocumentsContract.EXTRA_INITIAL_URI, "root/internal/Documents/" + newFolderName + "/");
                    // **
                    startActivityForResult(file, PICK_MD_FILE);
                }
            }
        }
        catch (Exception openE) {
            Log.e("error","error");
            openE.printStackTrace();
        }
    }

    private static void startActivityForResult(Intent file, int pickMdFile) {

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

