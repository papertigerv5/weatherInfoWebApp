package service;

import models.dbmodels.WeatherInfoBean;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import play.db.jpa.JPA;

import javax.persistence.EntityManager;

/**
 * Created with IntelliJ IDEA.
 * User: yifan
 * Date: 13-2-17
 * Time: 下午9:46
 * To change this template use File | Settings | File Templates.
 */
public class StoreWeatherInfoBeanService {

    public static StoreWeatherInfoBeanService getStoreWeatherInfoBeanServiceInstance(){
        if(storeWeatherInfoBeanService == null){
            storeWeatherInfoBeanService = new StoreWeatherInfoBeanService();
        }

        return storeWeatherInfoBeanService;
    }

    /**
     * Store the specified entity to DB.
     * TO-DO:   try to use the JPA model to save the object.
     *              If save the object directly, there would be dead lock.
     *                      googled and found nothing valid involved that.
     *
     * @param weatherInfoBean
     */
    public void storeWeatherInfoBean(WeatherInfoBean weatherInfoBean){
        session.getTransaction().begin();
        session.save(weatherInfoBean);
        session.getTransaction().commit();
    }


    private StoreWeatherInfoBeanService(){

    }

    private SessionFactory sessionFactory = SessionFactoryService.getSessionFactory();
    private Session session = sessionFactory.openSession();

    private static StoreWeatherInfoBeanService storeWeatherInfoBeanService;
}
