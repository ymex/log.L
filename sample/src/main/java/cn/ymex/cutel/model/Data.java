package cn.ymex.cutel.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.ymex.cutel.entity.User;

/**
 * Created by ymexc on 2016/5/11.
 */
public class Data {

    public static User[] array(){
        User u2 = new User("Mars",32,"F","USA");
        User u3 = new User("Abigail",22,"M","UK");
        return new User[]{u2,u3};
    }

    public static User object(){
        return new User("Mars",32,"F","USA");
    }

    public static Map<String , User> map(){
        return new HashMap<String,User>(){{
            User u1 = new User("Jay",32,"F","china");
            User u2 = new User("Mars",32,"F","USA");
            put(u1.getName(),u1);
            put(u2.getName(),u2);
        }};
    }

    public static List<User> list(){
        return new ArrayList<User>(){{

            User u3 = new User("Abigail",22,"M","UK");
            User u4 = new User("Tom",32,"F","Egypt");
            add(u3);
            add(u4);
        }};
    }
}
