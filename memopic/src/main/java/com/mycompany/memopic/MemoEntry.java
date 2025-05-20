package com.mycompany.memopic;

import java.util.Date;

public abstract class MemoEntry {
    protected int id;
    protected String title;
    protected String content;
    protected Date createdAt;
    protected String media_path;

    public MemoEntry(String title, String content, String media_path) {
        this.title = title;
        this.content = content;
        this.createdAt = new Date();
        this.media_path = media_path;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public String getContent() { return content; }
    public Date getCreatedAt() { return createdAt; }

    public abstract void display();
}
