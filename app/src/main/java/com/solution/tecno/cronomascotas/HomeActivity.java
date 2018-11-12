package com.solution.tecno.cronomascotas;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.DragEvent;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Toast;

import com.solution.tecno.cronomascotas.Firebase.MyFirebaseInstanceIdService;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    Context ctx;
    Toolbar toolbar;
    DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ctx = this;
        MyFirebaseInstanceIdService serv = new MyFirebaseInstanceIdService();
        serv.onTokenRefresh2(this);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_menu_white);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        drawer.setDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View view, float v) {

            }

            @Override
            public void onDrawerOpened(@NonNull View view) {
                toolbar.setNavigationIcon(R.drawable.ic_close_drawer);
            }

            @Override
            public void onDrawerClosed(@NonNull View view) {
                toolbar.setNavigationIcon(R.drawable.ic_menu_white);
            }

            @Override
            public void onDrawerStateChanged(int i) {

            }
        });
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(drawer.isDrawerOpen(Gravity.START)){
                    drawer.closeDrawer(Gravity.START);
                    toolbar.setNavigationIcon(R.drawable.ic_menu_white);
                }else{
                    drawer.openDrawer(Gravity.START);
                    toolbar.setNavigationIcon(R.drawable.ic_close_drawer);
                }
            }
        });

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        Fragment fr=HistoryFragment.newInstance();
        fragmentTransaction.replace(R.id.container,fr);
        fragmentTransaction.commit();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        Fragment fr;
        if(R.id.menu_history==id){
            fr=HistoryFragment.newInstance();
            fragmentTransaction.replace(R.id.container,fr);
            fragmentTransaction.commit();
            drawer.closeDrawer(Gravity.START);

        }else{
            fr=NextEventsFragment.newInstance();
            fragmentTransaction.replace(R.id.container,fr);
            fragmentTransaction.commit();
            drawer.closeDrawer(Gravity.START);
        }
        toolbar.setNavigationIcon(R.drawable.ic_menu_white);
        return true;
    }
}
