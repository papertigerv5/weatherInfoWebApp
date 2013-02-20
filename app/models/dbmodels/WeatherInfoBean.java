package models.dbmodels;

import models.innerstorage.InTimeWeatherInfo;
import models.innerstorage.StaticWeatherInfoBean;
import models.locationInfo.CityDistrictBean;
import play.db.jpa.Model;

import javax.persistence.Entity;

/**
 * Created with IntelliJ IDEA.
 * User: yifan
 * Date: 13-2-3
 * Time: 下午1:03
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class WeatherInfoBean extends Model {

    public WeatherInfoBean() {

    }

    public WeatherInfoBean(InTimeWeatherInfo inTimeWeatherInfo, StaticWeatherInfoBean staticWeatherInfoBean,CityDistrictBean cityDistrictBean) {

        temperature = inTimeWeatherInfo.getTemperature();
        sweetDegree = inTimeWeatherInfo.getSweetDegree();
        windDirection = inTimeWeatherInfo.getWindDirection();
        windLevel = inTimeWeatherInfo.getWindLevel();
        publishDateInfo = inTimeWeatherInfo.getPublishDateInfo();
        publishHourInfo = inTimeWeatherInfo.getPublishHourInfo();

        status = staticWeatherInfoBean.getStatus();
        waterCount = staticWeatherInfoBean.getWaterCount();

        cityNo = cityDistrictBean.getCityNo();
        districtNo = cityDistrictBean.getDistrictNo();
        districtName = cityDistrictBean.getDiscritName();
        provinceNo = cityDistrictBean.getProvinceNo();
        //TO-DO: add airPressure and evaporation. Not yet because haven't found where the information stores.

    }

    public String getDistrictName() {
        return districtName;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    private String temperature;

    private String sweetDegree;

    private String windDirection;

    private String windLevel;

    private String publishDateInfo;

    private String publishHourInfo;

    private String status;

    private String waterCount;

    private String airPressure;

    private String evaporation;

    private String districtNo;

    private String districtName;

    private String cityNo;

    private String provinceNo;
}
