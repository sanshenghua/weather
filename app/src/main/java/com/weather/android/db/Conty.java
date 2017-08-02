package com.weather.android.db;

import org.litepal.crud.DataSupport;

/**
 * Created by zhancongcong on 2017/8/2.
 */

public class Conty extends DataSupport {
    private int id;
    private String contyName;
    private String weatherId;
    private int cityId;

    public int getId() {
        return id;
    }

    public int getCityId() {
        return cityId;
    }

    public String getContyName() {
        return contyName;
    }

    public String getWeatherId() {
        return weatherId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public void setContyName(String contyName) {
        this.contyName = contyName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setWeatherId(String weatherId) {
        this.weatherId = weatherId;
    }

}
