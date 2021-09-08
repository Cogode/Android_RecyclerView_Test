package com.example.testrecyclerview;

/**
 * 消息类
 */

public class Message {
    public static final int TYPE_RECEIVE = 0;    // 接收
    public static final int TYPE_SEND = 1;    // 发送

    private String content;
    private int type;

    public Message(String content, int type) {
        this.content = content;
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
