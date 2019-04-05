package cn.edu.cqu.greenewsbeta01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class FavoritoActivity extends AppCompatActivity implements NewsCardAdapter.OnNewsCardListener{
    private NewsCard[] newsCards= {
            new NewsCard("title2", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1554110720209&di=27ee769240c6a846c5afb082c0750535&imgtype=0&src=http%3A%2F%2F5b0988e595225.cdn.sohucs.com%2Fimages%2F20180731%2Fe52bb09d829d401891979c77e49ea438.jpeg"),
            new NewsCard("title3", "https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=1594275097,644146458&fm=55&app=1&f=JPEG?w=121&h=81&s=3CB16A94461339CC7EB194B203009009")};
    private List<NewsCard> newsCardList=new ArrayList<>();
    private NewsCardAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorito);

        initCards();
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recycler_view_favorito);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new NewsCardAdapter(newsCardList,this);
        recyclerView.setAdapter(adapter);
    }
    public void onClickBack(View v){
        Intent intent =new Intent(FavoritoActivity.this,DrawerHomeActivity.class);
        startActivity(intent);
        finish();
    }

    private void initCards() {
        newsCardList.clear();
        for (int i=0;i<newsCards.length;i++){
            newsCardList.add(newsCards[i]);
        }
    }

    @Override
    public void onNewsCardClick(int position) {
        newsCardList.get(position);
        Intent intent=new Intent(this,ArticleActivity.class);
        intent.putExtra("Posted_By",newsCardList.get(position).getTitle());
        startActivity(intent);
    }
}
