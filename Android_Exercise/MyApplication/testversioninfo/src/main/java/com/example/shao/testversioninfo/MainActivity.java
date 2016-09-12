package com.example.shao.testversioninfo;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * @ Description: 测试能否获取程序的版本信息
 **/
public class MainActivity extends AppCompatActivity {
    @BindView(R.id.text)
    TextView tv;
    @BindView(R.id.activity_main)
    RelativeLayout layout;
//    private RelativeLayout layout;
//    @BindView(R.id.activity_main) RelativeLayout layout;

    /**
     * @ Description :用于获取版本信息的方法
     **/
    public PackageInfo getPackageInfo() {
        PackageInfo info = null;//定义对象，存放版本信息
        try {
            /**
             @ Description :getPackManager()获取对象的实例,getPackgeInfo()获取版本信息；完成对象实例化
             @ getPackageName():表示获取当前类的包名
             @ 0:表示获取版本的信息
             **/
            info = getPackageManager().getPackageInfo(getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        if (info == null) {
            info = new PackageInfo();
        }
        return info;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//        ButterKnife.bind(this);
        TextView tv = (TextView) findViewById(R.id.text);
        tv.setText(this.getPackageInfo().versionName);
//        layout = (RelativeLayout)findViewById(R.id.activity_main);
        alphaAnimation();
    }

    /**
     * @ Description : 尝试实现渐变动画效果
     **/
    public void alphaAnimation() {
        AlphaAnimation animation = new AlphaAnimation(0, 1);
        animation.setDuration(3000);
        layout.startAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                ToastUtils.showShort(MainActivity.this,"结束啦！！！！！！！！！！！！");
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
