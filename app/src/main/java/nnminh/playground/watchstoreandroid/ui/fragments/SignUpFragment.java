package nnminh.playground.watchstoreandroid.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import nnminh.playground.watchstoreandroid.R;

public class SignUpFragment extends Fragment {

    private EditText firstNameInput, emailInput, passwordInput, confirmPasswordInput;
    private Button signUpButton;

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState
    ) {
        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);

        firstNameInput = view.findViewById(R.id.editTextFirstName);
        emailInput = view.findViewById(R.id.editTextEmail);
        passwordInput = view.findViewById(R.id.editTextPassword);
        confirmPasswordInput = view.findViewById(R.id.editTextConfirmPassword);
        signUpButton = view.findViewById(R.id.buttonSignUp);

        signUpButton.setOnClickListener(v -> {
            String name = firstNameInput.getText().toString().trim();
            String email = emailInput.getText().toString().trim();
            String password = passwordInput.getText().toString();
            String confirmPassword = confirmPasswordInput.getText().toString();

            if (name.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(getContext(), "Please fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!password.equals(confirmPassword)) {
                Toast.makeText(getContext(), "Passwords do not match", Toast.LENGTH_SHORT).show();
                return;
            }

            // TODO: Add your API call here
            Toast.makeText(getContext(), "Registering...", Toast.LENGTH_SHORT).show();
        });

        return view;
    }
}