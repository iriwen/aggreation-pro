package code.jackson;

import code.entity.Employee;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * created by iriwen on 2020/07/15.
 */
public class JacksonTest {

    public static void main(String[] args) throws JsonProcessingException, JSONException {

        ObjectMapper objectMapper = new ObjectMapper();

        String nodeJson = " {\"key1\":\"value1\",\"key2\":\"value2\"}";


        ObjectNode readTree1 = (ObjectNode)objectMapper.readTree(nodeJson);


        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        Employee employee = new Employee();
        employee.setId("1");
        employee.setName("jackson");
        employee.setDepartment(null);
        Map<String, String> map = employee.getMap();
        map.put("field1", "kylie");
        map.put("field2", "manjaro");
        map.put("field3", "iriwen");
        employee.setData(map);

        String result = objectMapper.writeValueAsString(employee);

        JsonNode valueTree = objectMapper.readTree(result);
        String s1 = valueTree.get("data").get("field2").toString();

        ObjectNode node = objectMapper.valueToTree(employee);

        JsonNode nameNode = node.get("name");

        JsonNode mapNode = node.get("map");


        Employee e = objectMapper.readValue(node.toString(), Employee.class);

        ObjectNode canPutObjNode = ((ObjectNode) mapNode).put("new_field", "intelliJ");

        employee.setId(canPutObjNode.toString());

        String s2 = objectMapper.writeValueAsString(employee);

        Map<String,String> fieldMap = objectMapper.readValue(mapNode.toString(), Map.class);

        System.out.println(fieldMap.size());

        JsonNode readTree = objectMapper.readTree(result);

        JsonNode idNode = readTree.get("id");

        JSONObject jsonObject = new JSONObject(objectMapper.writeValueAsString(employee));
        jsonObject.get("name");

        System.out.println("-------------------------------");
        System.out.println(result);

        String employStr = "{\"id\":\"1\",\"name\":\"jackson\",\"company\":\"dev\"}";

        Employee employ = objectMapper.readValue(employStr, Employee.class);
        List<Employee> employees = new ArrayList<>();
        employees.add(employ);

        List<Employee> employeeList = objectMapper.readValue(objectMapper.writeValueAsString(employees), new TypeReference<List<Employee>>() {

        });

        List<Integer> collect = Stream.of(12, 13, 14).collect(Collectors.toList());

        List<Integer> integers = objectMapper.readValue(objectMapper.writeValueAsString(collect), new TypeReference<List<Integer>>() {
        });

        System.out.println(employeeList);
        String bi = "zx03";
        String s = bi.toUpperCase();

        if(s.startsWith("zx")){
            System.out.println("prefix is zx");
        }


        //gson.fromJson(result, new TypeToken<PrepCommonResp<LeaderboardResp>>(){}.getType());
    }
}
