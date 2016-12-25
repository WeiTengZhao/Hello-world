

import android.content.Context;
import android.content.Intent;
/**
@ Description:封装的Intent类，用于创建Intent对象进行跳转
@ startActivity:传统的Inttent跳转用法
@ startStringActivity:带数据的Activity跳转
@ 
**/
public class IntentUtils {
	
	
	private static Intent intent;
	
	public static void startActivity(Context context,Class activituclass){
		
		intent = new Intent(context,activituclass);
		context.startActivity(intent);
	}
	
	/**
	@ Description : 带数据传递的Activity跳转,详见笔记 26.
	@ context:当前Activity.java
	@ activityclass: 要跳转到的Activity.class
	@ key:传递参数所用的 键 (参数以 键-值 对的形式进行传递)
	@ value:传递参数所用的 值
	**/public static void startActivityForString(Context context,Class activityclass,String key,String value){
		
		intent = new Intent(context,activityclass);
		intent.putExtra(key, value);
		context.startActivity(intent);
	}

}
