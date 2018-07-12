package com.pal.intern.config.redmine;

public enum IssueStatus {

    DONE(0),
    NEW(1),
    IN_PROCESS(2),
    RESOLVED(3),
    FEEDBACK(4),
    CLOSED(5),
    REJECTED(6);

    private final int value;

    private IssueStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
