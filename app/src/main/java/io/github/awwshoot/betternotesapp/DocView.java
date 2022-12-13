package io.github.awwshoot.betternotesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class DocView extends AppCompatActivity {

    // Stores names of traversed directories
    ArrayList<String> str = new ArrayList<String>();

    // Check if the first level of the directory structure is the one showing

    // Option 1 means first level, -1 means file chooser, 2 means choose options for doc
    private int firstLvl = 0;

    private static final String TAG = "F_PATH";

    private Item[] fileList;
    private File path = new File(Environment.getExternalStorageDirectory() + "/Documents/BetterNotes/Docs");
    private File templatePath = new File(Environment.getExternalStorageDirectory() + "/Documents/BetterNotes/Templates");
    private File oldFilePath = new File(Environment.getExternalStorageDirectory() + "/Documents/BetterNotes/Docs");
    private String chosenFile;
    private static final int DIALOG_LOAD_FILE = 1000;

    ListAdapter adapter;
    String documentName;
    @Override
    public void onCreate(Bundle savedInstanceState) {

        // Get Document Name
        Bundle bundle = getIntent().getExtras();
        documentName = bundle.getString("message");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_view);
        loadFileList();

        showDialog(DIALOG_LOAD_FILE);
        Log.d(TAG, path.getAbsolutePath());

    }

    private void loadFileList() {
        try {
            path.mkdirs();
        } catch (SecurityException e) {
            Log.e(TAG, "unable to write on the sd card ");
        }

        // Checks whether path exists
        if (path.exists()) {
            FilenameFilter filter = new FilenameFilter() {
                @Override
                public boolean accept(File dir, String filename) {
                    File sel = new File(dir, filename);
                    // Filters based on whether the file is hidden or not
                    return (sel.isFile() || sel.isDirectory())
                            && !sel.isHidden();

                }
            };

            String[] fList = path.list(filter);
            fileList = new Item[fList.length];
            for (int i = 0; i < fList.length; i++) {
                fileList[i] = new Item(fList[i], R.drawable.file_icon);

                // Convert into file path
                File sel = new File(path, fList[i]);

                // Set drawables
                if (sel.isDirectory()) {
                    fileList[i].icon = R.drawable.directory_icon;
                    Log.d("DIRECTORY", fileList[i].file);
                } else {
                    Log.d("FILE", fileList[i].file);
                }
            }

            if (firstLvl == -1) {
                Item temp[] = new Item[fileList.length + 4];
                for (int i = 0; i < fileList.length; i++) {
                    temp[i+4] = fileList[i];
                }
                temp[0] = new Item("Up", R.drawable.directory_up);
                temp[1] = new Item("Delete Folder", R.drawable.directory_options);
                temp[2] = new Item("Rename Folder", R.drawable.directory_options);
                temp[3] = new Item("Add Document", R.drawable.directory_options);
                fileList = temp;
            }
            else if (firstLvl == 2) {
                Item temp[] = new Item[fileList.length + 3];
                for (int i = 0; i < fileList.length; i++) {
                    temp[i+3] = fileList[i];
                }
                temp[0] = new Item("Open File", R.drawable.directory_up);
                temp[1] = new Item("Delete File", R.drawable.directory_options);
                temp[2] = new Item("Rename File", R.drawable.directory_options);
                fileList = temp;
            }
        } else {
            Log.e(TAG, "path does not exist");
        }

        adapter = new ArrayAdapter<Item>(this,
                android.R.layout.select_dialog_item, android.R.id.text1,
                fileList) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                // creates view
                View view = super.getView(position, convertView, parent);
                TextView textView = (TextView) view
                        .findViewById(android.R.id.text1);

                // put the image on the text view
                textView.setCompoundDrawablesWithIntrinsicBounds(
                        fileList[position].icon, 0, 0, 0);

                // add margin between image and text (support various screen
                // densities)
                int dp5 = (int) (5 * getResources().getDisplayMetrics().density + 0.5f);
                textView.setCompoundDrawablePadding(dp5);

                return view;
            }
        };

    }

    private class Item {
        public String file;
        public int icon;

        public Item(String file, Integer icon) {
            this.file = file;
            this.icon = icon;
        }

        @Override
        public String toString() {
            return file;
        }
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        Dialog dialog = null;
        AlertDialog.Builder builder = new Builder(this);

        if (fileList == null) {
            Log.e(TAG, "No files loaded");
            dialog = builder.create();
            return dialog;
        }

        switch (id) {
            case DIALOG_LOAD_FILE:

                builder.setTitle("Choose your file");
                builder.setAdapter(adapter, new DialogInterface.OnClickListener() {

                    // Handles Navigation by single press
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        chosenFile = fileList[which].file;
                        File sel = new File(path + "/" + chosenFile);
                        if (sel.isDirectory()) {
                            firstLvl = -1;

                            // Adds chosen directory to list
                            str.add(chosenFile);
                            fileList = null;
                            path = new File(sel + "");

                            loadFileList();

                            removeDialog(DIALOG_LOAD_FILE);
                            showDialog(DIALOG_LOAD_FILE);
                            Log.d(TAG, path.getAbsolutePath());

                        }

                        // Checks if 'up' was clicked
                        else if (chosenFile.equalsIgnoreCase("up") && !sel.exists()) {

                            // present directory removed from list
                            String s = str.remove(str.size() - 1);

                            // path modified to exclude present directory
                            path = new File(path.toString().substring(0,
                                    path.toString().lastIndexOf(s)));
                            fileList = null;

                            // if there are no more directories in the list, then
                            // its the first level
                            if (str.isEmpty()) {
                                firstLvl = 1;
                            }
                            loadFileList();

                            removeDialog(DIALOG_LOAD_FILE);
                            showDialog(DIALOG_LOAD_FILE);
                            Log.d(TAG, path.getAbsolutePath());

                        }
                        // Create a Document Here
                        else if (chosenFile.equalsIgnoreCase("Add Document") && !sel.exists()) {
                            Toast.makeText(DocView.this, "Chose a Template", Toast.LENGTH_LONG).show();
                            // Handle Creating a Document
                            // Change to activity for selecting template


                            // Get file path saved
                            oldFilePath = path;

                            // Move to Template Folder
                            firstLvl = 1;
                            path = new File(Environment.getExternalStorageDirectory() + "/Documents/BetterNotes/Templates");
                            loadFileList();
                            removeDialog(DIALOG_LOAD_FILE);
                            showDialog(DIALOG_LOAD_FILE);

                            Log.d(TAG, path.getAbsolutePath());

                        }
                        // Rename the folder
                        else if (chosenFile.equalsIgnoreCase("Rename Folder") && !sel.exists()) {
                            Toast.makeText(DocView.this, "Rename Folder selected", Toast.LENGTH_LONG).show();
                            // Open options menu

                        }
                        // Delete the folder
                        else if (chosenFile.equalsIgnoreCase("Delete Folder") && !sel.exists()) {
                            Toast.makeText(DocView.this, "Delete Folder selected", Toast.LENGTH_LONG).show();

                            // Go up a folder

                            // present directory removed from list
                            String s = str.remove(str.size() - 1);

                            // path modified to exclude present directory
                            path = new File(path.toString().substring(0,
                                    path.toString().lastIndexOf(s)));

                            if (str.isEmpty()) {
                                firstLvl = 1;
                            }
                            loadFileList();

                            removeDialog(DIALOG_LOAD_FILE);
                            showDialog(DIALOG_LOAD_FILE);
                            Log.d(TAG, path.getAbsolutePath());

                            // Then delete the folder (the variable you need is chosenFile, you can get the path with chosenFile.getAbsolutePath())

                        }

                        // Document Options
                        else if (chosenFile.equalsIgnoreCase("Open File") && !sel.exists()) {
                            // Path to file that is to be opened
                            String newPath = oldFilePath.getAbsolutePath() + "/" + documentName;

                            // Call open document
                            // Since its an existing file the template path will be the same as the file path
                            openDocument(newPath, newPath);
                        }
                        else if (chosenFile.equalsIgnoreCase("Delete File") && !sel.exists()) {
                            // Path to file that is to be deleted
                            String newPath = oldFilePath.getAbsolutePath() + "/" + documentName;
                        }
                        else if (chosenFile.equalsIgnoreCase("Rename File") && !sel.exists()) {
                            // Path to file that is to be renamed
                            String newPath = oldFilePath.getAbsolutePath() + "/" + documentName;
                        }




                        // File picked to then choose options
                        else {

                            // Get file path saved
                            oldFilePath = path;

                            // Perform action with file picked
                            // File functionality goes here


                            // Determine whether user is opening a template, or existing document

                            // User is opening Template
                            if (path.getName().contains("Templates")) {
                                Toast.makeText(DocView.this, "Choose a template", Toast.LENGTH_LONG).show();
                                // Create the Document, take name from the front page

                                // Path of template
                                String templatePath = sel.getAbsolutePath();


                                // Path to file that is to be created
                                String newPath = oldFilePath.getAbsolutePath() + "/" + documentName;

                                // Call create doc function
                                openDocument(templatePath, newPath);
                            }




                            // User is opening existing document
                            else {
                                Toast.makeText(DocView.this, sel.getPath(), Toast.LENGTH_LONG).show();
                                // Determine whether they want to rename, delete or open

                                // Send user to new dialog option menu to make a choice
                                // Move to Document Option Menu
                                firstLvl = 2;

                                path = new File(Environment.getExternalStorageDirectory() + "/Documents/BetterNotes/DocOptions");
                                loadFileList();
                                removeDialog(DIALOG_LOAD_FILE);
                                showDialog(DIALOG_LOAD_FILE);

                                Log.d(TAG, path.getAbsolutePath());
                            }
                        }

                    }

                });

                break;
        }
        dialog = builder.show();
        return dialog;
    }

    public void openDocument(String pathOfTemplate, String pathOfFile){
        // Switch to doc editor view
        setContentView(R.layout.doc_editor);
        EditText textEditor = findViewById(R.id.textEditor);
        textEditor.setText("get string from template");
    }

    public void onClickSave(View v, String pathToSave){

        // Save document, use pathToSave to save it there

        // Go back to homescreen
        startActivity(new Intent(DocView.this, Main.class));
        setContentView(R.layout.activity_main);
    }
    public void onClickGoBack(View v)
    {

        startActivity(new Intent(DocView.this, Main.class));
        setContentView(R.layout.activity_main);
    }
}