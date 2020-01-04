package www.look.word;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ycl.tabview.library.TabView;
import com.ycl.tabview.library.TabViewChild;

import java.util.ArrayList;
import java.util.List;

import www.look.word.adapter.data.CourseBean;
import www.look.word.fragment.Main1Fragment;
import www.look.word.fragment.Main2Fragment;
import www.look.word.fragment.Main3Fragment;
import www.look.word.fragment.Main4Fragment;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar()!=null){
            getSupportActionBar().hide();
        }
        TabView view = (TabView) findViewById(R.id.tabView);
        List<TabViewChild> tabViewChildList=new ArrayList<>();
        TabViewChild tabViewChild01=new TabViewChild(R.mipmap.ic_main11,R.mipmap.ic_main1,"首页", Main1Fragment.newInstance());
        TabViewChild tabViewChild02=new TabViewChild(R.mipmap.ic_main22,R.mipmap.ic_main2,"课程",  Main2Fragment.newInstance());
        TabViewChild tabViewChild03=new TabViewChild(R.mipmap.ic_main33,R.mipmap.ic_main3,"我的学习",  Main3Fragment.newInstance());
        TabViewChild tabViewChild04=new TabViewChild(R.mipmap.ic_main44,R.mipmap.ic_main4,"个人中心",  Main4Fragment.newInstance());
        tabViewChildList.add(tabViewChild01);
        tabViewChildList.add(tabViewChild02);
        tabViewChildList.add(tabViewChild03);
        tabViewChildList.add(tabViewChild04);
        view.setTabViewChild(tabViewChildList,getSupportFragmentManager());
    }
}
