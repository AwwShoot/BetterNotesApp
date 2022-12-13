package io.github.awwshoot.betternotesapp.folders;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;

import io.github.awwshoot.betternotesapp.R;

// A class to manage folders and directories for the app
public class Folders {
    /* Verifies all folders are created or creates them otherwise
     * This class should only be instantiated once at startup
     * Main's Context is passed to be used to read the templates and write them to the proper folder
     */
    public Folders(Context fileContext) throws IOException {
        File basePath = Environment.getExternalStorageDirectory();
        // Instantiate Docs folder to hold individual notes, and test if it is successfully created
        File noteFolder = new File(basePath + "/Documents/BetterNotes/Docs");
        if (!noteFolder.exists()) {
            if (!noteFolder.mkdir()) {
                Log.e("Folders", "Failed to instantiate folders(Docs)");
                return;
            }
            File allNotes = new File(noteFolder + "/All Docs");
            if (!allNotes.mkdir()) {
                Log.e("Folders", "Failed to instantiate folders(All Docs)");
                return;
            }
        }
        // Instantiate and tests folder for document options
        File optionsFolder = new File(basePath + "/Documents/BetterNotes/DocOptions");
        if (!optionsFolder.exists()){
            if (!optionsFolder.mkdir()) {
                Log.e("Folders", "Failed to instantiate folders(DocOptions)");
                return;
            }

        }
        // Instantiate/test templates folder. If it is not instantiated, populate it with default templates
        File templatesFolder = new File(basePath + "/Documents/BetterNotes/Templates");
        if (!templatesFolder.exists()) {
            if(!templatesFolder.mkdir()) {
                Log.e("Folders", "Failed to instantiate folders(Templates)");
                return;
            }
            // Templates have a specific ID which must be called individually as variables rather than iterated through (believe me I tried)
            // Expect the next... several lines to repeat over and over

            InputStream templateData = fileContext.getResources().openRawResource(R.raw.addresses); // raw IDs for these start at 1800000 and end at 1800022
            // Create the new template file in the desired location
            File nextTemplate = new File(templatesFolder + "/Addresses.txt");
            // This should create the file since File.createNewFile() just doesn't want to play nice
            //FileOutputStream writer = new FileOutputStream(nextTemplate);
            // Copy data from the original to the new file by scanning it and writing it line by line
            FileWriter templatePaster = new FileWriter(nextTemplate);
            Scanner templateCopier = new Scanner(templateData);
            while (templateCopier.hasNextLine()) {
                templatePaster.write(templateCopier.nextLine() + "\n");
            }


            templateData = fileContext.getResources().openRawResource(R.raw.budget); // raw IDs for these start at 1800000 and end at 1800022
            // Create the new template file in the desired location
            nextTemplate = new File(templatesFolder + "/" + "Budget" + ".txt");
            if (!nextTemplate.createNewFile()) {
                Log.e("Folders", "Failed to instantiate a template file: Budget");
                return;
            }
            // Copy data from the original to the new file by scanning it and writing it line by line
            templatePaster = new FileWriter(nextTemplate);
            templateCopier = new Scanner(templateData);
            while (templateCopier.hasNextLine()) {
                templatePaster.write(templateCopier.nextLine() + "\n");
            }

            templateData = fileContext.getResources().openRawResource(R.raw.chores); // raw IDs for these start at 1800000 and end at 1800022
            // Create the new template file in the desired location
            nextTemplate = new File(templatesFolder + "/" + "Chores" + ".txt");
            if (!nextTemplate.createNewFile()) {
                Log.e("Folders", "Failed to instantiate a template file: Chores");
                return;
            }
            // Copy data from the original to the new file by scanning it and writing it line by line
            templatePaster = new FileWriter(nextTemplate);
            templateCopier = new Scanner(templateData);
            while (templateCopier.hasNextLine()) {
                templatePaster.write(templateCopier.nextLine() + "\n");
            }

            templateData = fileContext.getResources().openRawResource(R.raw.creative); // raw IDs for these start at 1800000 and end at 1800022
            // Create the new template file in the desired location
            nextTemplate = new File(templatesFolder + "/" + "Creative" + ".txt");
            if (!nextTemplate.createNewFile()) {
                Log.e("Folders", "Failed to instantiate a template file: Creative");
                return;
            }
            // Copy data from the original to the new file by scanning it and writing it line by line
            templatePaster = new FileWriter(nextTemplate);
            templateCopier = new Scanner(templateData);
            while (templateCopier.hasNextLine()) {
                templatePaster.write(templateCopier.nextLine() + "\n");
            }

            templateData = fileContext.getResources().openRawResource(R.raw.dates); // raw IDs for these start at 1800000 and end at 1800022
            // Create the new template file in the desired location
            nextTemplate = new File(templatesFolder + "/" + "Dates" + ".txt");
            if (!nextTemplate.createNewFile()) {
                Log.e("Folders", "Failed to instantiate a template file: Dates");
                return;
            }
            // Copy data from the original to the new file by scanning it and writing it line by line
            templatePaster = new FileWriter(nextTemplate);
            templateCopier = new Scanner(templateData);
            while (templateCopier.hasNextLine()) {
                templatePaster.write(templateCopier.nextLine() + "\n");
            }

            templateData = fileContext.getResources().openRawResource(R.raw.diet); // raw IDs for these start at 1800000 and end at 1800022
            // Create the new template file in the desired location
            nextTemplate = new File(templatesFolder + "/" + "Diet" + ".txt");
            if (!nextTemplate.createNewFile()) {
                Log.e("Folders", "Failed to instantiate a template file: Diet");
                return;
            }
            // Copy data from the original to the new file by scanning it and writing it line by line
            templatePaster = new FileWriter(nextTemplate);
            templateCopier = new Scanner(templateData);
            while (templateCopier.hasNextLine()) {
                templatePaster.write(templateCopier.nextLine() + "\n");
            }

            templateData = fileContext.getResources().openRawResource(R.raw.food); // raw IDs for these start at 1800000 and end at 1800022
            // Create the new template file in the desired location
            nextTemplate = new File(templatesFolder + "/" + "Food" + ".txt");
            if (!nextTemplate.createNewFile()) {
                Log.e("Folders", "Failed to instantiate a template file: Food");
                return;
            }
            // Copy data from the original to the new file by scanning it and writing it line by line
            templatePaster = new FileWriter(nextTemplate);
            templateCopier = new Scanner(templateData);
            while (templateCopier.hasNextLine()) {
                templatePaster.write(templateCopier.nextLine() + "\n");
            }

            templateData = fileContext.getResources().openRawResource(R.raw.gifts); // raw IDs for these start at 1800000 and end at 1800022
            // Create the new template file in the desired location
            nextTemplate = new File(templatesFolder + "/" + "Gifts" + ".txt");
            if (!nextTemplate.createNewFile()) {
                Log.e("Folders", "Failed to instantiate a template file: Gifts");
                return;
            }
            // Copy data from the original to the new file by scanning it and writing it line by line
            templatePaster = new FileWriter(nextTemplate);
            templateCopier = new Scanner(templateData);
            while (templateCopier.hasNextLine()) {
                templatePaster.write(templateCopier.nextLine() + "\n");
            }

            templateData = fileContext.getResources().openRawResource(R.raw.groceries); // raw IDs for these start at 1800000 and end at 1800022
            // Create the new template file in the desired location
            nextTemplate = new File(templatesFolder + "/" + "Groceries" + ".txt");
            if (!nextTemplate.createNewFile()) {
                Log.e("Folders", "Failed to instantiate a template file: Groceries");
                return;
            }
            // Copy data from the original to the new file by scanning it and writing it line by line
            templatePaster = new FileWriter(nextTemplate);
            templateCopier = new Scanner(templateData);
            while (templateCopier.hasNextLine()) {
                templatePaster.write(templateCopier.nextLine() + "\n");
            }

            templateData = fileContext.getResources().openRawResource(R.raw.homework); // raw IDs for these start at 1800000 and end at 1800022
            // Create the new template file in the desired location
            nextTemplate = new File(templatesFolder + "/" + "Homework" + ".txt");
            if (!nextTemplate.createNewFile()) {
                Log.e("Folders", "Failed to instantiate a template file: Homework");
                return;
            }
            // Copy data from the original to the new file by scanning it and writing it line by line
            templatePaster = new FileWriter(nextTemplate);
            templateCopier = new Scanner(templateData);
            while (templateCopier.hasNextLine()) {
                templatePaster.write(templateCopier.nextLine() + "\n");
            }

            templateData = fileContext.getResources().openRawResource(R.raw.medication); // raw IDs for these start at 1800000 and end at 1800022
            // Create the new template file in the desired location
            nextTemplate = new File(templatesFolder + "/" + "Medication" + ".txt");
            if (!nextTemplate.createNewFile()) {
                Log.e("Folders", "Failed to instantiate a template file: Meds");
                return;
            }
            // Copy data from the original to the new file by scanning it and writing it line by line
            templatePaster = new FileWriter(nextTemplate);
            templateCopier = new Scanner(templateData);
            while (templateCopier.hasNextLine()) {
                templatePaster.write(templateCopier.nextLine() + "\n");
            }

            templateData = fileContext.getResources().openRawResource(R.raw.passwords); // raw IDs for these start at 1800000 and end at 1800022
            // Create the new template file in the desired location
            nextTemplate = new File(templatesFolder + "/" + "Passwords" + ".txt");
            if (!nextTemplate.createNewFile()) {
                Log.e("Folders", "Failed to instantiate a template file: Passwords");
                return;
            }
            // Copy data from the original to the new file by scanning it and writing it line by line
            templatePaster = new FileWriter(nextTemplate);
            templateCopier = new Scanner(templateData);
            while (templateCopier.hasNextLine()) {
                templatePaster.write(templateCopier.nextLine() + "\n");
            }

            templateData = fileContext.getResources().openRawResource(R.raw.plants); // raw IDs for these start at 1800000 and end at 1800022
            // Create the new template file in the desired location
            nextTemplate = new File(templatesFolder + "/" + "Plantcare" + ".txt");
            if (!nextTemplate.createNewFile()) {
                Log.e("Folders", "Failed to instantiate a template file: I am copy/paste/filling shit out at 1 am for a group project due in under 72 hours.");
                return;
            }
            // Copy data from the original to the new file by scanning it and writing it line by line
            templatePaster = new FileWriter(nextTemplate);
            templateCopier = new Scanner(templateData);
            while (templateCopier.hasNextLine()) {
                templatePaster.write(templateCopier.nextLine() + "\n");
            }

            templateData = fileContext.getResources().openRawResource(R.raw.project); // raw IDs for these start at 1800000 and end at 1800022
            // Create the new template file in the desired location
            nextTemplate = new File(templatesFolder + "/" + "SchoolProject" + ".txt");
            if (!nextTemplate.createNewFile()) {
                Log.e("Folders", "Failed to instantiate a template file: project");
                return;
            }
            // Copy data from the original to the new file by scanning it and writing it line by line
            templatePaster = new FileWriter(nextTemplate);
            templateCopier = new Scanner(templateData);
            while (templateCopier.hasNextLine()) {
                templatePaster.write(templateCopier.nextLine() + "\n");
            }

            templateData = fileContext.getResources().openRawResource(R.raw.quotes); // raw IDs for these start at 1800000 and end at 1800022
            // Create the new template file in the desired location
            nextTemplate = new File(templatesFolder + "/" + "FamousQuotes" + ".txt");
            if (!nextTemplate.createNewFile()) {
                Log.e("Folders", "Failed to instantiate a template file: quotes");
                return;
            }
            // Copy data from the original to the new file by scanning it and writing it line by line
            templatePaster = new FileWriter(nextTemplate);
            templateCopier = new Scanner(templateData);
            while (templateCopier.hasNextLine()) {
                templatePaster.write(templateCopier.nextLine() + "\n");
            }

            templateData = fileContext.getResources().openRawResource(R.raw.reading); // raw IDs for these start at 1800000 and end at 1800022
            // Create the new template file in the desired location
            nextTemplate = new File(templatesFolder + "/" + "BookList" + ".txt");
            if (!nextTemplate.createNewFile()) {
                Log.e("Folders", "Failed to instantiate a template file: reading");
                return;
            }
            // Copy data from the original to the new file by scanning it and writing it line by line
            templatePaster = new FileWriter(nextTemplate);
            templateCopier = new Scanner(templateData);
            while (templateCopier.hasNextLine()) {
                templatePaster.write(templateCopier.nextLine() + "\n");
            }

            templateData = fileContext.getResources().openRawResource(R.raw.recipes); // raw IDs for these start at 1800000 and end at 1800022
            // Create the new template file in the desired location
            nextTemplate = new File(templatesFolder + "/" + "Recipe" + ".txt");
            if (!nextTemplate.createNewFile()) {
                Log.e("Folders", "Failed to instantiate a template file: technically also Food");
                return;
            }
            // Copy data from the original to the new file by scanning it and writing it line by line
            templatePaster = new FileWriter(nextTemplate);
            templateCopier = new Scanner(templateData);
            while (templateCopier.hasNextLine()) {
                templatePaster.write(templateCopier.nextLine() + "\n");
            }

            templateData = fileContext.getResources().openRawResource(R.raw.recommendation); // raw IDs for these start at 1800000 and end at 1800022
            // Create the new template file in the desired location
            nextTemplate = new File(templatesFolder + "/" + "Media" + ".txt");
            if (!nextTemplate.createNewFile()) {
                Log.e("Folders", "Failed to instantiate a template file: recommendatiom");
                return;
            }
            // Copy data from the original to the new file by scanning it and writing it line by line
            templatePaster = new FileWriter(nextTemplate);
            templateCopier = new Scanner(templateData);
            while (templateCopier.hasNextLine()) {
                templatePaster.write(templateCopier.nextLine() + "\n");
            }

            templateData = fileContext.getResources().openRawResource(R.raw.routines); // raw IDs for these start at 1800000 and end at 1800022
            // Create the new template file in the desired location
            nextTemplate = new File(templatesFolder + "/" + "SelfCare" + ".txt");
            if (!nextTemplate.createNewFile()) {
                Log.e("Folders", "Failed to instantiate a template file: routines");
                return;
            }
            // Copy data from the original to the new file by scanning it and writing it line by line
            templatePaster = new FileWriter(nextTemplate);
            templateCopier = new Scanner(templateData);
            while (templateCopier.hasNextLine()) {
                templatePaster.write(templateCopier.nextLine() + "\n");
            }

            templateData = fileContext.getResources().openRawResource(R.raw.sizes); // raw IDs for these start at 1800000 and end at 1800022
            // Create the new template file in the desired location
            nextTemplate = new File(templatesFolder + "/" + "ClothingSizes" + ".txt");
            if (!nextTemplate.createNewFile()) {
                Log.e("Folders", "Failed to instantiate a template file: sizes");
                return;
            }
            // Copy data from the original to the new file by scanning it and writing it line by line
            templatePaster = new FileWriter(nextTemplate);
            templateCopier = new Scanner(templateData);
            while (templateCopier.hasNextLine()) {
                templatePaster.write(templateCopier.nextLine() + "\n");
            }

            templateData = fileContext.getResources().openRawResource(R.raw.travel); // raw IDs for these start at 1800000 and end at 1800022
            // Create the new template file in the desired location
            nextTemplate = new File(templatesFolder + "/" + "Packing" + ".txt");
            if (!nextTemplate.createNewFile()) {
                Log.e("Folders", "Failed to instantiate a template file: travel");
                return;
            }
            // Copy data from the original to the new file by scanning it and writing it line by line
            templatePaster = new FileWriter(nextTemplate);
            templateCopier = new Scanner(templateData);
            while (templateCopier.hasNextLine()) {
                templatePaster.write(templateCopier.nextLine() + "\n");
            }

            templateData = fileContext.getResources().openRawResource(R.raw.watchlist); // raw IDs for these start at 1800000 and end at 1800022
            // Create the new template file in the desired location
            nextTemplate = new File(templatesFolder + "/" + "TV" + ".txt");
            if (!nextTemplate.createNewFile()) {
                Log.e("Folders", "Failed to instantiate a template file: watchlist");
                return;
            }
            // Copy data from the original to the new file by scanning it and writing it line by line
            templatePaster = new FileWriter(nextTemplate);
            templateCopier = new Scanner(templateData);
            while (templateCopier.hasNextLine()) {
                templatePaster.write(templateCopier.nextLine() + "\n");
            }

            templateData = fileContext.getResources().openRawResource(R.raw.workouts); // raw IDs for these start at 1800000 and end at 1800022
            // Create the new template file in the desired location
            nextTemplate = new File(templatesFolder + "/" + "Exercise" + ".txt");
            if (!nextTemplate.createNewFile()) {
                Log.e("Folders", "Failed to instantiate a template file: workouts");
                return;
            }
            // Copy data from the original to the new file by scanning it and writing it line by line
            templatePaster = new FileWriter(nextTemplate);
            templateCopier = new Scanner(templateData);
            while (templateCopier.hasNextLine()) {
                templatePaster.write(templateCopier.nextLine() + "\n");
            }

            // This is gross code and I know it. ^^







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
            Log.e("error","error");
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
            Log.e("error","error");
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
            Log.e("error","error");
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
            Log.e("error","error");
            moveE.printStackTrace();
        }
    }
}
