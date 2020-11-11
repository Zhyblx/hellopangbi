package lang;

import java.util.Map;
import java.util.HashMap;

public class WeekMap {

    public String getWeek(String strWeek){
        Map<String,String> map=new HashMap<String,String>();
        map.put("星期一","Monday   ");
        map.put("星期二","Tuesday  ");
        map.put("星期三","Wednesday");
        map.put("星期四","Thursday ");
        map.put("星期五","Friday   ");
        map.put("星期六","Saturday ");
        map.put("星期日","Sunday   ");
        return map.get(strWeek);

    }

//    public static void main(String[] args){
//        WeekMap weekMap=new WeekMap();
//        System.out.println(weekMap.getWeek("星期三"));
//
//    }

}
