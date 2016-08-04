package com.example.shao.news;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by Shao on 2016/8/4.
 */
public class RefreshableView extends LinearLayout implements View.OnTouchListener{
    public static final int STATUS_PULL_TO_REFRESH = 0;//下拉状态
    public static final int STATUS_RELEASE_TO_REFRESH = 1;//释放后的刷新状态
    public static final int STATUS_REFRESING = 2;//正在刷新的状态
    public static final int STATUS_RESH_FINISHED = 3;//没有刷新或者刷新完成的状态
    public static final int SCROLL_SPEED = -20;//下拉头部回滚速度

    public static final long ONE_MINTE = 60 * 1000;//一分钟毫秒值，用于判定更新时间
    public static final long ONE_HOUR = ONE_MINTE * 60;//一小时毫秒值
    public static final long ONE_DAY = ONE_HOUR * 24;//一天毫秒值
    public static final long ONE_MOUTH = 30 * ONE_DAY;//一月毫秒值
    public static final long ONE_YEAR = 12 * ONE_MOUTH;//一年毫秒值

    public static final String UPDATE_AT = "update_at";//上次更新的字符串常量，用作sharedPreferences的键值

    private PullToRefreshListener mlistener;//下拉刷新的回调接口（需要自己定义)
    private SharedPreferences preferences;//存放上次刷新的数据
    private View header;//下拉头的View对象

    //获取pull_to_refresh.xml中的View对象
    private ProgressBar progressbar;
    private ImageView arrow;
    private TextView description;
    private TextView update_at;
    private ListView listView;

    private MarginLayoutParams headerLayoutParams;//获取下拉头的布局参数？？？

    private long lastUpdateTime;//获取上次刷新的时间
    private int mId = -1;//避免不同Activity下拉刷新时间冲突，设置不同的Id
    private int hideHeaderHeight;//下拉头的高度
    private int currentStatus = STATUS_RESH_FINISHED;//当前的刷新状态
    private int lastStatus = currentStatus;//上一次的刷新状态
    private float yDown;//手按下时屏幕的坐标
    private int touchslop;//最大下滑的长度

    private boolean loadOnce;//是否加载过一次，onLayout只加载一次
    private boolean ableToOull; //是否可以下拉，只有ListView滚到头才可以下拉

    //构造方法
    public RefreshableView(Context context, AttributeSet attrs) {
        super(context, attrs);
        //加载布局给下拉头的View对象
        header = LayoutInflater.from(context).inflate(R.layout.pull_to_refresh,null,true);
        //获取布局文件中的View对象
        arrow = (ImageView) header.findViewById(R.id.arrow);
        progressbar = (ProgressBar) header.findViewById(R.id.progressbar);
        description = (TextView) header.findViewById(R.id.description);
        update_at = (TextView) header.findViewById(R.id.updated_at);

        touchslop = ViewConfiguration.get(context).getScaledTouchSlop();//获取最大的滑动长度

        refreshUpdateAtValue();//调用刷新的头布局中的内容(主要是时间)的方法

        setOrientation(VERTICAL);//实在布局样式为垂直样式
        addView(header,0);//添加新的布局
    }

    private void refreshUpdateAtValue() {//刷新头布局中的内（刷新时间）的方法
        lastUpdateTime = preferences.getLong(UPDATE_AT,-1);//从上一次刷新存储的数据中获取上次刷新时间
        long currenTime = SystemClock.currentThreadTimeMillis();//获取当前的标准时间（从1970.1.1算起）
        long passTime = currenTime - lastUpdateTime;//计算更新之间时间差
        String updateAtValue;//存放返回的提示信息
        long timeIntoFormat;//存放规格化后的时间（原来都是毫秒）
        //根据时差的不同，设置不同的返回信息
        if (lastUpdateTime == -1) {
            updateAtValue =  "并没有更新";
        }else if(passTime < 0 ) {
            updateAtValue = "发送错误";
        }else if(passTime < ONE_MINTE) {
            timeIntoFormat = passTime / 1000; //规格化
            updateAtValue = timeIntoFormat + "秒前更新";
        }else if(passTime < ONE_HOUR) {
            timeIntoFormat = passTime/ONE_MINTE;
            updateAtValue = timeIntoFormat + "分前更新";
        }else if(passTime < ONE_DAY) {
            timeIntoFormat = passTime / ONE_HOUR;
            updateAtValue = timeIntoFormat + "小时前更新";
        }else if(passTime < ONE_MINTE) {
            timeIntoFormat = passTime / ONE_HOUR;
            updateAtValue = timeIntoFormat + "天前更新";
        }else {
            timeIntoFormat = passTime / ONE_MINTE;
            updateAtValue = timeIntoFormat + "年前更新";
        }
        update_at.setText(updateAtValue); //将值设置给TextView
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) { //onLayout方法，用来把一个布局放在父布局的指定位置
        super.onLayout(changed, l, t, r, b);
        if(changed && !loadOnce) {
            hideHeaderHeight = - header.getHeight(); //设置本布局的高度为view宽度的负值，将其隐藏
            headerLayoutParams = (MarginLayoutParams) header.getLayoutParams();//获取布局参数
            headerLayoutParams.topMargin = hideHeaderHeight;//?????
            listView = (ListView) getChildAt(1); //获取ViewGroup所看到第一个View为ListView对象
            listView.setOnTouchListener(this);//设置触摸监听器
            loadOnce = true;//设置已经加载为真
        }
    }

    public interface PullToRefreshListener {

    }

}
