package hcmute.nhom7.foody.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import hcmute.nhom7.foody.R;
import hcmute.nhom7.foody.adapter.ItemCommentAdapter;
import hcmute.nhom7.foody.model.Comment;
import hcmute.nhom7.foody.model.Quan;

public class CommentFragment extends Fragment {

    private RecyclerView recyclerView;
    List<Comment> itemList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_comment, container, false);
        recyclerView = view.findViewById(R.id.recyclerviewComment);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        ItemCommentAdapter adapter =  new ItemCommentAdapter(getContext(), getListComment());
        recyclerView.setAdapter(adapter);
        return view;
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