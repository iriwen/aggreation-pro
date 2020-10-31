package com.java.code.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.code.entity.CommonVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * created by yuxiaodong01 on 2020/10/26.
 */
public class JsonNodeTest {

    private static final Logger logger = LoggerFactory.getLogger(JsonNodeTest.class);

    static String name = "kafayi";

    static {
        logger.info("static  execute ... ");
        name = "修改了 静态变量name 。。。";
    }

    public static void main(String[] args) throws JsonProcessingException {

        //String str = "{\"code\":\"300\",\"message\":\"success\",\"data\":\"---------\"}";

        System.out.println(JsonNodeTest.name);

        ObjectMapper objectMapper = new ObjectMapper();
        CommonVo vo = new CommonVo();

        vo.setCode("300");
        vo.setMessage("success");
        vo.setData("---------");

        String s = objectMapper.writeValueAsString(vo);
        JsonNode node = objectMapper.valueToTree(s);
        JsonNode code = node.get("code");
        System.out.println(code.toString());

    }
}
