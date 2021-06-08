package code.collection;

import com.google.common.collect.FluentIterable;

import java.util.Arrays;
import java.util.List;

/**
 * created by iriwen on 2020/06/16.
 */
public class FluentIterator {

    public void test(){

        List<String> testList = Arrays.asList("test1", "test2", "test3");
        FluentIterable<String> from = FluentIterable.from(testList);


    }


}
