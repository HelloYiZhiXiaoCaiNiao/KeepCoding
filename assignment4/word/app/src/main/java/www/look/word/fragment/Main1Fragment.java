package www.look.word.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ycl.tabview.library.TabView;
import com.ycl.tabview.library.TabViewChild;

import java.util.ArrayList;
import java.util.List;

import www.look.word.R;
import www.look.word.adapter.ViewPagerAdapter;
import www.look.word.viewpagerlib.indicator.TabIndicator;


public class Main1Fragment extends Fragment {


    public Main1Fragment() {
        // Required empty public constructor
    }


    public static Main1Fragment newInstance() {
        Main1Fragment fragment = new Main1Fragment();
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
        View views = inflater.inflate(R.layout.fragment_main1, container, false);

        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add( Main11Fragment.newInstance());
        fragmentList.add( Main12Fragment.newInstance());
        List<String> mTitle = new ArrayList<>();
        mTitle.add("发现课程");
        mTitle.add("日程安排");
       final ViewPager viewPager = (ViewPager) views.findViewById(R.id.viewpager);
        viewPager.setAdapter(new ViewPagerAdapter(getChildFragmentManager(),fragmentList,mTitle));
/**
 * 把 TabIndicator 跟viewpager关联起来
 */
        TabIndicator tabIndecator = (TabIndicator) views.findViewById(R.id.line_indicator);
//设置viewpager滑动速度
        tabIndecator.setViewPagerSwitchSpeed(viewPager,600);
        tabIndecator.setTabData(viewPager,mTitle, new TabIndicator.TabClickListener() {
            @Override
            public void onClick(int position) {
                //顶部点击的方法公布出来
                viewPager.setCurrentItem(position);
            }
        });
        return views;
    }


}
