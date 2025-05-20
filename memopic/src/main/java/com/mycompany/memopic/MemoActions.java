package com.mycompany.memopic;

public interface MemoActions {
    void addEntry(User user, String title, String content, String media_path);
    void viewEntries(User user);
}