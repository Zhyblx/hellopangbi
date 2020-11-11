package test;

import calendar.JuheCalendar;
import weather.JuheWeather;

public class HelloWorld {
    private static JuheCalendar juheCalendar=new JuheCalendar();
    public static void main(String[] args){
        try {
//            System.out.println(juheCalendar.getCalendar("2020-11-9"));
//            System.out.println(juheCalendar.getCalendar("2020-11-10"));
//            System.out.println(juheCalendar.getCalendar("2020-11-11"));
//            System.out.println(juheCalendar.getCalendar("2020-11-12"));
//            System.out.println(juheCalendar.getCalendar("2020-11-13"));
//            System.out.println(juheCalendar.getCalendar("2020-11-14"));
//            System.out.println(juheCalendar.getCalendar("2020-11-15"));

            System.out.println(new JuheWeather().getCityWeatherID("1512"));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
