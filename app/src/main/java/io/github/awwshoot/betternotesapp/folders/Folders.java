package io.github.awwshoot.betternotesapp.folders;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import io.github.awwshoot.betternotesapp.R;

// A class to manage folders and directories for the app
public class Folders {
    /* Verifies all folders are created or creates them otherwise
     * This class should only be instantiated once at startup
     * Main's Context is passed to be used to read the templates and write them to the proper folder
     */
    public File basePath;
    public File templatesFolder;
    public File docFolder;
    public File noteFolder;
    public File optionsFolder;
    public Folders(Context fileContext) throws IOException {
        this.basePath = Environment.getExternalStorageDirectory();
        // Instantiate Docs folder to hold individual notes, and test if it is successfully created
        this.docFolder = new File(basePath + "/Documents/BetterNotes/Docs");
        if (!docFolder.exists()) {
            if (!docFolder.mkdir()) {
                Log.e("Folders", "Failed to instantiate folders(Docs)");
                return;
            }
            this.noteFolder = new File(docFolder + "/All Docs");
            if (!noteFolder.mkdir()) {
                Log.e("Folders", "Failed to instantiate folders(All Docs)");
                return;
            }
        }
        // Instantiate and tests folder for document options
        this.optionsFolder = new File(basePath + "/Documents/BetterNotes/DocOptions");
        if (!optionsFolder.exists()){
            if (!optionsFolder.mkdir()) {
                Log.e("Folders", "Failed to instantiate folders(DocOptions)");
                return;
            }

        }
        // Instantiate/test templates folder. If it is not instantiated, populate it with default templates
        this.templatesFolder = new File(basePath + "/Documents/BetterNotes/Templates");
        if (!templatesFolder.exists()) {
            if (!templatesFolder.mkdir()) {
                Log.e("Folders", "Failed to instantiate folders(Templates)");
                return;
            }
        }
        if (templatesFolder.list().length == 0) {
            // Templates have a specific ID which must be called individually as variables rather than iterated through (believe me I tried)
            // Expect the next... several lines to repeat over and over

            InputStream templateData = fileContext.getResources().openRawResource(R.raw.addresses); // raw IDs for these start at 1800000 and end at 1800022
            // Create the new template file in the desired location
            File nextTemplate = new File(templatesFolder + "/Addresses.txt");
            // This should create the file since File.createNewFile() just doesn't want to play nice
            // Copy data from the original to the new file by scanning it and writing it line by line
            FileWriter templatePaster = new FileWriter(nextTemplate);
            Scanner templateCopier = new Scanner(templateData);
            while (templateCopier.hasNextLine()) {
                templatePaster.write(templateCopier.nextLine() + "\n");
            }
            templatePaster.close();
            templateCopier.close();
            templateData.close();


            templateData = fileContext.getResources().openRawResource(R.raw.budget); // raw IDs for these start at 1800000 and end at 1800022
            // Create the new template file in the desired location
            nextTemplate = new File(templatesFolder + "/" + "Budget" + ".txt");
            // Copy data from the original to the new file by scanning it and writing it line by line
            templatePaster = new FileWriter(nextTemplate);
            templateCopier = new Scanner(templateData);
            while (templateCopier.hasNextLine()) {
                templatePaster.write(templateCopier.nextLine() + "\n");
            }
            templatePaster.close();
            templateCopier.close();
            templateData.close();

            templateData = fileContext.getResources().openRawResource(R.raw.chores); // raw IDs for these start at 1800000 and end at 1800022
            // Create the new template file in the desired location
            nextTemplate = new File(templatesFolder + "/" + "Chores" + ".txt");
            // Copy data from the original to the new file by scanning it and writing it line by line
            templatePaster = new FileWriter(nextTemplate);
            templateCopier = new Scanner(templateData);
            while (templateCopier.hasNextLine()) {
                templatePaster.write(templateCopier.nextLine() + "\n");
            }
            templatePaster.close();
            templateCopier.close();
            templateData.close();

            templateData = fileContext.getResources().openRawResource(R.raw.creative); // raw IDs for these start at 1800000 and end at 1800022
            // Create the new template file in the desired location
            nextTemplate = new File(templatesFolder + "/" + "Creative" + ".txt");
            // Copy data from the original to the new file by scanning it and writing it line by line
            templatePaster = new FileWriter(nextTemplate);
            templateCopier = new Scanner(templateData);
            while (templateCopier.hasNextLine()) {
                templatePaster.write(templateCopier.nextLine() + "\n");
            }
            templatePaster.close();
            templateCopier.close();
            templateData.close();

            templateData = fileContext.getResources().openRawResource(R.raw.dates); // raw IDs for these start at 1800000 and end at 1800022
            // Create the new template file in the desired location
            nextTemplate = new File(templatesFolder + "/" + "Dates" + ".txt");
            // Copy data from the original to the new file by scanning it and writing it line by line
            templatePaster = new FileWriter(nextTemplate);
            templateCopier = new Scanner(templateData);
            while (templateCopier.hasNextLine()) {
                templatePaster.write(templateCopier.nextLine() + "\n");
            }
            templatePaster.close();
            templateCopier.close();
            templateData.close();

            templateData = fileContext.getResources().openRawResource(R.raw.diet); // raw IDs for these start at 1800000 and end at 1800022
            // Create the new template file in the desired location
            nextTemplate = new File(templatesFolder + "/" + "Diet" + ".txt");
            // Copy data from the original to the new file by scanning it and writing it line by line
            templatePaster = new FileWriter(nextTemplate);
            templateCopier = new Scanner(templateData);
            while (templateCopier.hasNextLine()) {
                templatePaster.write(templateCopier.nextLine() + "\n");
            }
            templatePaster.close();
            templateCopier.close();
            templateData.close();

            templateData = fileContext.getResources().openRawResource(R.raw.food); // raw IDs for these start at 1800000 and end at 1800022
            // Create the new template file in the desired location
            nextTemplate = new File(templatesFolder + "/" + "Food" + ".txt");
            // Copy data from the original to the new file by scanning it and writing it line by line
            templatePaster = new FileWriter(nextTemplate);
            templateCopier = new Scanner(templateData);
            while (templateCopier.hasNextLine()) {
                templatePaster.write(templateCopier.nextLine() + "\n");
            }
            templatePaster.close();
            templateCopier.close();
            templateData.close();

            templateData = fileContext.getResources().openRawResource(R.raw.gifts); // raw IDs for these start at 1800000 and end at 1800022
            // Create the new template file in the desired location
            nextTemplate = new File(templatesFolder + "/" + "Gifts" + ".txt");
            // Copy data from the original to the new file by scanning it and writing it line by line
            templatePaster = new FileWriter(nextTemplate);
            templateCopier = new Scanner(templateData);
            while (templateCopier.hasNextLine()) {
                templatePaster.write(templateCopier.nextLine() + "\n");
            }
            templatePaster.close();
            templateCopier.close();
            templateData.close();

            templateData = fileContext.getResources().openRawResource(R.raw.groceries); // raw IDs for these start at 1800000 and end at 1800022
            // Create the new template file in the desired location
            nextTemplate = new File(templatesFolder + "/" + "Groceries" + ".txt");
            // Copy data from the original to the new file by scanning it and writing it line by line
            templatePaster = new FileWriter(nextTemplate);
            templateCopier = new Scanner(templateData);
            while (templateCopier.hasNextLine()) {
                templatePaster.write(templateCopier.nextLine() + "\n");
            }
            templatePaster.close();
            templateCopier.close();
            templateData.close();

            templateData = fileContext.getResources().openRawResource(R.raw.homework); // raw IDs for these start at 1800000 and end at 1800022
            // Create the new template file in the desired location
            nextTemplate = new File(templatesFolder + "/" + "Homework" + ".txt");
            // Copy data from the original to the new file by scanning it and writing it line by line
            templatePaster = new FileWriter(nextTemplate);
            templateCopier = new Scanner(templateData);
            while (templateCopier.hasNextLine()) {
                templatePaster.write(templateCopier.nextLine() + "\n");
            }
            templatePaster.close();
            templateCopier.close();
            templateData.close();

            templateData = fileContext.getResources().openRawResource(R.raw.medication); // raw IDs for these start at 1800000 and end at 1800022
            // Create the new template file in the desired location
            nextTemplate = new File(templatesFolder + "/" + "Medication" + ".txt");
            // Copy data from the original to the new file by scanning it and writing it line by line
            templatePaster = new FileWriter(nextTemplate);
            templateCopier = new Scanner(templateData);
            while (templateCopier.hasNextLine()) {
                templatePaster.write(templateCopier.nextLine() + "\n");
            }
            templatePaster.close();
            templateCopier.close();
            templateData.close();

            templateData = fileContext.getResources().openRawResource(R.raw.passwords); // raw IDs for these start at 1800000 and end at 1800022
            // Create the new template file in the desired location
            nextTemplate = new File(templatesFolder + "/" + "Passwords" + ".txt");
            // Copy data from the original to the new file by scanning it and writing it line by line
            templatePaster = new FileWriter(nextTemplate);
            templateCopier = new Scanner(templateData);
            while (templateCopier.hasNextLine()) {
                templatePaster.write(templateCopier.nextLine() + "\n");
            }
            templatePaster.close();
            templateCopier.close();
            templateData.close();

            templateData = fileContext.getResources().openRawResource(R.raw.plants); // raw IDs for these start at 1800000 and end at 1800022
            // Create the new template file in the desired location
            nextTemplate = new File(templatesFolder + "/" + "Plantcare" + ".txt");
            // Copy data from the original to the new file by scanning it and writing it line by line
            templatePaster = new FileWriter(nextTemplate);
            templateCopier = new Scanner(templateData);
            while (templateCopier.hasNextLine()) {
                templatePaster.write(templateCopier.nextLine() + "\n");
            }
            templatePaster.close();
            templateCopier.close();
            templateData.close();

            templateData = fileContext.getResources().openRawResource(R.raw.project); // raw IDs for these start at 1800000 and end at 1800022
            // Create the new template file in the desired location
            nextTemplate = new File(templatesFolder + "/" + "SchoolProject" + ".txt");
            // Copy data from the original to the new file by scanning it and writing it line by line
            templatePaster = new FileWriter(nextTemplate);
            templateCopier = new Scanner(templateData);
            while (templateCopier.hasNextLine()) {
                templatePaster.write(templateCopier.nextLine() + "\n");
            }
            templatePaster.close();
            templateCopier.close();
            templateData.close();

            templateData = fileContext.getResources().openRawResource(R.raw.quotes); // raw IDs for these start at 1800000 and end at 1800022
            // Create the new template file in the desired location
            nextTemplate = new File(templatesFolder + "/" + "FamousQuotes" + ".txt");
            // Copy data from the original to the new file by scanning it and writing it line by line
            templatePaster = new FileWriter(nextTemplate);
            templateCopier = new Scanner(templateData);
            while (templateCopier.hasNextLine()) {
                templatePaster.write(templateCopier.nextLine() + "\n");
            }
            templatePaster.close();
            templateCopier.close();
            templateData.close();

            templateData = fileContext.getResources().openRawResource(R.raw.reading); // raw IDs for these start at 1800000 and end at 1800022
            // Create the new template file in the desired location
            nextTemplate = new File(templatesFolder + "/" + "BookList" + ".txt");
            // Copy data from the original to the new file by scanning it and writing it line by line
            templatePaster = new FileWriter(nextTemplate);
            templateCopier = new Scanner(templateData);
            while (templateCopier.hasNextLine()) {
                templatePaster.write(templateCopier.nextLine() + "\n");
            }
            templatePaster.close();
            templateCopier.close();
            templateData.close();

            templateData = fileContext.getResources().openRawResource(R.raw.recipes); // raw IDs for these start at 1800000 and end at 1800022
            // Create the new template file in the desired location
            nextTemplate = new File(templatesFolder + "/" + "Recipe" + ".txt");
            // Copy data from the original to the new file by scanning it and writing it line by line
            templatePaster = new FileWriter(nextTemplate);
            templateCopier = new Scanner(templateData);
            while (templateCopier.hasNextLine()) {
                templatePaster.write(templateCopier.nextLine() + "\n");
            }
            templatePaster.close();
            templateCopier.close();
            templateData.close();

            templateData = fileContext.getResources().openRawResource(R.raw.recommendation); // raw IDs for these start at 1800000 and end at 1800022
            // Create the new template file in the desired location
            nextTemplate = new File(templatesFolder + "/" + "Media" + ".txt");
            // Copy data from the original to the new file by scanning it and writing it line by line
            templatePaster = new FileWriter(nextTemplate);
            templateCopier = new Scanner(templateData);
            while (templateCopier.hasNextLine()) {
                templatePaster.write(templateCopier.nextLine() + "\n");
            }
            templatePaster.close();
            templateCopier.close();
            templateData.close();

            templateData = fileContext.getResources().openRawResource(R.raw.routines); // raw IDs for these start at 1800000 and end at 1800022
            // Create the new template file in the desired location
            nextTemplate = new File(templatesFolder + "/" + "SelfCare" + ".txt");
            // Copy data from the original to the new file by scanning it and writing it line by line
            templatePaster = new FileWriter(nextTemplate);
            templateCopier = new Scanner(templateData);
            while (templateCopier.hasNextLine()) {
                templatePaster.write(templateCopier.nextLine() + "\n");
            }
            templatePaster.close();
            templateCopier.close();
            templateData.close();

            templateData = fileContext.getResources().openRawResource(R.raw.sizes); // raw IDs for these start at 1800000 and end at 1800022
            // Create the new template file in the desired location
            nextTemplate = new File(templatesFolder + "/" + "ClothingSizes" + ".txt");
            // Copy data from the original to the new file by scanning it and writing it line by line
            templatePaster = new FileWriter(nextTemplate);
            templateCopier = new Scanner(templateData);
            while (templateCopier.hasNextLine()) {
                templatePaster.write(templateCopier.nextLine() + "\n");
            }
            templatePaster.close();
            templateCopier.close();
            templateData.close();

            templateData = fileContext.getResources().openRawResource(R.raw.travel); // raw IDs for these start at 1800000 and end at 1800022
            // Create the new template file in the desired location
            nextTemplate = new File(templatesFolder + "/" + "Packing" + ".txt");
            // Copy data from the original to the new file by scanning it and writing it line by line
            templatePaster = new FileWriter(nextTemplate);
            templateCopier = new Scanner(templateData);
            while (templateCopier.hasNextLine()) {
                templatePaster.write(templateCopier.nextLine() + "\n");
            }
            templatePaster.close();
            templateCopier.close();
            templateData.close();

            templateData = fileContext.getResources().openRawResource(R.raw.watchlist); // raw IDs for these start at 1800000 and end at 1800022
            // Create the new template file in the desired location
            nextTemplate = new File(templatesFolder + "/" + "TV" + ".txt");
            // Copy data from the original to the new file by scanning it and writing it line by line
            templatePaster = new FileWriter(nextTemplate);
            templateCopier = new Scanner(templateData);
            while (templateCopier.hasNextLine()) {
                templatePaster.write(templateCopier.nextLine() + "\n");
            }
            templatePaster.close();
            templateCopier.close();
            templateData.close();

            templateData = fileContext.getResources().openRawResource(R.raw.workouts); // raw IDs for these start at 1800000 and end at 1800022
            // Create the new template file in the desired location
            nextTemplate = new File(templatesFolder + "/" + "Exercise" + ".txt");
            // Copy data from the original to the new file by scanning it and writing it line by line
            templatePaster = new FileWriter(nextTemplate);
            templateCopier = new Scanner(templateData);
            while (templateCopier.hasNextLine()) {
                templatePaster.write(templateCopier.nextLine() + "\n");
            }
            templatePaster.close();
            templateCopier.close();
            templateData.close();

            // This is gross code and I know it. ^^







        }

    }

}
