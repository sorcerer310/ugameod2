package com.bsu.ugame.gameparams.api.helper.websocket;

public class OutMessage {
    private String content;

    public OutMessage() {
    }

    public OutMessage(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
