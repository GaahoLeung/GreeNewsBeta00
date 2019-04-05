package cn.edu.cqu.greenewsbeta01;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MessageAdapter extends ArrayAdapter {
    private int resourceId;
    public MessageAdapter(Context context, int textViewResourceId,
                          List<Message> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Message message = (Message) getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, parent,
                false);
        ImageView UserImage = (ImageView) view.findViewById(R.id.message_icon);
        TextView UserName = (TextView) view.findViewById(R.id.message_name);
        UserImage.setImageResource(message.getImageId());
        UserName.setText(message.getName());
        return view;
    }
}
