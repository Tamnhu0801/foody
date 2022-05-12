package hcmute.nhom7.foody.view.home;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.List;

import hcmute.nhom7.foody.R;
import hcmute.nhom7.foody.adapter.CustomRecyclerViewAdapter;
import hcmute.nhom7.foody.adapter.ResultSearchFoodAdapter;
import hcmute.nhom7.foody.database.HomeDAO;
import hcmute.nhom7.foody.model.MonAn;
import hcmute.nhom7.foody.model.Quan;
import hcmute.nhom7.foody.model.User;

public class HomeFragment extends Fragment {

    public static final String LOG_TAG = "AndroidExample";
    private View mView;
    private EditText mEdtSearchText;
    private LinearLayout layoutImageViewSearch;
    private RecyclerView recyclerView;
    private HomeDAO homeDAO;
    private User user;
    private List<Quan> quans;
    private Context context;
    private ListView listView;

    public HomeFragment(HomeDAO homeDAO, User user) {
        this.homeDAO = homeDAO;
        this.user = user;
        this.context = getContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_home, container, false);

        quans = homeDAO.getAllQuan();

        mEdtSearchText = mView.findViewById(R.id.textSearch);
        recyclerView = mView.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerView.setAdapter(new CustomRecyclerViewAdapter(getContext(), quans));


        layoutImageViewSearch = mView.findViewById(R.id.layoutImageViewSearch);
        layoutImageViewSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String keyWord = mEdtSearchText.getText().toString();
                List<MonAn> resultSearch = homeDAO.searchMonAn(keyWord);
                ListView listViewMonAnResult = mView.findViewById(R.id.listViewMonAnResult);
                ResultSearchFoodAdapter adapter = new ResultSearchFoodAdapter(getContext(), R.layout.custom_layout_menu, resultSearch);
                listViewMonAnResult.setAdapter(adapter);
            }
        });

        return mView;
    }
}