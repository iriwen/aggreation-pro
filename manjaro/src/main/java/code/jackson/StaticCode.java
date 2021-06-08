package code.jackson;

/**
 * created by iriwen on 2020/10/27.
 */
public class StaticCode {

    public static void main(String[] args) {

        System.out.println(JsonNodeTest.name);
    }



    /*public static JSONObject newPostJsonRetJson(String strHttpUrl, Object request, Map<String, String> headMap) {
        String strBody = JSONObject.toJSONString(request, SerializerFeature.PrettyFormat);
        if (headMap == null) {
            headMap = new LinkedHashMap<String, String>(16);
        }
        headMap.put("content-type", "application/json;charset=UTF-8");
        headMap.put("accept", "application/json;charset=UTF-8");
        HttpResp res = sendPostReq(strHttpUrl, headMap, "application/json", strBody);
        Map<String, String> map = res.getHeadMap();
        if (StrUtil.isEmpty(map)) {
            LOGGER.error("res.getHeadMap() is null,invoke " + strHttpUrl + " has faild ! " + "the faild=" + ResultCode.OTHER_SERVER_ERROR + "; and strBody = " + strBody);
            throw new CommonServiceException(ResultCode.OTHER_SERVER_ERROR + "");
        }
        if (!HttpUtil.SUCCESS.equals(map.get(HttpUtil.RESULTCODE))) {
            LOGGER.error("invoke " + strHttpUrl + " has faild ! " + "the faild=" + map.get("X-Result-Code") + "; and strBody = " + strBody);
            throw new CommonServiceException(JSON.toJSONString(map.get(HttpUtil.RESULTCODE)));
        }
        String resBody = res.getResp();
        JSONObject response = null;
        if (StrUtil.isNotEmpty(resBody)) {
            response = JSONObject.parseObject(resBody, Feature.SortFeidFastMatch);
        }
        return response;
    }*/
}
