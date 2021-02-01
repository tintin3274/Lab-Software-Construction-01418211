package to_do_list;

import java.time.LocalDate;

public class ToDoList {
    private String title;
    private String description;
    private String statusText;
    private String date_time;
    private LocalDate date;
    private boolean status;
    private int hour;
    private int minute;


    public ToDoList(LocalDate date, String date_time, String title, String description, int hour, int minute) {
        this.date = date;
        this.date_time = date_time;
        this.title = title;
        this.description = description;
        this.statusText = "Not Complete";
        this.status = false;
        this.hour = hour;
        this.minute = minute;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDate_time() {
        return date_time;
    }

    public String getStatusText() {
        return statusText;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus() {
        this.status = !this.status;
    }

    public void setStatusText() {
        if (this.status) {
            this.statusText = "Complete";
        } else {
            this.statusText = "Not Complete";
        }
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }
}
