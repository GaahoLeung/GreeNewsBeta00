package cn.edu.cqu.greenewsbeta01;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;


public class NewsCardAdapter extends RecyclerView.Adapter<NewsCardAdapter.ViewHolder> {

    private Context mContext;
    private List<NewsCard> mNewsCardList;
    private OnNewsCardListener mOnNewsCardListener;

    public NewsCardAdapter(List<NewsCard> newsCardList,OnNewsCardListener onNewsCardListener){
        mNewsCardList=newsCardList;
        this.mOnNewsCardListener=onNewsCardListener;
    }
    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        CardView cardView;
        ImageView newsImage;
        TextView newsTitle;
        OnNewsCardListener onNewsCardListener;
        public ViewHolder(View view,OnNewsCardListener onNewsCardListener){
            super(view);
            cardView=(CardView) view;
            newsImage=(ImageView) view.findViewById(R.id.news_image);
            newsTitle=(TextView) view.findViewById(R.id.news_title);
            this.onNewsCardListener=onNewsCardListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onNewsCardListener.onNewsCardClick(getAdapterPosition());
        }
}

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup Parent, int viewType) {
        if(mContext==null){
            mContext=Parent.getContext();
        }
        View view= LayoutInflater.from(Parent.getContext()).inflate(R.layout.news_card_item,Parent,false);
        //设置点击事件
        final ViewHolder holder = new ViewHolder(view,mOnNewsCardListener);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NewsCard newsCard=mNewsCardList.get(holder.getAdapterPosition());//获取列表位置信息

                ArticleActivity.actionStart(mContext,newsCard.getTitle());

            }
        });
        return new ViewHolder(view,mOnNewsCardListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        NewsCard newsCard=mNewsCardList.get(position);
        viewHolder.newsTitle.setText(newsCard.getTitle());
        Glide.with(mContext).load(newsCard.imagePath()).into(viewHolder.newsImage);
    }

    @Override
    public int getItemCount() {
        return mNewsCardList.size();
    }

    public interface OnNewsCardListener{
        void onNewsCardClick(int position);
        }

}
