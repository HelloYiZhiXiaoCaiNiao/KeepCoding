package www.look.word;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import cn.jzvd.Jzvd;
import cn.jzvd.JzvdStd;
import www.look.word.adapter.ViewPagerAdapter;
import www.look.word.adapter.data.CourseBean;
import www.look.word.fragment.Course1Fragment;
import www.look.word.fragment.Course2Fragment;
import www.look.word.viewpagerlib.indicator.TabIndicator;

public class CourseInfoActivity extends AppCompatActivity {
    public JzvdStd myJzvdStd;
    public CourseBean courseBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_info);

        courseBean = (CourseBean) getIntent().getSerializableExtra("data");
        if (courseBean == null) {
            finish();
        }
        setTitle(courseBean.getTitle());

        myJzvdStd = (JzvdStd) findViewById(R.id.videoplayer);
        myJzvdStd.setUp("http://video.699pic.com/videos/83/90/31/j1xTBUDAMMmY1529839031_10s.mp4"
                , "快闪节奏动画文字竖版微信抖音朋友圈小视频", JzvdStd.SCREEN_WINDOW_NORMAL);
        myJzvdStd.startVideo();

        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(Course1Fragment.newInstance());
        fragmentList.add(Course2Fragment.newInstance());
        List<String> mTitle = new ArrayList<>();
        mTitle.add("课程介绍");
        mTitle.add("课程大纲");
        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), fragmentList, mTitle));
/**
 * 把 TabIndicator 跟viewpager关联起来
 */
        TabIndicator tabIndecator = (TabIndicator) findViewById(R.id.line_indicator);
//设置viewpager滑动速度
        tabIndecator.setViewPagerSwitchSpeed(viewPager, 600);
        tabIndecator.setTabData(viewPager, mTitle, new TabIndicator.TabClickListener() {
            @Override
            public void onClick(int position) {
                //顶部点击的方法公布出来
                viewPager.setCurrentItem(position);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        Jzvd.releaseAllVideos();
    }

    @Override
    public void onBackPressed() {
        if (Jzvd.backPress()) {
            return;
        }
        super.onBackPressed();
    }

}
