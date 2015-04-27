package demo.litepal.com.litepalapp;

import org.litepal.crud.DataSupport;

/**
 * Created by Administrator on 2015/4/21 0021.
 */
public class Student extends DataSupport implements DataSuportDao {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
