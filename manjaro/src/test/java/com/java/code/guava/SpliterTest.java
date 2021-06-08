package com.java.code.guava;

import com.google.common.base.Splitter;
import org.hamcrest.core.IsEqual;
import org.hamcrest.core.IsNull;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;

/*
 *
 *  @see java.util.List
 * splitter 源代码很优雅 运用了不少设计模式
 *
 */
public class SpliterTest {

    @Test
    public void testSpliter() {
        //忽略空值
        List<String> result = Splitter.on("|").omitEmptyStrings().splitToList("hello|world|||");
        assertThat(result, IsNull.notNullValue());
        assertThat(result.size(), IsEqual.equalTo(2));
    }

    @Test
    public void testSpliterTrim() {
        //忽略空值
        List<String> result = Splitter.on("|").trimResults().splitToList("hello | world");
        assertThat(result, IsNull.notNullValue());
        assertThat(result.size(), IsEqual.equalTo(2));
        assertThat(result.get(0), IsEqual.equalTo("hello"));
    }

    @Test
    public void testSpliterFixedLength() {
        //忽略空值
        List<String> result = Splitter.fixedLength(4).splitToList("aaaabbbbcccc");
        assertThat(result, IsNull.notNullValue());
        assertThat(result.size(), IsEqual.equalTo(3));
        assertThat(result.get(1), IsEqual.equalTo("bbbb"));
    }

    @Test
    public void testSpliterLimit() {
        //忽略空值
        List<String> result = Splitter.on("#").limit(3).splitToList("java#hello#scala#google#test");
        assertThat(result, IsNull.notNullValue());
        assertThat(result.size(), IsEqual.equalTo(3));
        System.out.println(result.get(2));
        assertThat(result.get(2), IsEqual.equalTo("scala#google#test"));
    }

    /*
    支持正则表达式
    * */
    @Test
    public void testSpliterOnPatternString() {
        //忽略空值
        List<String> result = Splitter.onPattern("\\|\\.").trimResults().omitEmptyStrings().splitToList("hello |. world");
        assertThat(result, IsNull.notNullValue());
        assertThat(result.size(), IsEqual.equalTo(2));
        assertThat(result.get(0), IsEqual.equalTo("hello"));

    }

    @Test
    public void testSpliterToMap() {
        //忽略空值
        Map<String,String> result = Splitter.onPattern("\\|\\.").trimResults()
                .omitEmptyStrings().withKeyValueSeparator("=")
                .split("hello=HELLO|. world=WORLD");
        assertThat(result, IsNull.notNullValue());
        assertThat(result.size(), IsEqual.equalTo(2));
        System.out.println(result);
        assertThat(result.get(0), IsEqual.equalTo("hello"));
    }

}
