package hcmute.nhom7.foody.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.List;

import hcmute.nhom7.foody.R;
import hcmute.nhom7.foody.adapter.CustomRecyclerViewAdapter;
import hcmute.nhom7.foody.adapter.ItemMenuAdapter;
import hcmute.nhom7.foody.adapter.ViewPagerAdapterDetail;
import hcmute.nhom7.foody.database.Database;
import hcmute.nhom7.foody.model.Comment;
import hcmute.nhom7.foody.model.Quan;
import hcmute.nhom7.foody.utils.ImageUtils;

public class OrtherDeliveryActivity extends AppCompatActivity {

    public static final String LOG_TAG = "AndroidExample";
    private RecyclerView recyclerView, recyclerviewMenu;
    private Database db;
    List<Comment> itemList;
    TextView txtTenQuan, txtTitleToolbar;
    ImageView imgQuan;
    LinearLayout layoutMenu;
    private TabLayout tabLayout;
    private ViewPager2 viewPager;
    private ViewPagerAdapterDetail adapterDetail;
    Quan quan;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orther_delivery);

        quan = (Quan) getIntent().getParcelableExtra("quanan");
        txtTenQuan = (TextView) findViewById(R.id.textNameQuan);
        imgQuan = (ImageView) findViewById(R.id.imageQuan);
//        txtTitleToolbar = (TextView) findViewById(R.id.textTitleToolbar);
        tabLayout = (TabLayout) findViewById(R.id.tablayoutDetail);
        viewPager = (ViewPager2) findViewById(R.id.viewpagerDetail);

//        toolbar.setTitle("");
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);

        adapterDetail = new ViewPagerAdapterDetail(this);
        viewPager.setAdapter(adapterDetail);

        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            switch (position){
                case 0:
                    tab.setText("Đặt đơn");
                    break;
                case 1:
                    tab.setText("Bình luận");
                    break;
            }
        }).attach();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();

        Bitmap imgBitMap = ImageUtils.decodeImg(quan.getImage());

        txtTenQuan.setText(quan.getName());
        imgQuan.setImageBitmap(imgBitMap);
    }

}