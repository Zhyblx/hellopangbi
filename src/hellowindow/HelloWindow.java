package hellowindow;

import calendar.Controller;
import calendar.JuheCalendar;
import lang.WeekMap;
import util.Log;

import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Date;

public class HelloWindow {

    private static HelloWindow helloWindow = new HelloWindow();
    private Timer timer = new Timer();
    private TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-M-d");//设置日期格式
                String strDate = simpleDateFormat.format(new Date());
                WeekMap weekMap = new WeekMap();
                JuheCalendar juheCalendar = new JuheCalendar(); // 获取星期数据
                String week = juheCalendar.getCalendar(strDate);

                Controller controller = new Controller(strDate); // 判断是否需要工作
                String needWork = "";
                if (controller.getBoolean()) {
                    needWork = " true";

                } else {
                    needWork = "false";

                }

                TodayWeather todayWeather=new TodayWeather();//天气情况

                System.out.println("+----------------------------------------------------------+");
                System.out.println("|-----------------------HelloPangBi------------------------|");
                System.out.println("|----------------------------------------------------------|");
                System.out.println("|-------------------" + strDate + " " + weekMap.getWeek(week) + "-------------------|");
                System.out.println("|----------------------------------------------------------|");
                System.out.println("|                     " + "Need work:" + needWork + "                      |");
                System.out.println("|----------------------------------------------------------|");
                System.out.println("|-------------------------HangZhou-------------------------|");
                System.out.println("|                                                          |");
                todayWeather.getTodayWeather(); // 天气占了6行
                System.out.println("|                                                          |");
                System.out.println("|                                                 "+todayWeather.getTemperature()+"°C"+"     |");
                System.out.println("|                                                          |");
                System.out.println("+----------------------------------------------------------+");

            } catch (Exception e) {
                Log.setLog(e.toString());
                e.printStackTrace();

            }
        }
    };


    public static void main(String[] args) {
        helloWindow.timer.schedule(helloWindow.timerTask, 0, 3600000);

    }
}
