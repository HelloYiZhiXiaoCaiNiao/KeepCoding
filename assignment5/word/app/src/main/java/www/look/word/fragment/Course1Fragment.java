package www.look.word.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.youth.banner.Banner;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import cn.jzvd.JzvdStd;
import www.look.word.CourseInfoActivity;
import www.look.word.CourseListActivity;
import www.look.word.MainActivity;
import www.look.word.R;
import www.look.word.adapter.CourseListAdapter;
import www.look.word.adapter.base.CommonAdapter;
import www.look.word.adapter.base.ViewHolder;
import www.look.word.adapter.data.CourseBean;
import www.look.word.adapter.data.CourseType;
import www.look.word.adapter.data.TeacherBean;
import www.look.word.util.FileUtils;
import www.look.word.util.GlideImageLoader;


public class Course1Fragment extends Fragment {
   private Banner banner;

    public Course1Fragment() {
        // Required empty public constructor
    }


    public static Course1Fragment newInstance() {
        Course1Fragment fragment = new Course1Fragment();
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
        View views = inflater.inflate(R.layout.fragment_course1, container, false);
        initView(views);
        return views;
    }


    private void initView(View view) {
        try {
            if (getActivity() instanceof CourseInfoActivity){
                CourseBean courseBean = ((CourseInfoActivity)getActivity()).courseBean;
                TextView tv_title = view.findViewById(R.id.tv_title);
                tv_title.setText(courseBean.getTitle());
                TextView tv_desc = view.findViewById(R.id.tv_desc);
                tv_desc.setText(courseBean.getDesc());

                initGridView(view);
            }
        }catch (Exception e){

        }

    }


    private void initGridView(View view){
        GridView gridView = (GridView)view.findViewById(R.id.gridlist);
        gridView.setAdapter(new CommonAdapter<TeacherBean>(
                gridView.getContext(), TeacherBean.getTeacherDatas(),
                R.layout.item_course_type) {
            @Override
            public void convert(ViewHolder helper, TeacherBean item) {
                ImageView imageView = helper.getView(R.id.iv_show);
                Glide.with(imageView.getContext()).load(item.getImg()).into(imageView);
                helper.setText(R.id.tv_title, item.getName());
            }
        });
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TeacherBean bean = TeacherBean.getTeacherDatas().get(position);
                AlertDialog.Builder builder  = new AlertDialog.Builder(getContext());
                builder.setTitle(bean.getName() ) ;
                builder.setMessage(bean.getDesc() ) ;
                builder.setPositiveButton("确定" ,  null );
                builder.show();
            }
        });
    }
}
