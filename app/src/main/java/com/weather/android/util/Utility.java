package com.weather.android.util;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.weather.android.db.City;
import com.weather.android.db.Conty;
import com.weather.android.db.Province;
import com.weather.android.gson.Weather;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by zhancongcong on 2017/8/2.
 */

public class Utility {
    public static boolean handleProvinceResponse(String response){
        if(!TextUtils.isEmpty(response)){
            try{
                JSONArray allProvince = new JSONArray(response);
                for (int i = 0;i<allProvince.length(); i++){
                    JSONObject provinceObject = allProvince.getJSONObject(i);
                    Province province = new Province();
                    province.setProvinceName(provinceObject.getString("name"));
                    province.setProvinceCode(provinceObject.getInt("id"));
                    province.save();
                }
          return true;
            } catch (JSONException e){
                e.printStackTrace();
            }
        }
 return false;
    }

    public static boolean handleCityResponse(String response, int provinceId){
        if(!TextUtils.isEmpty(response)){
            try{
                JSONArray allCties = new JSONArray(response);
                for (int i = 0;i<allCties.length(); i++){
                    JSONObject cityObject = allCties.getJSONObject(i);
                    City city = new City();
                    city.setCityName(cityObject.getString("name"));
                    city.setCityCode(cityObject.getInt("id"));
                    city.setProvinceId(provinceId);
                    city.save();
                }
                return true;
            } catch (JSONException e){
                e.printStackTrace();
            }
        }
        return false;
    }
public static boolean handleCoutyResponse(String response, int cityId){
    if(!TextUtils.isEmpty(response)){
        try {
            JSONArray allCounty = new JSONArray(response);
            for (int i = 0; i<allCounty.length(); i++){
                JSONObject countyObject = allCounty.getJSONObject(i);
                Conty conty = new Conty();
                conty.setContyName(countyObject.getString("name"));
                conty.setWeatherId(countyObject.getString("weather_id"));
                conty.setCityId(cityId);
                conty.save();
            }
            return true;
        } catch (JSONException e){
            e.printStackTrace();
        }
    }
    return false;
}
public static Weather handleWeatherResponse(String response){
    try {
        JSONObject jsonObject = new JSONObject(response);
        JSONArray jsonArray = jsonObject.getJSONArray("HeWeather");
        String weatherContent = jsonArray.getJSONObject(0).toString();
        return new Gson().fromJson(weatherContent,Weather.class);
    } catch (Exception e){
        e.printStackTrace();
    }
    return null;
}
}
