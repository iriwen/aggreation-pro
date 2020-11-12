package com.java.code.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;

/**
 * JsonNode类是不可变的。 要创建JsonNode对象图，必须能够更改图中的JsonNode实例，
 * 例如 设置属性值和子JsonNode实例等。由于是不可变的，因此无法直接使用JsonNode来实现
 */
public class WriteJsonNode {

    public static void main(String[] args) {
        String carJson =
                "{ \"brand\" : \"Mercedes\", \"doors\" : 5," +
                        "  \"owners\" : [\"John\", \"Jack\", \"Jill\"]," +
                        "  \"nestedObject\" : { \"field\" : \"value\" } }";

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode jsonNode = objectMapper.readValue(carJson, JsonNode.class);

            JsonNode brandNode = jsonNode.get("brand");
            String brand = brandNode.asText();
            System.out.println("brand = " + brand);

            JsonNode doorsNode = jsonNode.get("doors");
            int doors = doorsNode.asInt();
            System.out.println("doors = " + doors);

            JsonNode array = jsonNode.get("owners");

            JsonNode jsonNode2 = array.get(0);
            String john = jsonNode2.asText();
            System.out.println("john  = " + john);

            JsonNode child = jsonNode.get("nestedObject");
            JsonNode childField = child.get("field");
            String field = childField.asText();
            System.out.println("field = " + field);

            //Jackson JsonNode有一个称为at()的特殊方法。 at()方法可以从JSON图中以给定JsonNode为根的任何位置访问JSON字段

            //JsonNode nameNode = jsonNode.at("/identification/name");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void  operateObjectNode() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();

        ObjectNode objectNode = mapper.createObjectNode();

        String json = "{\"name\" :\"helolo\",\"address\" :\"shanghai\"}";

        JsonNode treeNode = mapper.readTree(json);

        objectNode.set("rootNode", treeNode);

        JsonNode rootNode = objectNode.get("rootNode");

        objectNode.put("test", "intelliJ idea");
    }

}
