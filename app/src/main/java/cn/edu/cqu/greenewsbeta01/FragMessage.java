package cn.edu.cqu.greenewsbeta01;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class FragMessage extends Fragment {
    private List<Message> messageList = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_message, container, false);
        initMessage();
        MessageAdapter adapter=new MessageAdapter(this.getContext(),R.layout.message_item,messageList);
        ListView listView = (ListView) view.findViewById(R.id.list_view_message);
        listView.setAdapter(adapter);
        return view;
    }

    private void initMessage() {
        for (int i = 0; i < 3; i++){
            messageList.add(new Message("User"+(i+1),R.drawable.post));
        }
    }
}
