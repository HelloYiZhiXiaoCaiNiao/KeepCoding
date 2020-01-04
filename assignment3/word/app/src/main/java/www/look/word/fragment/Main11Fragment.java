package www.look.word.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ycl.tabview.library.TabView;
import com.ycl.tabview.library.TabViewChild;
import com.youth.banner.Banner;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import www.look.word.R;
import www.look.word.adapter.CourseListAdapter;
import www.look.word.adapter.data.CourseBean;
import www.look.word.util.FileUtils;
import www.look.word.util.GlideImageLoader;
import www.look.word.viewpagerlib.bean.PageBean;
import www.look.word.viewpagerlib.view.BannerViewPager;


public class Main11Fragment extends Fragment {


    public Main11Fragment() {
        // Required empty public constructor
    }


    public static Main11Fragment newInstance() {
        Main11Fragment fragment = new Main11Fragment();
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
        View views = inflater.inflate(R.layout.fragment_main11, container, false);
        initView(views);
        return views;
    }


    private void initView(View view) {
        Banner banner = (Banner) view.findViewById(R.id.banner);
        List<String> images = new ArrayList<>();
        images.add("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=1551039200,1108067788&fm=26&gp=0.jpg");
        images.add("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2854956166,1658664264&fm=26&gp=0.jpg");
        banner.setImages(images).setImageLoader(new GlideImageLoader()).start();

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
