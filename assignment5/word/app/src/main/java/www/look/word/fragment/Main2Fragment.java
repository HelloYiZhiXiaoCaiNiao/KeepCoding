package www.look.word.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import www.look.word.CourseListActivity;
import www.look.word.R;
import www.look.word.adapter.ViewPagerAdapter;
import www.look.word.adapter.base.CommonAdapter;
import www.look.word.adapter.base.ViewHolder;
import www.look.word.adapter.data.CourseBean;
import www.look.word.adapter.data.CourseType;
import www.look.word.util.FileUtils;
import www.look.word.viewpagerlib.indicator.TabIndicator;


public class Main2Fragment extends Fragment {


    public Main2Fragment() {
        // Required empty public constructor
    }


    public static Main2Fragment newInstance() {
        Main2Fragment fragment = new Main2Fragment();
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
        View views = inflater.inflate(R.layout.fragment_main2, container, false);
        initView(views);
        return views;
    }


    private void initView(View views){
        GridView gridView = (GridView)views.findViewById(R.id.gridlist);
        String data = FileUtils.getFromAssets(gridView.getContext(),
                "CourseType.txt");
        Type types = new TypeToken<ArrayList<CourseType>>() {
        }.getType();
        final List<CourseType> beans = new Gson().fromJson(data, types);
        gridView.setAdapter(new CommonAdapter<CourseType>(
                gridView.getContext(), beans,
                R.layout.item_course_type) {
            @Override
            public void convert(ViewHolder helper, CourseType item) {
                ImageView imageView = helper.getView(R.id.iv_show);
                Glide.with(imageView.getContext()).load(item.getImg()).into(imageView);
                helper.setText(R.id.tv_title, item.getTitle());
            }
        });
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(),CourseListActivity.class);
                intent.putExtra("title",beans.get(position).getTitle());
                startActivity(intent);
            }
        });
    }
}
