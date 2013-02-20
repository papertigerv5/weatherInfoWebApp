package controllers;

import models.dbmodels.WeatherInfoBean;
import play.mvc.*;

import java.util.ArrayList;
import java.util.List;


public class Application extends Controller {

    public static void index(String cityName,int pageNumber) {
        System.out.println(cityName);
        String placeName;
        if(cityName == null){
            placeName = PLSINPUTCITYNAME;
            render(placeName);
        } else {
            if(pageNumber == 0){
                pageNumber = 1;
            }
            int pageCounts = 2;
            int beginCount = (pageNumber - 1)* pageCounts;
            long satisfiedCount = WeatherInfoBean.count("districtName=?", cityName);
            int totalPages = (int)(satisfiedCount/pageCounts);
            totalPages = (int)satisfiedCount%pageCounts==0?totalPages:totalPages+1;

            List<WeatherInfoBean> results = WeatherInfoBean.find("districtName=?",cityName).from(beginCount).fetch(pageCounts);

            List<Integer> pageNumberList = new ArrayList<Integer>();
            //Stupid solution.
            for(int i = 1; i <= totalPages; i++){
                pageNumberList.add(i);
            }

            placeName = cityName;
            render(results,pageNumberList,pageNumber,placeName);
        }
    }

    private static final String PLSINPUTCITYNAME = "请输入城市名称";

}