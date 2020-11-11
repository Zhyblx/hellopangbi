package hellowindow;

import lang.ArtTable;
import weather.JuheWeather;

public class TodayWeather {

    private JuheWeather juheWeather = new JuheWeather();
    private ArtTable artTable = new ArtTable();

    public void getTodayWeather() throws Exception {
        String weatherID=juheWeather.getCityWeatherID("1512");
//        String weatherID = "26";

        // 晴
        if (weatherID.equals("00")) {
            artTable.getSunArtTableRun();

        }

        // 云
        if (weatherID.equals("02") || weatherID.equals("20")) {
            artTable.getCloudArtTableRun();

        }

        // 多云
        if (weatherID.equals("01") || weatherID.equals("18") ||
                weatherID.equals("29") || weatherID.equals("30") ||
                weatherID.equals("31") || weatherID.equals("53")) {
            artTable.getCloudyArtTableRun();

        }

        //雨
        if (weatherID.equals("06") || weatherID.equals("07") || weatherID.equals("08") || weatherID.equals("09")
                || weatherID.equals("10") || weatherID.equals("11") || weatherID.equals("12") || weatherID.equals("19")
                || weatherID.equals("21") || weatherID.equals("22") || weatherID.equals("23") || weatherID.equals("24") || weatherID.equals("25")) {
            artTable.getDownpourArtTableRun();

        }

        //阵雨
        if (weatherID.equals("03") || weatherID.equals("04") || weatherID.equals("05")) {
            artTable.getShowerArtTableRun();

        }

        //雪
        if(weatherID.equals("13")|| weatherID.equals("14")|| weatherID.equals("15")|| weatherID.equals("16")
                || weatherID.equals("17")|| weatherID.equals("26")|| weatherID.equals("27")|| weatherID.equals("28")){
            artTable.getSnowArtTableRun();

        }
    }

    public static void main(String[] args) {
        try {
            new TodayWeather().getTodayWeather();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
