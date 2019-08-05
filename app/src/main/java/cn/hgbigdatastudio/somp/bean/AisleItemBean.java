package cn.hgbigdatastudio.somp.bean;

public class AisleItemBean {
    private String name;//名称
    private String channelAddress;//通道地址
    private String unit;//单位
    private String minimumRange;//最小量程
    private String maximumRange;//最大量程
    private int alarmValue1;//报警值
    private int alarmValue2;//报警值
    public AisleItemBean(){

    }
    public AisleItemBean(String name, String channelAddress, String unit, String minimumRange, String maximumRange, int alarmValue1, int alarmValue2) {
        this.name = name;
        this.channelAddress = channelAddress;
        this.unit = unit;
        this.minimumRange = minimumRange;
        this.maximumRange = maximumRange;
        this.alarmValue1 = alarmValue1;
        this.alarmValue2 = alarmValue2;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setChannelAddress(String channelAddress) {
        this.channelAddress = channelAddress;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setMinimumRange(String minimumRange) {
        this.minimumRange = minimumRange;
    }

    public void setMaximumRange(String maximumRange) {
        this.maximumRange = maximumRange;
    }

    public void setAlarmValue1(int alarmValue1) {
        this.alarmValue1 = alarmValue1;
    }

    public void setAlarmValue2(int alarmValue2) {
        this.alarmValue2 = alarmValue2;
    }

    public String getName() {
        return name;
    }

    public String getChannelAddress() {
        return channelAddress;
    }

    public String getUnit() {
        return unit;
    }

    public String getMinimumRange() {
        return minimumRange;
    }

    public String getMaximumRange() {
        return maximumRange;
    }

    public int getAlarmValue1() {
        return alarmValue1;
    }

    public int getAlarmValue2() {
        return alarmValue2;
    }


}
