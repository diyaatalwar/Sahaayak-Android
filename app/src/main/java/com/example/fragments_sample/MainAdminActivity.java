package com.example.fragments_sample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class MainAdminActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_admin);


        DrawerLayout dl = findViewById(R.id.drawer_layout);
        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        NavigationView navigationView = findViewById(R.id.nav_admin_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, dl, toolbar, R.string.open_nav, R.string.close_nav);
        dl.addDrawerListener(toggle);
        toggle.syncState();

        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AdminRequestsFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_requests);
        }


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
//            case R.id.nav_adminDashboard:
//                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AdminDashboardFragment()).commit();
//                break;

            case R.id.nav_requests:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AdminRequestsFragment()).commit();
                break;

//            case R.id.nav_bulletinBoard:
//                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AdminJobsFragment()).commit();
//                break;

            case R.id.nav_settings:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AdminSettingsFragment()).commit();
                break;

            case R.id.nav_logout:
                AlertDialog.Builder ad = new AlertDialog.Builder(MainAdminActivity.this);
                ad.setTitle("Logout").setMessage("Are you sure you want to logout?").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        FirebaseAuth auth = FirebaseAuth.getInstance();
                        auth.signOut();
                        startActivity(new Intent(MainAdminActivity.this, LogIn.class));
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
            // do nothing (disabled)
        }
    }

    public void refreshRequests(){
        // refreshing requests fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        AdminRequestsFragment arfragment = new AdminRequestsFragment();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, arfragment);
        fragmentTransaction.commit();
    }

}