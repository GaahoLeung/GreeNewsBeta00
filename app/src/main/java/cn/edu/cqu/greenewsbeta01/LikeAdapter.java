package cn.edu.cqu.greenewsbeta01;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class LikeAdapter extends ArrayAdapter<Like> {
    private int resourceId;
    public LikeAdapter(Context context, int textViewResourceId,
                       List<Like> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Like like = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, parent,
                false);
        ImageView UserImage = (ImageView) view.findViewById(R.id.like_icon);
        TextView UserName = (TextView) view.findViewById(R.id.like_name);
        UserImage.setImageResource(like.getImageId());
        UserName.setText(like.getName());
        return view;
    }
}
