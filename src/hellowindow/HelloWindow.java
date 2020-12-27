package hellowindow;

import calendar.Controller;
import calendar.JuheCalendar;
import gpio.ControlMotor;
import lang.SarsCovSupervisoryControl;
import lang.WeekMap;
import usb.HelloUSB;

import java.text.SimpleDateFormat;
import java.util.Scanner;
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

                TodayWeather todayWeather = new TodayWeather();//天气情况
                SarsCovSupervisoryControl sarsCovSupervisoryControl = new SarsCovSupervisoryControl();// 新冠病毒数据

                //System.out.println("+----------------------------------------------------------+");
                //System.out.println("|-----------------------HelloPangBi------------------------|");
                //System.out.println("|----------------------------------------------------------|");
                //System.out.println("|-------------------" + strDate + " " + weekMap.getWeek(week) + "-------------------|");
                //System.out.println("|----------------------------------------------------------|");
                //System.out.println("|                     " + "Need work:" + needWork + "                      |");
                //System.out.println("|----------------------------------------------------------|");
                //System.out.println("|-------------------------HangZhou-------------------------|");
                //System.out.println("|                                                          |");
                //todayWeather.getTodayWeather(); // 天气占了6行
                //System.out.println("|                                                          |");
                //System.out.println("|                                                 " + todayWeather.getTemperature() + "°C" + "     |");
                //System.out.println("|                                                          |");
                //System.out.println("+----------------------------------------------------------+");

                System.out.println("+----------------------------------------------------------+");
                System.out.println("[HangZhou]");
                System.out.println("      Date:" + strDate);
                System.out.println("      Week:" + weekMap.getWeek(week));
                System.out.println("      NeedWork:" + needWork);
                System.out.println("      SARS-CoV-2:" + sarsCovSupervisoryControl.getHangZhouSarsCovData());
                System.out.println("      Temperature:" + todayWeather.getTemperature() + "°C");
                System.out.println("      Meteorological:");
                System.out.println("");
                todayWeather.getTodayWeather(); // 天气占了6行
                System.out.println("");
                System.out.println("");
                System.out.println("                     Version: 20201226");
                System.out.println("+----------------------------------------------------------+");

            } catch (Exception e) {
                e.printStackTrace();

            }
        }
    };


    public static void main(String[] args) throws Exception {
//        helloWindow.timer.schedule(helloWindow.timerTask, 0, 3600000);
//        System.out.println("---开始测试:202012121252---");
//        ControlMotor.getControlMotor();
//        System.out.println("---完成测试:202012121252---");

        String serviceNum = "";// 服务编号
        while (true) {
            System.out.println("Please select service：" + "\r\n"
                    + "Calendar selection 1;" + "\r\n"
                    + "Feed the cat 2;" + "\r\n"
                    + "Power on or off 3;");
            String inputNum = new Scanner(System.in).nextLine();
            if ("1".equals(inputNum)) {
                helloWindow.timer.schedule(helloWindow.timerTask, 0, 3600000);
                break;

            } else if ("2".equals(inputNum)) {
                System.out.println("---StartTest:202012131046---");
                ControlMotor.getControlMotor();
                System.out.println("---EndTest:202012131046---");
                System.exit(0);
                break;

            } else if ("3".equals(inputNum)) {
                HelloUSB helloUSB = new HelloUSB();
                System.out.println("Power on or off");
                helloUSB.getUSBPowerSupply();

            }
        }
    }
}
