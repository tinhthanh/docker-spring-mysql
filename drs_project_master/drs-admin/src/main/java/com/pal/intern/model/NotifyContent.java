
package com.pal.intern.model;
public class NotifyContent {
    private  int id;
    private String title ;
    private String body ;
    private int status;
    private Long dateTo ;
    private Long dateView ;
    private String userSend ;

    public NotifyContent() {
    }

    public NotifyContent(int id, String title, String body, int status, Long dateTo, Long dateView, String userSend) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.status = status;
        this.dateTo = dateTo;
        this.dateView = dateView;
        this.userSend = userSend;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Long getDateTo() {
        return dateTo;
    }

    public void setDateTo(Long dateTo) {
        this.dateTo = dateTo;
    }

    public Long getDateView() {
        return dateView;
    }

    public void setDateView(Long dateView) {
        this.dateView = dateView;
    }

    public String getUserSend() {
        return userSend;
    }

    public void setUserSend(String userSend) {
        this.userSend = userSend;
    }

    @Override
    public String toString() {
        return "NotifyContent{" + "id=" + id + ", title=" + title + ", body=" + body + ", status=" + status + ", dataTo=" + dateTo + ", dateView=" + dateView + ", userSend=" + userSend + '}';
    }
    
    
    
}
