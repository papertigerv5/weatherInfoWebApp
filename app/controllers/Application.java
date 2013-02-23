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
            int beginCount = (pageNumber - 1)* PAGE_COUNTS;
            long satisfiedCount = WeatherInfoBean.count("districtName=?", cityName);
            int totalPages = (int)(satisfiedCount/ PAGE_COUNTS);
            totalPages = (int)satisfiedCount% PAGE_COUNTS ==0?totalPages:totalPages+1;

            List<WeatherInfoBean> results = WeatherInfoBean.find("districtName=?",cityName).from(beginCount).fetch(PAGE_COUNTS);

            List<Integer> pageNumberList = new ArrayList<Integer>();
            //Stupid solution.
            for(int i = 1; i <= totalPages; i++){
                pageNumberList.add(i);
            }
            System.out.println(results.size());
            placeName = cityName;
            render(results,pageNumberList,pageNumber,placeName);
        }
    }

    private static final int PAGE_COUNTS = 10;
    private static final String PLSINPUTCITYNAME = "请输入城市名称";

}