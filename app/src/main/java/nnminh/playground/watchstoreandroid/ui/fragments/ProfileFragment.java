package nnminh.playground.watchstoreandroid.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;

import nnminh.playground.watchstoreandroid.R;
import nnminh.playground.watchstoreandroid.ui.activities.DeliveryAddressActivity;
import nnminh.playground.watchstoreandroid.ui.activities.EditProfileActivity;
import nnminh.playground.watchstoreandroid.ui.activities.OrderHistoryActivity;

public class ProfileFragment extends Fragment {

    private ImageView imageAvatar;
    private TextView textFullName, textEmail;
    private Button btnEditProfile, btnDeliveryAddress, btnOrderHistory;

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState
    ) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        imageAvatar = view.findViewById(R.id.image_avatar);
        textFullName = view.findViewById(R.id.text_full_name);
        textEmail = view.findViewById(R.id.text_email);
        btnEditProfile = view.findViewById(R.id.btn_edit_profile);
        btnDeliveryAddress = view.findViewById(R.id.btn_delivery_address);
        btnOrderHistory = view.findViewById(R.id.btn_order_history);

        // Sample user info - Replace with real data
        textFullName.setText("Darlene Robertson");
        textEmail.setText("darlene.robertson@example.com");

        // Load avatar with Glide (replace URL with actual one or use local image)
        Glide.with(this)
                .load("https://i.pravatar.cc/150?img=3")
                .circleCrop()
                .placeholder(R.drawable.ic_android_black_24dp)
                .into(imageAvatar);

        // Navigation
        btnEditProfile.setOnClickListener(v ->
                startActivity(new Intent(getActivity(), EditProfileActivity.class)));

        btnDeliveryAddress.setOnClickListener(v ->
                startActivity(new Intent(getActivity(), DeliveryAddressActivity.class)));

        btnOrderHistory.setOnClickListener(v ->
                startActivity(new Intent(getActivity(), OrderHistoryActivity.class)));

        return view;
    }
}