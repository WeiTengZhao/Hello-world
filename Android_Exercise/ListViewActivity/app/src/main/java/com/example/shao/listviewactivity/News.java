package com.example.shao.listviewactivity;

/**
 * Created by Shao on 2016/7/25.
 */
public class News {
    private String title;
    private String context;
    private int imageid;

    public News(String title,String context,int imageid) {
        this.title = title;
        this.context = context;
        this.imageid = imageid;
    }

    public String getTitle() {
        return(title);
    }
    public String getContext() {
        return (context);
    }
    public int getImageid() {
        return (imageid);
    }
}
