package com.java.code.guava;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;
import com.google.common.io.Files;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class JoinerTest {

    private final List<String> stringList = Arrays.asList("google", "java", "guava", "scala");

    private final List<String> stringWithNullList = Arrays.asList("google", "java", "guava", "scala", null);

    private final Map<String, String> map = ImmutableMap.of("hello", "java", "Hello", "scala");

    private final String filepath = "/Users/iriwen/guava/guava-joiner.txt";

    @Test
    public void testJoiner() {
        String result = Joiner.on("#").join(stringList);
        String withNullResult = Joiner.on("#").skipNulls().join(stringWithNullList);
        String repalceNull = Joiner.on("#").useForNull("ddd").join(stringWithNullList);
        System.out.println(result + ":" + withNullResult + " : " + repalceNull);
        Assert.assertThat(repalceNull, Matchers.equalTo("google#java#guava#scala#ddd"));
    }

    @Test
    public void testAppendTo() {
        StringBuilder builder = new StringBuilder();
        StringBuilder repalceNull = Joiner.on("#").useForNull("ddd").appendTo(builder, stringWithNullList);
        System.out.println(repalceNull.toString());
    }

    @Test
    public void testJoinByLambda() {
        String strs = stringList.stream().filter(item -> item != null).collect(Collectors.joining(";"));
        System.out.printf(strs);
        //strs.isEmpty()
    }

    @Test
    public void testJoinMap() {
        String joinMap = Joiner.on(";").withKeyValueSeparator("==").join(map);
        System.out.println(joinMap);
    }

    @Test
    public void testWriteToFile() {
        //try with resource
        try(FileWriter writer = new FileWriter(new File(filepath))) {
            Joiner.on(";").withKeyValueSeparator("==").appendTo(writer, map);
            boolean test = Files.isFile().test(new File(filepath));
        } catch (Exception e) {
            Assert.fail(" failed to append to file");
        }
    }
}
