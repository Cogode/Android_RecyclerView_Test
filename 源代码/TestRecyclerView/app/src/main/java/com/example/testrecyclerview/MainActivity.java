package com.example.testrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActionBar;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MessageAdapter adapter;
    private EditText editText;
    private ArrayList<Message> msgList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        editText = findViewById(R.id.editText);
        msgList = new ArrayList<>();
        adapter = new MessageAdapter(msgList);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);

        ActionBar actionBar = getActionBar();
        if(actionBar != null) {
            actionBar.hide();
        }
    }

    /**
     * 用户按下消息发送按钮时发送消息
     */
    public void onSendMessageButtonClick(View view) {
        String content = editText.getText().toString();
        if(content.length() == 0) {
            Toast.makeText(this, "文本内容不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        addSendMessage(content);
        addReceiveMessage("收到“" + content + "“");
    }

    /**
     * 增加发送消息
     */
    public void addSendMessage(String content) {
        Message sendMessage = new Message(content, Message.TYPE_SEND);
        msgList.add(sendMessage);
        adapter.notifyItemInserted(msgList.size() - 1);    // 刷新RecyclerView中的显示
        recyclerView.scrollToPosition(msgList.size() - 1);    // 将RecyclerView定位到最后一行
        editText.setText("");
    }

    /**
     * 增加接收消息
     */
    public void addReceiveMessage(String content) {
        Message receiveMessage = new Message(content, Message.TYPE_RECEIVE);
        msgList.add(receiveMessage);
        adapter.notifyItemInserted(msgList.size() - 1);    // 刷新RecyclerView中的显示
        recyclerView.scrollToPosition(msgList.size() - 1);    // 将RecyclerView定位到最后一行
    }
}