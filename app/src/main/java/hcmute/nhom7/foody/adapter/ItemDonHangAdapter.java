package hcmute.nhom7.foody.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import hcmute.nhom7.foody.R;
import hcmute.nhom7.foody.model.MonAn;
import hcmute.nhom7.foody.utils.ImageUtils;
import hcmute.nhom7.foody.view.MenuFragment;

public class ItemDonHangAdapter extends RecyclerView.Adapter<ItemDonHangAdapter.ViewHolder> {
    private List<MonAn> monAnList;
    private Context context;


    public ItemDonHangAdapter(Context context, List<MonAn> monAns) {
        this.context = context;
        this.monAnList = monAns;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_layout_donhang, parent, false);
        ItemDonHangAdapter.ViewHolder viewHolder = new ItemDonHangAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MonAn monAn = this.monAnList.get(position);

        Bitmap imgBitmap = ImageUtils.decodeImg(monAn.getImage());

        holder.imgMonOrther.setImageBitmap(imgBitmap);
        System.out.println("Ten mon an: " + monAn.getTenMonAn());
        holder.txtTenMonOrther.setText(monAn.getTenMonAn());
        holder.txtSoLuongOrther.setText(monAn.getMoTa());
        holder.txtTenMonOrther.setText(monAn.getGia() + " VNĐ");

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
        ImageView imgMonOrther;
        TextView txtTenMonOrther, txtSoLuongOrther, txtTongTien;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgMonOrther = itemView.findViewById(R.id.imageMonOrder);
            txtTenMonOrther= itemView.findViewById(R.id.textTenMonOrder);
            txtSoLuongOrther = itemView.findViewById(R.id.textSoLuongOrder);
            txtTongTien = itemView.findViewById(R.id.textTongTien);
        }
    }
}