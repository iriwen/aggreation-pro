package code.filter;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * created by iriwen on 2020/10/20.
 */

public class JacksonManualHttpMessageConverter extends MappingJackson2HttpMessageConverter {

    private static final Logger logger = LoggerFactory.getLogger(JacksonManualHttpMessageConverter.class.getName());

    @Override
    public Object read(Type type, Class<?> contextClass, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        JavaType javaType = getJavaType(type, contextClass);
        ObjectMapper objectMapper = super.getObjectMapper();

        //logger.info("className : {}", javaType.getClass().getName());
        logger.info("input message : {} ,class Type : {}", inputMessage.getBody().toString(), javaType.toString());

        //映射list为单独类型的判断,实际内部处理成linkedHashMap
        //objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        Object obj = objectMapper.readValue(inputMessage.getBody(), javaType);

        if(obj instanceof Map){
            Map map = (LinkedHashMap) obj;
            if(map.size()==1){
                //obj = Stream.of(13, 14).collect(Collectors.toList());
            }
        }
        //String jsonString = objectMapper.writeValueAsString(obj);

        //Object resultObj = objectMapper.readValue(jsonString, javaType);

        return obj;
    }

    // 这个就是父类的readJavaType方法，由于父类该方法是private的，所以我们copy一个用
    /*private Object readJavaType(JavaType javaType, HttpInputMessage inputMessage) {
        try {




            return objectMapper.readValue(inputMessage.getBody(), javaType);
        } catch (IOException ex) {
            throw new HttpMessageNotReadableException("Could not read JSON: " + ex.getMessage(), ex);
        }
    }*/

    // 重写writeInternal方法，在返回内容前首先进行加密
    @Override
    protected void writeInternal(Object object, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        // 使用Jackson的ObjectMapper将Java对象转换成Json String
        String json = super.getObjectMapper().writeValueAsString(object);
        //String result = cleanXSS(json.toString());
        //outputMessage.getBody().write(result.getBytes());
        outputMessage.getBody().write(json.getBytes());
    }
}
