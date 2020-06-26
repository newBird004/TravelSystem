package cn.yy.test;

import java.util.*;

public class HashMapSortTest {
    public static  void main(String []args){
        HashMap<Integer, User> users = new HashMap<>();
        users.put(1, new User("张三", 25));
        users.put(3,new User("李四",22));
        users.put(2, new User("王五", 28));
        System.out.println(users);
        HashMap<Integer, User> sortHashMap = sortHashMap(users);
        System.out.println(sortHashMap);
        /**
         * 控制台输出内容
         * {1=User [name=张三, age=25], 2=User [name=王五,age=28], 3=User [name=李四, age=22]}
         * {2=User [name=王五, age=28], 1=User [name=张三, age=25], 3=User [name=李四, age=22]}
         */
    }

    public static HashMap<Integer,User> sortHashMap(HashMap<Integer,User> hashMap){
        Set<Map.Entry<Integer, User>> entries = hashMap.entrySet();
        List<Map.Entry<Integer,User>> entryList=new ArrayList<>(entries);
        Collections.sort(entryList,new Comparator<Map.Entry<Integer, User>>(){

            @Override
            public int compare(Map.Entry<Integer, User> o1, Map.Entry<Integer, User> o2) {
                return o2.getValue().getAge()-o1.getValue().getAge();
            }

        });
        LinkedHashMap<Integer,User> linkedHashMap=new LinkedHashMap<>();
        for(Map.Entry<Integer,User> entry:entryList){
            linkedHashMap.put(entry.getKey(),entry.getValue());
        }
        return linkedHashMap;
    }
}



class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
