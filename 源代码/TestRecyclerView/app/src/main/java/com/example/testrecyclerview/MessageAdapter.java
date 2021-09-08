package com.example.testrecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * RecyclerView的适配器类
 */

public class MessageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final List<Message> msgList;    // 消息列表

    public static class LeftViewHolder extends RecyclerView.ViewHolder {
        private final TextView leftMsg;

        public LeftViewHolder(View view) {
            super(view);
            leftMsg = view.findViewById(R.id.leftMsg);
        }

        public TextView getLeftMsg() {
            return leftMsg;
        }
    }

    public static class RightViewHolder extends RecyclerView.ViewHolder {
        private final TextView rightMsg;

        public RightViewHolder(View view) {
            super(view);
            rightMsg = view.findViewById(R.id.rightMsg);
        }

        public TextView getRightMsg() {
            return rightMsg;
        }
    }

    public MessageAdapter(List<Message> msgList) {
        this.msgList = msgList;
    }

    @Override
    public int getItemViewType(int position) {
        Message msg = msgList.get(position);
        return msg.getType();
    }

    /**
     * 加载不同的布局
     */
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType == Message.TYPE_RECEIVE) {
            // 用户接收消息
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.msg_left_item, parent, false);
            return new LeftViewHolder(view);
        }
        else {
            // 用户发送消息
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.msg_right_item, parent, false);
            return new RightViewHolder(view);
        }
    }

    /**
     * 将ViewHolder与数据相关联
     */
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Message msg = msgList.get(position);

        if(msg.getType() == Message.TYPE_RECEIVE) {
            // 用户接收消息
            ((LeftViewHolder)holder).getLeftMsg().setText(msg.getContent());
        }
        else {
            // 用户发送消息
            ((RightViewHolder)holder).getRightMsg().setText(msg.getContent());
        }
    }

    @Override
    public int getItemCount() {
        return msgList.size();
    }
}
