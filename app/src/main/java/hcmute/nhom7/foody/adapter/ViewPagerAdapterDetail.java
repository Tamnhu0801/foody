package hcmute.nhom7.foody.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import hcmute.nhom7.foody.R;
import hcmute.nhom7.foody.view.CommentFragment;
import hcmute.nhom7.foody.view.MenuFragment;

public class ViewPagerAdapterDetail extends FragmentStateAdapter {


    public ViewPagerAdapterDetail(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new MenuFragment();
            case 1:
                return new CommentFragment();

            default:
                return new MenuFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
