package com.mycompany.memopic;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Post class extends MemoEntry to represent a post/memo in the application
 */
public class Post extends MemoEntry {
    private int id;
    private Timestamp created_at;

    public Post(String title, String content, String media_path) {
        super(title, content, media_path);
    }
    
    public Post(int id, String title, String content, String media_path, Timestamp created_at) {
        super(title, content, media_path);
        this.id = id;
        this.created_at = created_at;
    }

    @Override
    public void display() {
        System.out.println("===========================");
        System.out.println("Title: " + title);
        System.out.println("----------------------------");
        System.out.println(content);
        System.out.println("----------------------------");
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy HH:mm");
        System.out.println("Created at: " + sdf.format(created_at));
        System.out.println("===========================");
    }
    
    public int getId() {
        return id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getContent() {
        return content;
    }
    
public Date getCreatedAt() {
    return createdAt;
}
    
    public Timestamp getCreatedAtTimestamp() {
        return created_at;
    }
}