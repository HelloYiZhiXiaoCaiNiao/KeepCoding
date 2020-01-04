package www.look.word.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.youth.banner.Banner;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import www.look.word.R;
import www.look.word.adapter.CourseListAdapter;
import www.look.word.adapter.data.CourseBean;
import www.look.word.util.FileUtils;
import www.look.word.util.GlideImageLoader;


public class Main12Fragment extends Fragment {


    public Main12Fragment() {
        // Required empty public constructor
    }


    public static Main12Fragment newInstance() {
        Main12Fragment fragment = new Main12Fragment();
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
        View views = inflater.inflate(R.layout.fragment_main12, container, false);
        initView(views);
        return views;
    }


    private void initView(View view) {
        ListView mListView = (ListView) view.findViewById(R.id.lv_show);
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
