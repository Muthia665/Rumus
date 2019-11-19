package com.example.user.rumus;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.user.rumus.fragment.AboutFragment;
import com.example.user.rumus.fragment.FormulaFragment;
import com.example.user.rumus.fragment.HomeFragment;

public class MainActivity extends AppCompatActivity {

    // Don't give up :)
    // you can if you think you can

    BottomNavigationView bottomNavigationView;
    Fragment fragment;
    FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.inflateMenu(R.menu.bottom_navigations_item);

        fragmentManager = getSupportFragmentManager();

        fragmentManager.beginTransaction().replace(R.id.main_container, new HomeFragment()).commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();

                switch (id){
                    case R.id.menu_home:
                        fragment = new HomeFragment();
                        break;
                    case R.id.menu_about:
                        fragment = new AboutFragment();
                        break;
                    case R.id.menu_formula:
                        fragment = new FormulaFragment();
                        break;
                }

                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.main_container, fragment).commit();
                return true;
            }
        });


    }
}
