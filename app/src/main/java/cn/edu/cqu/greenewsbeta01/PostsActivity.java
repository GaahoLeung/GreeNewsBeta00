package cn.edu.cqu.greenewsbeta01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class PostsActivity extends AppCompatActivity {
    private String[] data = { "Post0", "Post1", "Post2", "Post3", "Post4", "Post5", "Post6", "Post7", "Post8", "Post9", "Post10", "Post11",
            "Post12", "Post13", "Post14", "Post15", "Post16", };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, data);
        ListView listView = (ListView) findViewById(R.id.list_post);
        listView.setAdapter(adapter);
    }
    public void onClickBack(View v){
        Intent intent =new Intent(PostsActivity.this,DrawerHomeActivity.class);
        startActivity(intent);
        finish();
    }
}
