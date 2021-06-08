package com.manjaro.code.codec;


import com.manjaro.json.jackson.JacksonMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * created by iriwen on 2021/05/12.
 */
@Slf4j
public class CombineYearMonth {

    public static void main(String[] args) {

        List<String> yearMonths = Stream.of("202010", "202011", "202012", "202110", "202112").collect(Collectors.toList());

        String result = processAbnormalMonthInfo(yearMonths);

        List<String> fullYearMonth = Stream.of("2020年10月", "2020年01月").collect(Collectors.toList());

        processMonthInfo(fullYearMonth);

    }


    public static String processAbnormalMonthInfo(List<String> months){
        StringBuilder sb = new StringBuilder();
        Map<String, List<String>> yearMonth = months.stream().collect(Collectors.groupingBy(item->item.substring(0,4)));
        //2020年1月、2月、3月,2021年1月、2月、3月
        for(Map.Entry<String,List<String>> entry:yearMonth.entrySet()){
            String oneYearMonth = entry.getKey()+"年" + getGroupMonths(entry.getValue());
            sb.append(oneYearMonth);
        }
        return null;
    }

    private static String  getGroupMonths(List<String> yearMonth) {
        if(CollectionUtils.isNotEmpty(yearMonth)){
            String firtFreezeMonth = yearMonth.get(0).substring(4)+"月";
            for(int i =1 ; i<yearMonth.size();i++){
                firtFreezeMonth += "、"+yearMonth.get(i).substring(4) +"月";
            }
            return firtFreezeMonth + ",";
        }
        return "";
    }



    private static List<String> processMonthInfo(List<String> abnormalMonthInfo) {

        List<String> rawMonth = abnormalMonthInfo.stream().map(item -> {
            String res = item.replaceAll("年","").replaceAll("月","");
            return res ;

        }).collect(Collectors.toList());

        log.info("rawMonth ={}", JacksonMapper.toJsonString(rawMonth));
        return rawMonth;
    }


}
