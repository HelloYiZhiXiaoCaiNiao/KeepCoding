package www.look.word.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

import www.look.word.CourseInfoActivity;
import www.look.word.CourseListActivity;
import www.look.word.MainActivity;
import www.look.word.MyApplication;
import www.look.word.R;
import www.look.word.adapter.base.CommonAdapter;
import www.look.word.adapter.base.ViewHolder;
import www.look.word.adapter.data.CourseBean;


public class CourseListAdapter extends CommonAdapter<CourseBean> {

    public CourseListAdapter(Context context, List<CourseBean> mDatas) {
        super(context, mDatas, R.layout.item_course_list);
    }

    @Override
    public void convert(ViewHolder helper, final CourseBean item) {
        ImageView imageView = helper.getView(R.id.iv_show);
        Glide.with(imageView.getContext()).load(item.getImg()).into(imageView);
        helper.setText(R.id.tv_title, item.getTitle());
        helper.setText(R.id.tv_desc, item.getDesc());
        helper.setText(R.id.tv_name, item.getName());
        helper.setText(R.id.tv_num, item.getNum() + "人观看");
        helper.getView(R.id.rl_show).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), CourseInfoActivity.class);
                intent.putExtra("data", item);
                v.getContext().startActivity(intent);
                for (CourseBean bean : MyApplication.courseBeanList){
                    if (bean.getId().equals(item.getId())){
                        return;
                    }
                }
                MyApplication.courseBeanList.add(item);

            }
        });
    }
}
