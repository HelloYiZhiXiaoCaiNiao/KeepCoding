package www.look.word;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import www.look.word.adapter.CourseListAdapter;
import www.look.word.adapter.data.CourseBean;
import www.look.word.util.FileUtils;

public class CourseListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_list);
        if (getSupportActionBar()!=null){
            getSupportActionBar().hide();
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getIntent().getStringExtra("title"));
        setTitle(getIntent().getStringExtra("title"));

        ListView mListView = (ListView) findViewById(R.id.lv_show);
        String data = FileUtils.getFromAssets(mListView.getContext(),
                "CourseList.txt");
        Type types = new TypeToken<ArrayList<CourseBean>>() {
        }.getType();
        List<CourseBean> beans = new Gson().fromJson(data, types);
        CourseListAdapter adapter = new CourseListAdapter(mListView.getContext(),
                beans);
        mListView.setAdapter(adapter);
    }

}
