package com.manjaro.code.lambda;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * created by iriwen on 2021/03/25.
 */
public class TypeSortTest {


    public static final Map<String, String> EMPTY_HEADERS = new HashMap<String, String>(0);

    public static void main(String[] args) {

        Book b1 = new Book("1","西游记");
        Book b2 = new Book("1","水浒传");
        Book w1 = new Book("2","枪炮、细菌、钢铁");
        Book w2 = new Book("2","创新者的秘密");

        List<Book> books = Stream.of(b1, b2, w1, w2).collect(Collectors.toList());
        Map<String, List<Book>> listMap = books.stream().collect(Collectors.groupingBy(item -> item.getType()));

        //单字段排序，根据id排序
        books.sort(Comparator.comparing(Book::getType));
        //多字段排序，根据id，年龄排序
        //userList.sort(Comparator.comparing(User::getId).thenComparing(User::getAge));
        System.out.println(listMap);
        Map<String, String> map = new HashMap<>(0);

        if (map != TypeSortTest.EMPTY_HEADERS) {
            System.out.println("not equals");
        }
    }

}

@Data
@AllArgsConstructor
class Book{

    public String type;

    public String bookName;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}