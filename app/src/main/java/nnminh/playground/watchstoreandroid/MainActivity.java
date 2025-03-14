package nnminh.playground.watchstoreandroid;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import nnminh.playground.watchstoreandroid.data.model.Category;
import nnminh.playground.watchstoreandroid.data.model.Product;
import nnminh.playground.watchstoreandroid.ui.activities.LoginActivity;
import nnminh.playground.watchstoreandroid.ui.adapters.CategoryAdapter;
import nnminh.playground.watchstoreandroid.ui.adapters.ProductGridAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this); // This code remove the theme applying to the system bar

        setContentView(R.layout.activity_main);

        Button btnToLoginActivity = findViewById(R.id.btnToLoginActivity);
        btnToLoginActivity.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        });

        ImageButton iBtnCart = findViewById(R.id.iBtnCart);
        iBtnCart.setOnClickListener(v -> {
            Toast.makeText(this, "This cart feature is not implemented yet", Toast.LENGTH_SHORT).show();
        });

        RecyclerView categoryListRecyclerView = findViewById(R.id.recyclerViewCategoryList);
        categoryListRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<Category> categories = new ArrayList<>(List.of(
                new Category("Đồng hồ Rolex, Hublot", "dong-ho-rolex-hublot", "https://www.watchstore.vn/images/products/2024/06/26/resized/giong-rolex-hublot_1719393187.webp"),
                new Category("Casio MTP thanh lịch", "casio-mtp-thanh-lich", "https://www.watchstore.vn/images/products/2024/06/18/resized/mtp-vt01l-1budf-1_1718682938.webp"),
                new Category("Tissot sang trọng", "tissot-sang-trong", "https://www.watchstore.vn/images/products/2024/06/26/resized/tissot-prx-locle_1719393187.webp"),
                new Category("Giống Patek, Richard", "giong-patek-richard", "https://www.watchstore.vn/images/products/2024/07/02/resized/giong-patek-richard_1719914542.webp"),
                new Category("G-Shock thể thao", "g-shock-the-thao", "https://www.watchstore.vn/images/products/2024/06/18/resized/ga2100_1718682938.webp"),
                new Category("Màu vàng sang trọng", "mau-vang-sang-trong", "https://www.watchstore.vn/images/products/2024/06/18/resized/sk-mat-lua_1718682782.webp"),
                new Category("Mẫu mới 2025", "mau-moi-2025", "https://www.watchstore.vn/images/products/2024/06/24/resized/mau-nam-moi-2024_1719203006.webp"),
                new Category("Phiên bản giới hạn", "phien-ban-gioi-han", "https://www.watchstore.vn/images/products/2024/07/02/resized/eqb-2000hr-1adr_1719915082.webp")
        ));

        CategoryAdapter categoryAdapter = new CategoryAdapter(this, categories);
        categoryListRecyclerView.setAdapter(categoryAdapter);

        RecyclerView productRecyclerView = findViewById(R.id.recyclerViewProducts);
        productRecyclerView.setLayoutManager(new GridLayoutManager(this, 2)); // 2 columns

        List<Product> productList = new ArrayList<>(List.of(
                new Product("Citizen Nam NJ0151-88M", 120000f, List.of("https://www.watchstore.vn/images/products/2024/resized/nj0151-88m-2-1676685816335-1712493868.webp"), 1210, 4.8f),
                new Product("Bentley Nam BL2333-10MTCI", 79999f, List.of("https://www.watchstore.vn/images/products/2024/resized/bl2333-10mtci-1-1712499759.webp"), 980, 4.5f),
                new Product("Tissot Prx Nam T137.407.11.351.00", 59999f, List.of("https://www.watchstore.vn/images/products/2024/resized/t137-68001089-587059043-1712496419.webp"), 650, 4.3f),
                new Product("Longines Presence Nam L4.921.2.42.7", 3999f, List.of("https://www.watchstore.vn/images/products/2024/resized/l4-1613928640-1890634504-1712490751.webp"), 3120, 4.7f),
                new Product("Citizen Nam NJ0151-88M", 120000f, List.of("https://www.watchstore.vn/images/products/2024/resized/nj0151-88m-2-1676685816335-1712493868.webp"), 1210, 4.8f),
                new Product("Bentley Nam BL2333-10MTCI", 79999f, List.of("https://www.watchstore.vn/images/products/2024/resized/bl2333-10mtci-1-1712499759.webp"), 980, 4.5f),
                new Product("Tissot Prx Nam T137.407.11.351.00", 59999f, List.of("https://www.watchstore.vn/images/products/2024/resized/t137-68001089-587059043-1712496419.webp"), 650, 4.3f),
                new Product("Longines Presence Nam L4.921.2.42.7", 3999f, List.of("https://www.watchstore.vn/images/products/2024/resized/l4-1613928640-1890634504-1712490751.webp"), 3120, 4.7f)
        ));

        ProductGridAdapter productGridAdapter = new ProductGridAdapter(this, productList);
        productRecyclerView.setAdapter(productGridAdapter);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}