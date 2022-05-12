package hcmute.nhom7.foody.view;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

import hcmute.nhom7.foody.R;
import hcmute.nhom7.foody.adapter.CustomRecyclerViewAdapter;
import hcmute.nhom7.foody.adapter.ItemCommentAdapter;
import hcmute.nhom7.foody.adapter.ItemMenuAdapter;
import hcmute.nhom7.foody.adapter.ViewPagerAdapterDetail;
import hcmute.nhom7.foody.database.Database;
import hcmute.nhom7.foody.model.Comment;
import hcmute.nhom7.foody.model.MonAn;
import hcmute.nhom7.foody.model.Quan;
import hcmute.nhom7.foody.model.User;
import hcmute.nhom7.foody.utils.ImageUtils;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String LOG_TAG = "AndroidExample";
    private RecyclerView recyclerView, recyclerviewMenu;
    private Database db;
    List<Comment> itemList;
    TextView txtTenQuan, txtTitleToolbar;
    ImageView imgQuan;
    Toolbar toolbar;
    Button btnOrther;
    Quan quan;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        quan = (Quan) getIntent().getParcelableExtra("quanan");

        txtTenQuan = (TextView) findViewById(R.id.textNameQuan);
        imgQuan = (ImageView) findViewById(R.id.imageQuan);
        txtTitleToolbar = (TextView) findViewById(R.id.textTitleToolbar);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        btnOrther = (Button) findViewById(R.id.buttonOrder);

        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        recyclerView = findViewById(R.id.recyclerviewComment);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ItemCommentAdapter adapter =  new ItemCommentAdapter(this, getListComment());
        recyclerView.setAdapter(adapter);

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
        txtTitleToolbar.setText(quan.getName());
        imgQuan.setImageBitmap(imgBitMap);
                if(quan.getType().equals(getString(R.string.Delivery))){
            btnOrther.setVisibility(View.VISIBLE);
            btnOrther.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, OrtherDeliveryActivity.class);
        intent.putExtra("quanan", quan);
        startActivity(intent);
    }

    private List<Comment> getListComment() {
        List<Comment> list = new ArrayList<Comment>();
        Comment comment1 = new Comment("snowee","User", "Title", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.");
        Comment comment2 = new Comment("snowee","User", "Title", "comment comment commet");
        Comment comment3 = new Comment("snowee","User", "Title", "comment comment commet");

        list.add(comment1);
        list.add(comment2);
        list.add(comment3);
        return list;
    }

}
