package www.look.word.adapter.data;

import java.io.Serializable;

/**
 * Created by L-HOME on 2019/10/14.
 */

public class CourseBean implements Serializable {
    private String id = "";//id
    private String img = "";//图片地址
    private String title = "";//标题
    private String name = "";//发布人
    private String num = "";//观看人数
    private String desc = "";//描述

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
