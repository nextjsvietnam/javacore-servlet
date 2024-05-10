package model;

// JavaBean
// 1. Implements Serializable
// 2. No arg constructor
// 3. private members w/ getters and setters

import java.io.Serializable;


public class Example implements Serializable {
    private String title;
    private Status status;

    public Example() {}

    public Example(String title, Status status) {
        this.title = title;
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
