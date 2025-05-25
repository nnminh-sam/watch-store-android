package nnminh.playground.watchstoreandroid.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import nnminh.playground.watchstoreandroid.R;

public class AuthenticationFragment extends Fragment {

    private Button btnSignIn, btnSignUp;

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState
    ) {
        View view = inflater.inflate(R.layout.fragment_authentication, container, false);

        btnSignIn = view.findViewById(R.id.btn_sign_in);
        btnSignUp = view.findViewById(R.id.btn_sign_up);

        loadChildFragment(new SignInFragment());

        btnSignIn.setOnClickListener(v -> loadChildFragment(new SignInFragment()));
        btnSignUp.setOnClickListener(v -> loadChildFragment(new SignUpFragment()));

        return view;
    }

    private void loadChildFragment(Fragment fragment) {
        requireActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.auth_child_fragment_container, fragment)
                .commit();
    }
}
