package com.example.shao.news;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.RotateAnimation;
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
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        header = LayoutInflater.from(context).inflate(R.layout.pull_to_refresh,null,true);
        //获取布局文件中的View对象
        arrow = (ImageView) header.findViewById(R.id.arrow);
        progressbar = (ProgressBar) header.findViewById(R.id.progress_bar);
        description = (TextView) header.findViewById(R.id.description);
        update_at = (TextView) header.findViewById(R.id.updated_at);

        touchslop = ViewConfiguration.get(context).getScaledTouchSlop();//获取最大的滑动长度

        refreshUpdateAtValue();//调用刷新的头布局中的内容(主要是时间)的方法

        setOrientation(VERTICAL);//实在布局样式为垂直样式
        addView(header,0);//添加新的布局
    }

    private void refreshUpdateAtValue() {//刷新头布局中的内（刷新时间）的方法
        lastUpdateTime = preferences.getLong(UPDATE_AT + mId,-1);//从上一次刷新存储的数据中获取上次刷新时间
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
            hideHeaderHeight =  -header.getHeight(); //设置本布局的高度为view宽度的负值，将其隐藏
            headerLayoutParams = (MarginLayoutParams) header.getLayoutParams();//获取布局参数
            headerLayoutParams.topMargin = hideHeaderHeight;//?????
            listView = (ListView) getChildAt(1); //获取ViewGroup所看到第一个View为ListView对象
            listView.setOnTouchListener(this);//设置触摸监听器
            loadOnce = true;//设置已经加载为真
        }
    }

    @Override//明确概念，手指下滑———View上拉；手指上滑——View下拉
    public boolean onTouch(View v, MotionEvent event) {
        setIsAbleToPull(event); //调用判断下拉是ListView下拉还是更新框下拉
        if(ableToOull) { //可以下拉更新
            switch (event.getAction()) { //写MotionEvent
                case MotionEvent.ACTION_DOWN: //手指在屏幕按下时的事件
                    yDown = event.getRawY();  //获取当前手指按下位置的Y坐标
                    break;
                case MotionEvent.ACTION_MOVE:  //手指在屏幕上滑动时的事件
                    float yMove = event.getRawY(); //获取滑动时手指在屏幕上的Y坐标
                    int distance = (int) (yMove - yDown); //获取按下时和滑动时的距离差，用于判断手指向上(>0)还是向下滑(<0)

                    if(distance <= 0 && headerLayoutParams.topMargin <= hideHeaderHeight) { //若手指下滑且上拉更新处在隐藏状态，说明View上拉没到头，屏蔽
                        return false;
                    }

                    if(distance < touchslop) { //若手指在最大可移动范围内上滑
                        return false;
                    }
                    //进入可以刷新的事件，通过当前状态判断刷新是松开刷还是显示下拉
                    if(currentStatus != STATUS_REFRESING) { //若不是正在刷新
                        if(headerLayoutParams.topMargin > 0) { //若上拉更新已经出现
                            currentStatus = STATUS_RELEASE_TO_REFRESH;//则释放后进行刷新
                        }else {
                            currentStatus = STATUS_PULL_TO_REFRESH;//否则显示上拉刷新
                        }
                        //改变headerLayoutParams.topMargin显示下拉刷新
                        headerLayoutParams.topMargin = (distance / 2) + hideHeaderHeight;
                        header.setLayoutParams(headerLayoutParams);//重传布局参数
                    }
                    break;

                case MotionEvent.ACTION_UP: //手指离开屏幕时的事件
                    default://调用刷新方法进行刷新操作
                        if(currentStatus == STATUS_RELEASE_TO_REFRESH) { //如果是释放即刷新状态调用刷新方法
                            new RefreshingTask().execute();
                        }else if (currentStatus == STATUS_PULL_TO_REFRESH) { //如果是下拉刷新，则调用隐藏下拉布局的方法
                            new HideHeaderTask().execute();
                        }
                        break;
            }
            //更新下拉头的信息（进度条显示，图片旋转等）
            if(currentStatus == STATUS_PULL_TO_REFRESH || currentStatus == STATUS_RELEASE_TO_REFRESH) {
                updateHeaderView();//调用更新下拉View的方法
                //当下拉出现处于下拉或者释放状态时，ListView要处于丢失焦点的状态
                listView.setPressed(false);
                listView.setFocusable(false);
                listView.setFocusableInTouchMode(false);
                lastStatus = currentStatus;
                return true;
            }

        }
        return false;
    }


    //给下拉刷新注册一个监听器
    public void setOnRefreshListener (PullToRefreshListener listener,int id) {
        mlistener = listener; //监听器的具体实现，在PullToRefreshListener实现
        mId = id;//不同界面下拉刷新要传入不同的id以区分
    }

    public void finishRefreshing() {//调用记录，使得不会一直刷新 ？？？？？
        currentStatus = STATUS_RESH_FINISHED;
        preferences.edit().putLong(UPDATE_AT + mId,SystemClock.currentThreadTimeMillis()).commit();
        new HideHeaderTask().execute();
    }

    private void setIsAbleToPull(MotionEvent event) { //判断下拉事件是否到ListView顶部，区分是下拉ListView还是下拉更新框
        View firstChild = listView.getChildAt(0);
        if (firstChild != null ) { //判断第一个ListView是否为空
            int firstVisiblePos = listView.getFirstVisiblePosition();//获取第一个ListView的所在位置
            if(firstVisiblePos == 0 && firstChild.getTop() == 0){//若ListView第一个元素对象的上沿距离父布局的顶部为0，说明ListView上滑倒头，可以显示更新
                if(!ableToOull) { //获取手指按下的坐标
                    yDown = event.getRawY();
                }
                ableToOull = true; //设置下拉可以
            }else {//ListView未滑到顶部，下拉刷新继续隐藏
                if(headerLayoutParams.topMargin != hideHeaderHeight) { //判断下拉隐藏是否改变改变则重设隐藏
                    headerLayoutParams.topMargin = hideHeaderHeight;
                    header.setLayoutParams(headerLayoutParams);
                }
                ableToOull = false;
            }
        }else {//就算没有加载ListView也允许刷新
            ableToOull = true;
        }
    }

      private void updateHeaderView() { //更新下拉View 的方法
          if(lastStatus != currentStatus) {//根据不同状态设置对View进行不同设置
              switch (currentStatus) {
                  case STATUS_PULL_TO_REFRESH :
                      description.setText("下拉刷新");
                      arrow.setVisibility(VISIBLE);
                      rotateArrow();//调用图片动画效果
                      progressbar.setVisibility(GONE);
                      refreshUpdateAtValue();
                      break;
                  case STATUS_RELEASE_TO_REFRESH :
                      description.setText("释放刷新");
                      arrow.setVisibility(GONE);
                      progressbar.setVisibility(GONE);
                      refreshUpdateAtValue();
                      rotateArrow();
                      break;
                  case STATUS_REFRESING :
                      description.setText("正在刷新");
                      progressbar.setVisibility(VISIBLE);
                      arrow.setVisibility(GONE);
                      arrow.clearAnimation();//清除存在的动画效果
                      refreshUpdateAtValue();
                      break;
                  default:
                      refreshUpdateAtValue();
                      break;
              }
          }

    }

    private void rotateArrow() { //设置图片的翻转动画效果
        float pivotX = arrow.getWidth() / 2f; //获取图片中心点的坐标
        float pivotY = arrow.getHeight() / 2f;

        float fromDegress = 0,toDegress = 0;//设置旋转动画的起始角度，和最终角度
        if (currentStatus == STATUS_PULL_TO_REFRESH) {//根据状态不同设置其实和结束角度
            fromDegress = 180f;
            toDegress = 360f;
        }else if (currentStatus == STATUS_RELEASE_TO_REFRESH) {
            fromDegress = 0f;
            toDegress = 180f;
        }
        RotateAnimation animation = new RotateAnimation(fromDegress,toDegress,pivotX,pivotY);
        animation.setDuration(100); //设置动画持续时间
        animation.setFillAfter(true);//设置动画结束后View对象是否保持当前状态
        arrow.startAnimation(animation);//View对象启用旋转动.画效果
    }


    //正在刷新的任务，会通过监听器进行刷新 ？？？？？？
    private class RefreshingTask extends AsyncTask <Void,Integer,Void> {
        @Override
        protected Void doInBackground(Void... params) {
            int topMargin = headerLayoutParams.topMargin;
            while (true) {
                topMargin = topMargin + SCROLL_SPEED;
                if(topMargin <= 0) {
                    topMargin = 0;
                    break;
                }
                publishProgress(topMargin);
                sleep(10);
            }
            currentStatus = STATUS_REFRESING;
            publishProgress(0);
            if (mlistener != null) {
                mlistener.onRefresh();
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... topMargin) {
            updateHeaderView();//调用更新下拉View内容的方法
            headerLayoutParams.topMargin = topMargin[0];
            header.setLayoutParams(headerLayoutParams);
        }
    }

    //隐藏下拉头任务，当更新完或者没有更新重新隐藏下拉条 ?????
    private class HideHeaderTask extends AsyncTask<Void,Integer,Integer>  {
        @Override
        protected Integer doInBackground(Void... params) {
            int topMargin = headerLayoutParams.topMargin;
            while (true) {
                topMargin = topMargin + SCROLL_SPEED;
                if(topMargin <= hideHeaderHeight) {
                    topMargin = hideHeaderHeight;
                    break;
                }
                publishProgress(topMargin);
                sleep(10);
            }
            return topMargin;
        }

        @Override
        protected void onProgressUpdate(Integer... topMargin) {
            headerLayoutParams.topMargin = topMargin[0];
            header.setLayoutParams(headerLayoutParams);
        }

        @Override
        protected void onPostExecute(Integer topMargin) {
            headerLayoutParams.topMargin = topMargin;
            header.setLayoutParams(headerLayoutParams);
            currentStatus = STATUS_RESH_FINISHED;
        }
    }
    private void sleep (int time) { //知道当前线程睡眠毫秒数
        try {
            Thread.sleep(time);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

 public interface PullToRefreshListener {
         void onRefresh();
    }


}
