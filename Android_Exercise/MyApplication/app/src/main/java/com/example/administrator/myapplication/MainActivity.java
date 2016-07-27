package com.example.administrator.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends BaseActivity {
public final static String EXTRA_MESSAGE = "com.example.administrator.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*this.requestWindowFeature(Window.FEATURE_NO_TITLE);*/
        setContentView(R.layout.activity_main);
        Button button1 =  (Button) findViewById(R.id.button);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,second_Activity.class);
                startActivity(intent);
            }

        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("MainActivity","onRestart");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1 :
                    if(resultCode == RESULT_OK) {
                        String s;
                        s = data.getStringExtra("to_First_Activity");
                        Log.d("Shao",s);
                    }
                    break;
            default:
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu , menu);
        return true;
    }


    /*public void sendMessage(View view) {
        Intent intent = new Intent(this,DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE,message);
        startActivity(intent);
    }*/


    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_menu:
                Toast.makeText(MainActivity.this, "Select Add menu", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_menu :
                Toast.makeText(MainActivity.this,"Select Remove menu", Toast.LENGTH_SHORT).show();
            default:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
