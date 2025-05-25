package nnminh.playground.watchstoreandroid.ui.activities;


import android.app.DatePickerDialog;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import nnminh.playground.watchstoreandroid.R;

public class EditProfileActivity extends AppCompatActivity {
    private ImageView imageAvatar;
    private EditText editFirstName, editLastName, editEmail, editPhone, dobEditText;
    private Button btnSaveChanges;
    private Calendar calendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        imageAvatar = findViewById(R.id.image_avatar);
        editFirstName = findViewById(R.id.edit_first_name);
        editLastName = findViewById(R.id.edit_last_name);
        editEmail = findViewById(R.id.edit_email);
        editPhone = findViewById(R.id.edit_phone);
        dobEditText = findViewById(R.id.edit_dob);
        btnSaveChanges = findViewById(R.id.btn_save_changes);

        Glide.with(this)
                .load("https://i.pravatar.cc/150?img=3")
                .circleCrop()
                .placeholder(R.drawable.ic_android_black_24dp)
                .into(imageAvatar);

        editFirstName.setText("Nguyen");
        editLastName.setText("Nhat Minh");
        editEmail.setText("admin@gmail.com");
        editPhone.setText("+84 704098399");

        btnSaveChanges.setOnClickListener(v -> {
            // Get and handle values here...
            Toast.makeText(this, "Profile updated successfully!", Toast.LENGTH_SHORT).show();
            finish();
        });

        dobEditText.setOnClickListener(v -> {
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            new DatePickerDialog(this, (view, y, m, d) -> {
                dobEditText.setText(d + "/" + (m + 1) + "/" + y);
            }, year, month, day).show();
        });

        Spinner genderSpinner = findViewById(R.id.spinner_gender);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.gender_options,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        genderSpinner.setAdapter(adapter);

        ImageButton btnBackToProfile = findViewById(R.id.btn_back_to_profile);
        btnBackToProfile.setOnClickListener(v -> finish());
    }
}
