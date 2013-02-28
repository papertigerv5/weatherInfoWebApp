package controllers;

import models.dbmodels.WeatherInfoBean;
import play.mvc.*;

import java.util.ArrayList;
import java.util.List;


public class Application extends Controller {

    public static void index(String cityName,int checkedPageIndex,int startPageIndex) {
        System.out.println(cityName);
        String placeName;
        if(cityName == null){
            placeName = PLSINPUTCITYNAME;
            render(placeName);
        } else {
            if(checkedPageIndex == 0){
                checkedPageIndex = 1;
            }

            if(startPageIndex == 0){
                startPageIndex = 1;
            }

            if(checkedPageIndex == startPageIndex + PAGE_SHOW_COUNT - 1){
                startPageIndex = startPageIndex + PAGE_SHOW_COUNT - 1;
            }else if(checkedPageIndex <= startPageIndex){
                if(startPageIndex - PAGE_SHOW_COUNT > 0){
                    startPageIndex = startPageIndex - PAGE_SHOW_COUNT;
                } else {
                    startPageIndex = 1;
                }
            }

            int beginCount = (checkedPageIndex - 1)* PAGE_PER_COUNT;
            long satisfiedCount = WeatherInfoBean.count("districtName=?", cityName);
            int totalPages = (int)(satisfiedCount/ PAGE_PER_COUNT);
            totalPages = (int)satisfiedCount%PAGE_PER_COUNT ==0?totalPages:totalPages+1;

            List<WeatherInfoBean> results = WeatherInfoBean.find("districtName=? order by id desc",cityName).from(beginCount).fetch(PAGE_PER_COUNT);

            //Stupid solution.
            List<Integer> pageNumberList = new ArrayList<Integer>();

            int pageIndex = startPageIndex;
            for(pageIndex = startPageIndex; pageIndex < startPageIndex + PAGE_SHOW_COUNT;){
                if(pageIndex <= totalPages){
                    pageNumberList.add(pageIndex);
                    pageIndex++;
                } else {
                    break;
                }
            }

            placeName = cityName;
            int pageShowCounts = PAGE_SHOW_COUNT;
            render(results,pageNumberList,checkedPageIndex,placeName,totalPages,pageShowCounts,startPageIndex);
        }
    }

    private static final int PAGE_SHOW_COUNT = 15;
    private static final int PAGE_PER_COUNT = 10;
    private static final String PLSINPUTCITYNAME = "请输入城市名称";
    private static final String PLACEINDEX = "...";

}