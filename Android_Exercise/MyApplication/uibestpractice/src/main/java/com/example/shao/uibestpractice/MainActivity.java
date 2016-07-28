package com.example.shao.uibestpractice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private EditText editText;
    private Button button;
    private MsgAdapter adapter;
    List<Msg> msgList = new ArrayList<Msg>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniMsg();
        adapter = new MsgAdapter(MainActivity.this,R.layout.msg_item,msgList);
        listView = (ListView) findViewById(R.id.msg_list_view);
        editText = (EditText) findViewById(R.id.input_text);
        button = (Button) findViewById(R.id.send);
        listView.setAdapter(adapter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = editText.getText().toString();
                if(! "".equals(input)) {
                    Msg msg = new Msg(Msg.TYPR_SEND,input);
                    msgList.add(msg);
                    adapter.notifyDataSetChanged();
                    listView.setSelection(msgList.size());
                    editText.setText(" ");
                }
            }
        });
    }

    private void iniMsg() {
        Msg msg1 = new Msg(Msg.TYPE_RECEIVED,"Hello Guy!");
        msgList.add(msg1);
        Msg msg2 = new Msg(Msg.TYPR_SEND,"OK");
        msgList.add(msg2);
        Msg msg3 = new Msg(Msg.TYPE_RECEIVED,"???");
        msgList.add(msg3);
        Msg msg4 = new Msg(Msg.TYPE_RECEIVED,"???");
        msgList.add(msg4);
    }
}
