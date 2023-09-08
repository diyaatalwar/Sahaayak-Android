package com.example.fragments_sample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DrawerLayout dl = findViewById(R.id.drawer_layout);
        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, dl, toolbar, R.string.open_nav, R.string.close_nav);
        dl.addDrawerListener(toggle);
        toggle.syncState();

        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new UserDashboardFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_userDashboard);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.nav_userDashboard:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new UserDashboardFragment()).commit();
                break;

            case R.id.nav_badges:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new BadgesFragment()).commit();
                break;

            case R.id.nav_resources:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ResourcesFragment()).commit();
                break;

            case R.id.nav_bulletinBoard:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new BulletinBoardFragment()).commit();
                break;

            case R.id.nav_mentalHealth:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MentalHealthFragment()).commit();
                break;

            case R.id.nav_settings:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new SettingsFragment()).commit();
                break;

            case R.id.nav_logout:
                AlertDialog.Builder ad = new AlertDialog.Builder(MainActivity.this);
                ad.setTitle("Logout").setMessage("Are you sure you want to logout?").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        FirebaseAuth auth = FirebaseAuth.getInstance();
                        auth.signOut();
                        startActivity(new Intent(MainActivity.this, LogIn.class));
                        finish();
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

                AlertDialog alertDialog = ad.create();
                alertDialog.show();
                break;
        }

        DrawerLayout dl = findViewById(R.id.drawer_layout);
        dl.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout dl = findViewById(R.id.drawer_layout);
        if(dl.isDrawerOpen(GravityCompat.START)){
            dl.closeDrawer(GravityCompat.START);
        } else {
            // nothing to disable
        }
    }
}