package www.look.word.adapter.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by L-HOME on 2019/10/14.
 */

public class TeacherBean {
    private String name = "";
    private String img = "";
    private String desc = "";

    public static List<TeacherBean> getTeacherDatas(){
        List<TeacherBean> beans = new ArrayList<>();
        beans.add(new TeacherBean("张三","http://img1.imgtn.bdimg.com/it/u=3001547341,2767869736&fm=26&gp=0.jpg",
                "老师，您是辛勤的园丁，把祖国的花朵培养成人；您是春雨。滋润祖国的花朵；您是一盏明灯，照亮我前进的道路；您是纯蚕，默默无闻做贡献。感谢您，赞美您，老师。"));
        beans.add(new TeacherBean("李四","http://img3.imgtn.bdimg.com/it/u=509762600,106383583&fm=26&gp=0.jpg",
                "老师，您是世界上最勤劳的园丁，每天我们到学校的时候，您却早在办公室里伏案工作了。每天放学时，我们回到家里时，您却还在学校里批改作业……"));
        beans.add(new TeacherBean("王五","http://img2.imgtn.bdimg.com/it/u=2956350201,1077626003&fm=15&gp=0.jpg",
                "老师，您是美的耕耘者，美的播种者。是您用美的阳光普照，用美的雨露滋润，我们的心田才绿草如茵，繁花似锦！"));
        return beans;
    }

    public TeacherBean(String name, String img, String desc) {
        this.name = name;
        this.img = img;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
