package www.look.word.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import cn.jzvd.JzvdStd;
import www.look.word.CourseInfoActivity;
import www.look.word.R;


public class Course2Fragment extends Fragment {


    public Course2Fragment() {
        // Required empty public constructor
    }


    public static Course2Fragment newInstance() {
        Course2Fragment fragment = new Course2Fragment();
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
        View views = inflater.inflate(R.layout.fragment_course2, container, false);
        initView(views);
        return views;
    }


    private void initView(View view) {

        ListView mListView = (ListView) view.findViewById(R.id.lv_show);
        final List<String> listTitle = new ArrayList<>();
        listTitle.add("快闪节奏动画文字竖版微信抖音朋友圈小视频");
        listTitle.add("震撼大气黄金黑金风格邀请函小视频");
        listTitle.add("互联网商务邀请函展示小视频");
        listTitle.add("武侠古风企业招聘介绍展示小视频");
        listTitle.add("大气粒子光效邀请函小视频展示");
        final List<String> listUrl = new ArrayList<>();
        listUrl.add("http://video.699pic.com/videos/83/90/31/j1xTBUDAMMmY1529839031_10s.mp4");
        listUrl.add("http://video.699pic.com/videos/99/10/13/J3SWs5Qx4rUk1529991013_10s.mp4");
        listUrl.add("http://video.699pic.com/videos/63/34/22/iPFuMyvnISKE1530633422_10s.mp4");
        listUrl.add("http://video.699pic.com/videos/26/76/11/ThwF4DPkpEyg1530267611_10s.mp4");
        listUrl.add("http://video.699pic.com/videos/35/31/20/4PCp6uDGa6cJ1530353120_10s.mp4");
        ///第二种方法
        ArrayAdapter adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, listTitle);
        //最后一个参数是List或String[]均可
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                if (getActivity() instanceof CourseInfoActivity){
                    ((CourseInfoActivity)getActivity()).myJzvdStd.setUp(listUrl.get(position)
                            , listTitle.get(position), JzvdStd.SCREEN_WINDOW_NORMAL);
                    ((CourseInfoActivity)getActivity()).myJzvdStd.startVideo();
                }
            }
        });
    }

}
