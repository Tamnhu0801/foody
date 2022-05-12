package hcmute.nhom7.foody.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import hcmute.nhom7.foody.R;
import hcmute.nhom7.foody.model.Comment;
import hcmute.nhom7.foody.model.MonAn;
import hcmute.nhom7.foody.view.DetailActivity;
import hcmute.nhom7.foody.view.MenuFragment;

public class ItemCartAdapter extends RecyclerView.Adapter<ItemCartAdapter.ViewHolder> {
    private List<MonAn> monAnList;
    private Context context;

    public ItemCartAdapter(Context context, List<MonAn> monAns) {
        this.context = context;
        this.monAnList = monAns;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_dialog_cart,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MonAn monAn = this.monAnList.get(position);

        int imageResId = this.getDrawableResIdByName(monAn.getImage());

        holder.imgMonAn.setImageResource(imageResId);
        holder.txtTenMonAn.setText(monAn.getTenMonAn());
        holder.txtGia.setText(monAn.getGia());

    }


    @Override
    public int getItemCount() {
        return monAnList.size();
    }

    private void handleRecycleItemClick(RecyclerView recyclerView, View itemView){
        int itemPosition = recyclerView.getChildLayoutPosition(itemView);
        MonAn monAn = this.monAnList.get(itemPosition);

        Toast.makeText(this.context, monAn.getTenMonAn(), Toast.LENGTH_SHORT).show();
    }

    private int getDrawableResIdByName(String resName) {
        String packageName = context.getPackageName();

        int resId = context.getResources().getIdentifier(resName, "drawable", packageName);
        Log.i(DetailActivity.LOG_TAG, "Res Name: "+resName+"==> Res ID = "+resId);
        return resId;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgMonAn, imgThem, imgGiam;
        TextView txtTenMonAn, txtGia;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgMonAn = itemView.findViewById(R.id.imageMonAnCart);
            txtTenMonAn = itemView.findViewById(R.id.textTenMonAnCart);
            txtGia =itemView.findViewById(R.id.textGiaCart);
            imgThem = itemView.findViewById(R.id.imageThemCart);
            imgGiam = itemView.findViewById(R.id.imageGiamCart);

        }
    }
}

