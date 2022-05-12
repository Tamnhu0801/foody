package hcmute.nhom7.foody.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import hcmute.nhom7.foody.R;
import hcmute.nhom7.foody.model.Comment;
import hcmute.nhom7.foody.model.MonAn;
import hcmute.nhom7.foody.model.Quan;
import hcmute.nhom7.foody.utils.ImageUtils;
import hcmute.nhom7.foody.view.DetailActivity;
import hcmute.nhom7.foody.view.MenuFragment;

public class ItemMenuAdapter extends RecyclerView.Adapter<ItemMenuAdapter.ViewHolder> {
    private List<MonAn> monAnList;
    private MenuFragment context;


    public ItemMenuAdapter(MenuFragment context,List<MonAn> monAns) {
        this.context = context;
        this.monAnList = monAns;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_layout_menu,parent,false);
        ItemMenuAdapter.ViewHolder viewHolder = new ItemMenuAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MonAn monAn = this.monAnList.get(position);

        Bitmap imgBitmap = ImageUtils.decodeImg(monAn.getImage());

        holder.imgMonAn.setImageBitmap(imgBitmap);
        System.out.println("Ten mon an: " + monAn.getTenMonAn());
        holder.txtTenMonAn.setText(monAn.getTenMonAn());
        holder.txtMoTa.setText(monAn.getMoTa());
        holder.txtGia.setText(monAn.getGia() +" VNĐ");
        holder.imgThemMon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.DialogThemMon();
            }
        });

    }


    @Override
    public int getItemCount() {
            return monAnList.size();
    }

//    private void handleRecycleItemClick(RecyclerView recyclerView, View itemView){
//        int itemPosition = recyclerView.getChildLayoutPosition(itemView);
//        MonAn monAn = this.monAnList.get(itemPosition);
//
//        Toast.makeText(this.context, monAn.getTenMonAn(), Toast.LENGTH_SHORT).show();
//    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgMonAn, imgThemMon;
        TextView txtTenMonAn, txtMoTa, txtGia;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgMonAn = itemView.findViewById(R.id.imageMonAn);
            txtTenMonAn = itemView.findViewById(R.id.textTenMonAn);
            txtMoTa = itemView.findViewById(R.id.textMoTa);
            txtGia =itemView.findViewById(R.id.textGia);
            imgThemMon = itemView.findViewById(R.id.imageThemMon);
        }
    }
}
