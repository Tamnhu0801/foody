package hcmute.nhom7.foody.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import hcmute.nhom7.foody.R;
import hcmute.nhom7.foody.adapter.ItemDonHangAdapter;
import hcmute.nhom7.foody.adapter.ItemMenuAdapter;
import hcmute.nhom7.foody.database.Database;
import hcmute.nhom7.foody.model.MonAn;

public class CheckoutActivity extends AppCompatActivity {

    private RecyclerView recyclerview;
    private Toolbar toolbar;
    private TextView txtTitleToolbar;
    private Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        db = new Database(this);
        List<MonAn> foods = db.getAllFood();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        recyclerview = findViewById(R.id.recyclerViewDonHang);
        txtTitleToolbar = (TextView) findViewById(R.id.textTitleToolbar);

        recyclerview.setHasFixedSize(true);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        ItemDonHangAdapter menuAdapter =  new ItemDonHangAdapter(this, foods);
        recyclerview.setAdapter(menuAdapter);

        toolbar.setTitle("");
        txtTitleToolbar.setText("Xác nhận đơn hàng");
        setSupportActionBar(toolbar);
        toolbar.setBackgroundColor(getResources().getColor(R.color.white));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}