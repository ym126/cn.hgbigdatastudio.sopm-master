package cn.hgbigdatastudio.somp.bean;

public class AlarmItemBean {
    private String date;//日期
    private String time;//时间
    private String AlarmValue;//报警值
    private String AlarmContent;//报警内容

    public AlarmItemBean(String date, String time, String alarmValue, String alarmContent) {
        this.date = date;
        this.time = time;
        AlarmValue = alarmValue;
        AlarmContent = alarmContent;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAlarmValue() {
        return AlarmValue;
    }

    public void setAlarmValue(String alarmValue) {
        AlarmValue = alarmValue;
    }

    public String getAlarmContent() {
        return AlarmContent;
    }

    public void setAlarmContent(String alarmContent) {
        AlarmContent = alarmContent;
    }
}
