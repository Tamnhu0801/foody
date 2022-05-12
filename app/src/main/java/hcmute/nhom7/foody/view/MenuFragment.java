package hcmute.nhom7.foody.view;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import hcmute.nhom7.foody.R;
import hcmute.nhom7.foody.adapter.ItemCartAdapter;
import hcmute.nhom7.foody.adapter.ItemMenuAdapter;
import hcmute.nhom7.foody.database.Database;
import hcmute.nhom7.foody.model.MonAn;

public class MenuFragment extends Fragment {

    private RecyclerView recyclerviewMenu;
    private Database db;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);

        db = new Database(getContext());
        List<MonAn> foods = db.getAllFood();

        recyclerviewMenu = view.findViewById(R.id.recyclerviewMenu);
        recyclerviewMenu.setHasFixedSize(true);
        recyclerviewMenu.setLayoutManager(new LinearLayoutManager(getContext()));
        ItemMenuAdapter menuAdapter =  new ItemMenuAdapter(this, foods);
        recyclerviewMenu.setAdapter(menuAdapter);
        return view;
    }

    public void DialogThemMon() {
        View view = getLayoutInflater().inflate(R.layout.dialog_cart, null);
        ImageView imgClose = view.findViewById(R.id.imageClose);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerviewCart);
        Button btnGiaoHang = view.findViewById(R.id.buttonGiaoHang);

        final Dialog dialog = new Dialog(getContext(), R.style.MaterialDialogSheetAnimation);
        dialog.setContentView(view);
        dialog.getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT, 1500);
        dialog.getWindow().setGravity(Gravity.BOTTOM);
        dialog.show();

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        ItemCartAdapter adapter =  new ItemCartAdapter(getContext(), getListMonAn());
        recyclerView.setAdapter(adapter);

        imgClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        btnGiaoHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), CheckoutActivity.class);
                startActivity(intent);
            }
        });
    }

    private List<MonAn> getListMonAn(){
        List<MonAn> list = new ArrayList<MonAn>();
        MonAn monAn1 = new MonAn("snowee", "Tên món ăn", "Mô tả", "Giá");
        MonAn monAn2 = new MonAn("snowee", "Tên món ăn", "Mô tả", "Giá");
        MonAn monAn3 = new MonAn("snowee", "Tên món ăn", "Mô tả", "Giá");

        list.add(monAn1);
        list.add(monAn2);
        list.add(monAn3);

        return list;
    }
}