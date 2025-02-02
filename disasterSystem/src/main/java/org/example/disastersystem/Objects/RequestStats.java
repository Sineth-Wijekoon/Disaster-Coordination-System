package org.example.disastersystem.Objects;

public class RequestStats {
    private int pending;
    private int completed;

    public RequestStats(int pending, int completed) {
        this.pending = pending;
        this.completed = completed;
    }

    public int getPending() {
        return pending;
    }

    public void setPending(int pending) {
        this.pending = pending;
    }

    public int getCompleted() {
        return completed;
    }

    public void setCompleted(int completed) {
        this.completed = completed;
    }
}

