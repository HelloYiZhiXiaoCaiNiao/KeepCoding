package www.look.word.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import www.look.word.CourseListActivity;
import www.look.word.MainActivity;
import www.look.word.MyApplication;
import www.look.word.R;
import www.look.word.adapter.CourseListAdapter;
import www.look.word.adapter.base.CommonAdapter;
import www.look.word.adapter.base.ViewHolder;
import www.look.word.adapter.data.CourseBean;
import www.look.word.adapter.data.CourseType;
import www.look.word.util.FileUtils;


public class Main3Fragment extends Fragment {
    private View views;

    public Main3Fragment() {
        // Required empty public constructor
    }


    public static Main3Fragment newInstance() {
        Main3Fragment fragment = new Main3Fragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        views = inflater.inflate(R.layout.fragment_main3, container, false);
        initView(views);
        return views;
    }


    private void initView(View views) {
        ListView mListView = (ListView) views.findViewById(R.id.lv_show);
        CourseListAdapter adapter = new CourseListAdapter(mListView.getContext(),
                MyApplication.courseBeanList);
        mListView.setAdapter(adapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (views != null) {
            initView(views);
        }
    }
}
