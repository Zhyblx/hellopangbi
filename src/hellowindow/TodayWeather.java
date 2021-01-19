package hellowindow;

import lang.ArtTable;
import weather.JuheWeather;

public class TodayWeather {

    private JuheWeather juheWeather = new JuheWeather();
    private ArtTable artTable = new ArtTable();
    private String[] weatherID;

    {
        try {
            weatherID = juheWeather.getCityWeatherData("1512");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getTodayWeather() throws Exception {

//        String weatherID = "26";

        // 晴
        if (weatherID[0].equals("00")) {
            artTable.getSunArtTableRun();

        }

        // 云
        if (weatherID[0].equals("02") || weatherID[0].equals("20")) {
            artTable.getCloudArtTableRun();

        }

        // 多云
        if (weatherID[0].equals("01") || weatherID[0].equals("18") ||
                weatherID[0].equals("29") || weatherID[0].equals("30") ||
                weatherID[0].equals("31") || weatherID[0].equals("53")) {
            artTable.getCloudyArtTableRun();

        }

        //雨
        if (weatherID[0].equals("06") || weatherID[0].equals("07") || weatherID[0].equals("08") || weatherID[0].equals("09")
                || weatherID[0].equals("10") || weatherID[0].equals("11") || weatherID[0].equals("12") || weatherID[0].equals("19")
                || weatherID[0].equals("21") || weatherID[0].equals("22") || weatherID[0].equals("23") || weatherID[0].equals("24") || weatherID[0].equals("25")) {
            artTable.getDownpourArtTableRun();

        }

        //阵雨
        if (weatherID[0].equals("03") || weatherID[0].equals("04") || weatherID[0].equals("05")) {
            artTable.getShowerArtTableRun();

        }

        //雪
        if (weatherID[0].equals("13") || weatherID[0].equals("14") || weatherID[0].equals("15") || weatherID[0].equals("16")
                || weatherID[0].equals("17") || weatherID[0].equals("26") || weatherID[0].equals("27") || weatherID.equals("28")) {
            artTable.getSnowArtTableRun();

        }
    }

    /**
     * 当前气温
     * @return
     */
    public String getTemperature() {
        return this.weatherID[1];

    }

    /**
     * 当天气温
     * @return
     */
    public String getDateTemperature(){
        return this.weatherID[2];
    }

    public static void main(String[] args) {
        try {
//            TodayWeather todayWeather = new TodayWeather();
//            todayWeather.getTodayWeather();
//            System.out.println(todayWeather.getTemperature());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
