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
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import www.look.word.CourseListActivity;
import www.look.word.MyApplication;
import www.look.word.R;
import www.look.word.adapter.base.CommonAdapter;
import www.look.word.adapter.base.ViewHolder;
import www.look.word.adapter.data.CourseType;
import www.look.word.util.FileUtils;


public class Main4Fragment extends Fragment {


    public Main4Fragment() {
        // Required empty public constructor
    }


    public static Main4Fragment newInstance() {
        Main4Fragment fragment = new Main4Fragment();
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
        View views = inflater.inflate(R.layout.fragment_main4, container, false);
        initView(views);
        return views;
    }


    private void initView(View views){
        TextView tv_name = views.findViewById(R.id.tv_name);
        tv_name.setText(MyApplication.name);
    }
}
