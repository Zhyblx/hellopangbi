package lang;

/**
 * 新型冠状病毒监控接口（用友数据）
 * <p>
 * 疫情分布地图接口：https://api.yonyoucloud.com/apis/dst/ncov/spreadQuery
 * 描述：监控杭州的新冠病毒数据
 */

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.Connection;
import org.json.JSONObject;
import org.json.JSONArray;

public class SarsCovSupervisoryControl {

    /**
     * 返回当前杭州新冠病毒当前确认数据；数据格式：确诊病例/疑似病例
     * @return
     * @throws Exception
     */

    public String getHangZhouSarsCovData() throws Exception {
        String currentConfirmedCount = "";
        String suspectedCount="";
        Connection connection = Jsoup.connect("https://api.yonyoucloud.com/apis/dst/ncov/spreadQuery");
        connection.ignoreContentType(true);
        connection.userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.88 Safari/537.36");
        connection.timeout(10000);
        connection.header("authoration", "apicode");
        connection.header("apicode", "0eb1de471c8640cf8160e41ffcc7b374");
        Document document = connection.get();
//        System.out.println(document.text());
        JSONObject jsonObject = new JSONObject(document.text());
        JSONArray jsonArray = jsonObject.getJSONArray("newslist");
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
            if (jsonObject1.toString().indexOf("浙江") != -1) {
                JSONArray jsonArray1 = jsonObject1.getJSONArray("cities");
                for (int j = 0; j < jsonArray1.length(); j++) {
                    JSONObject jsonObject2 = jsonArray1.getJSONObject(j);
                    if (jsonObject2.toString().indexOf("杭州") != -1) {
                        //System.out.println(jsonObject2);
                        currentConfirmedCount = jsonObject2.get("currentConfirmedCount").toString();
                        suspectedCount=jsonObject2.get("suspectedCount").toString();
//                        System.out.println(currentConfirmedCount);

                    }
                }
            }
        }
        return "\033[31;4m"+currentConfirmedCount+ "\033[0m"+"|"+"\033[34;4m"+suspectedCount+"\033[0m";

    }

    public String getLiShuiSarsCovData() throws Exception {
        String currentConfirmedCount = "";
        String suspectedCount="";
        Connection connection = Jsoup.connect("https://api.yonyoucloud.com/apis/dst/ncov/spreadQuery");
        connection.ignoreContentType(true);
        connection.userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.88 Safari/537.36");
        connection.timeout(10000);
        connection.header("authoration", "apicode");
        connection.header("apicode", "0eb1de471c8640cf8160e41ffcc7b374");
        Document document = connection.get();
//        System.out.println(document.text());
        JSONObject jsonObject = new JSONObject(document.text());
        JSONArray jsonArray = jsonObject.getJSONArray("newslist");
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
            if (jsonObject1.toString().indexOf("浙江") != -1) {
                JSONArray jsonArray1 = jsonObject1.getJSONArray("cities");
                for (int j = 0; j < jsonArray1.length(); j++) {
                    JSONObject jsonObject2 = jsonArray1.getJSONObject(j);
                    if (jsonObject2.toString().indexOf("丽水") != -1) {
                        //System.out.println(jsonObject2);
                        currentConfirmedCount = jsonObject2.get("currentConfirmedCount").toString();
                        suspectedCount=jsonObject2.get("suspectedCount").toString();
//                        System.out.println(currentConfirmedCount);

                    }
                }
            }
        }
        return "\033[31;4m"+currentConfirmedCount+ "\033[0m"+"|"+"\033[34;4m"+suspectedCount+"\033[0m";


    }

//    public static void main(String[] args) throws Exception {
//        SarsCovSupervisoryControl sarsCovSupervisoryControl = new SarsCovSupervisoryControl();
//        System.out.println(
//                sarsCovSupervisoryControl.getHangZhouSarsCovData());
//        System.out.println(
//                sarsCovSupervisoryControl.getLiShuiSarsCovData());
//
//    }


}
