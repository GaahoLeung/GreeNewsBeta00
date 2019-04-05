package cn.edu.cqu.greenewsbeta01;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class DrawerHomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,NewsCardAdapter.OnNewsCardListener {
    private static final String TAG ="DrawerHomeActivity" ;
    private NewsCard[] newsCards={new NewsCard("title1","https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1554100543&di=72231ea5f7b09cdd1a36f6cfb6538e67&src=http://img.zcool.cn/community/01883359901279a8012156033797f5.jpg@1280w_1l_2o_100sh.jpg"),
            new NewsCard("title2","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1554110720209&di=27ee769240c6a846c5afb082c0750535&imgtype=0&src=http%3A%2F%2F5b0988e595225.cdn.sohucs.com%2Fimages%2F20180731%2Fe52bb09d829d401891979c77e49ea438.jpeg"),
            new NewsCard("title3","https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=1594275097,644146458&fm=55&app=1&f=JPEG?w=121&h=81&s=3CB16A94461339CC7EB194B203009009"),
            new NewsCard("title4","http://t11.baidu.com/it/u=1564756654,315971898&fm=173&app=25&f=JPEG?w=553&h=287&s=009A783211986DCA44C8D0C20100A0B3"),
            new NewsCard("title5","https://gss2.bdstatic.com/9fo3dSag_xI4khGkpoWK1HF6hhy/baike/s%3D220/sign=47bcdef23a01213fcb3349de64e636f8/cdbf6c81800a19d876926e2e30fa828ba61e460c.jpg")};
    private List<NewsCard> newsCardList=new ArrayList<>();
    private NewsCardAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //RecyclerView相关
        initCards();
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new NewsCardAdapter(newsCardList,this);
        recyclerView.setAdapter(adapter);

        //侧滑菜单相关
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }


    private void initCards() {
        newsCardList.clear();
        for (int i=0;i<newsCards.length;i++){
            newsCardList.add(newsCards[i]);
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.drawer_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_profile) {
            // switch to profile
            Intent intent =new Intent(DrawerHomeActivity.this, ProfileActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_favorito) {
            Intent intent =new Intent(DrawerHomeActivity.this, FavoritoActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_posts) {

            Intent intent =new Intent(DrawerHomeActivity.this, PostsActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_settings) {

            Intent intent =new Intent(DrawerHomeActivity.this, SettingActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_helpCenter) {

            Intent intent =new Intent(DrawerHomeActivity.this, HelpCenterActivity.class);
            startActivity(intent);

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onNewsCardClick(int position) {

        newsCardList.get(position);
        Intent intent=new Intent(this,ArticleActivity.class);
        intent.putExtra("Posted_By",newsCardList.get(position).getTitle());
        startActivity(intent);
    }


}
