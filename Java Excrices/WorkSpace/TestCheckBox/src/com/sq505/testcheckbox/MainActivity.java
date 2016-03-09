package com.sq505.testcheckbox;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;


public class MainActivity extends ActionBarActivity {
	CheckBox checkbox1 ;
	CheckBox checkbox2 ;
	CheckBox checkbox3 ;
	CheckBox checkbox4 ;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkbox1 = (CheckBox)findViewById(R.id.CheckBox1);
        checkbox2 = (CheckBox)findViewById(R.id.CheckBox2);
        checkbox3 = (CheckBox)findViewById(R.id.CheckBox3);
        checkbox4 = (CheckBox)findViewById(R.id.CheckBox4);
        CheckBoxListener checkboxlistener = new CheckBoxListener();
        checkbox4.setOnCheckedChangeListener(checkboxlistener);
       // checkbox3.setOnCheckedChangeListener(checkboxlistener);
        //checkbox2.setOnCheckedChangeListener(checkboxlistener);
        //checkbox1.setOnCheckedChangeListener(checkboxlistener);
	}
	class CheckBoxListener implements OnCheckedChangeListener{
		public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
			if(checkbox4.isChecked() || ( checkbox1.isChecked()&checkbox2.isChecked()&checkbox3.isChecked() ) ){
				checkbox1.setChecked(true);
				checkbox3.setChecked(true);
				checkbox2.setChecked(true);
				if((checkbox4.isChecked() == false)){
						checkbox1.setChecked(false);
						checkbox3.setChecked(false);
						checkbox2.setChecked(false);				
				}
			}// 2/3选中时全选自动取消，3/3选中时自动全选未实现
		}
	}
	
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
