package www.look.word;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import www.look.word.adapter.data.CourseBean;

/**
 * Created by L-HOME on 2019/10/14.
 */

public class MyApplication extends Application {
    public static List<CourseBean> courseBeanList = new ArrayList<>();
    public static String name = "";

    @Override
    public void onCreate() {
        super.onCreate();
        courseBeanList = new ArrayList<>();
    }
}
