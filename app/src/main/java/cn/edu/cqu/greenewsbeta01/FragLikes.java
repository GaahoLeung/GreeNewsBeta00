package cn.edu.cqu.greenewsbeta01;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class FragLikes extends Fragment {
    private List<Like> likeList = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_likes, container, false);
        initLike();
        LikeAdapter adapter=new LikeAdapter(this.getContext(),R.layout.likes_item,likeList);
        ListView listView = (ListView) view.findViewById(R.id.list_view_like);
        listView.setAdapter(adapter);
        return view;
    }

    private void initLike() {
        for (int i = 0; i < 5; i++){
            likeList.add(new Like("User"+i,R.drawable.profile));
        }
    }

}
