package nnminh.playground.watchstoreandroid;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import nnminh.playground.watchstoreandroid.ui.fragments.HomeFragment;
import nnminh.playground.watchstoreandroid.ui.fragments.AuthenticationFragment;
import nnminh.playground.watchstoreandroid.ui.fragments.ProfileFragment;
import nnminh.playground.watchstoreandroid.utils.TokenManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);

        loadFragment(new HomeFragment());

        bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment selectedFragment;

            if (item.getItemId() == R.id.nav_profile) {
                TokenManager tokenManager = new TokenManager(this);

                if (tokenManager.isUserLoggedIn()) {
                    selectedFragment = new ProfileFragment();
                } else {
                    selectedFragment = new AuthenticationFragment();
                }

            } else {
                selectedFragment = new HomeFragment();
            }

            return loadFragment(selectedFragment);
        });
    }

    private boolean loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
        return true;
    }
}