package io.github.awwshoot.betternotesapp;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;

import android.view.View;

import io.github.awwshoot.betternotesapp.folders.Folders;
import io.github.awwshoot.betternotesapp.databinding.ActivityMainBinding;

import android.widget.EditText;

import java.io.File;
import java.io.IOException;

public class Main extends AppCompatActivity {


    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Handle user preferences for theme
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);
        // Get rid of bottom annoying button thing
        /*binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        // Instantiate files and folders needed


        try {
            Folders folderManager = new Folders(this.getApplicationContext());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void onClickViewDoc(View v)
    {
        // Get Document Name
        EditText docName = (EditText) findViewById(R.id.txtDocName);

        String name = String.valueOf(docName.getText());

        Intent intent = new Intent(Main.this, DocView.class);
        intent.putExtra("message", name);
        startActivity(intent);
        //setContentView(R.layout.activity_doc_view);
    }

}