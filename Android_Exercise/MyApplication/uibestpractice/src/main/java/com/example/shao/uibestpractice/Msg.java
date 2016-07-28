package com.example.shao.uibestpractice;

/**
 * Created by Shao on 2016/7/28.
 */
public class Msg {                              //定义消息实体类
    public static final int TYPE_RECEIVED = 0; //定义消息类型，收还是发
    public static final int TYPR_SEND = 1;

    private int type;                           //存放获取消息类型
    private String context;                     //消息内容

    public Msg (int type,String context) {     //构造方法
        this.type = type;
        this.context = context;
    }

    public String getcontext() {               //获取内容
        return context;
    }
    public int getType() {                     //获取类型
        return type;
    }
}
