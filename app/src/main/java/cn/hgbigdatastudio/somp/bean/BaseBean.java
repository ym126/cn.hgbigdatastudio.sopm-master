package cn.hgbigdatastudio.somp.bean;

public class BaseBean {
    private int id;
    /**
     * Desc:当前监测项目名称
     */
    private String name;
    /**
     * Desc:当前数值
     */
    private int value;
    /**
     * Desc:最大值
     */
    private int max;
    /**
     * Desc:最小值
     */
    private int min;
    /**
     * Desc:警告值
     */
    private int warring;
    /**
     * Desc:危险值
     */
    private int danger;

    public BaseBean() {
    }

    public BaseBean(int id, String name, int value, int max, int min, int warring, int danger) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.max = max;
        this.min = min;
        this.warring = warring;
        this.danger = danger;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getWarring() {
        return warring;
    }

    public void setWarring(int warring) {
        this.warring = warring;
    }

    public int getDanger() {
        return danger;
    }

    public void setDanger(int danger) {
        this.danger = danger;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
