package controllers;

import applications.FetchCityDistrictWeatherApp;
import play.mvc.Controller;

/**
 * Created with IntelliJ IDEA.
 * User: yifan
 * Date: 13-2-12
 * Time: 上午9:39
 * To change this template use File | Settings | File Templates.
 */
public class BackgroundJobs extends Controller {

    public static void ajaxStartBackJobs(){

        app.startFetchWeatherInfo();

    }

    public static void ajaxStartFetchCountryInfo(){

        app.reloadCountryInfo();
    }

    private static FetchCityDistrictWeatherApp app = FetchCityDistrictWeatherApp.getFetchCityDistrictWeatherAppInstance();
}
