package com.github.yeecode.mybatisdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;

@RestController
@RequestMapping("/")
public class MainController {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        for (Integer num: list){
            System.out.println(num);
        }

        Supplier<Double> supplier2= Math::random;
        System.out.println(supplier2.get());
    }

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/")
    public Object index() {
        User userParam = new User();
        userParam.setSchoolName("Sunny School");
        List<User> userList = userMapper.queryUserBySchoolName(userParam);
        for (User user : userList) {
            System.out.println("name : " + user.getName() + " ;  email : " + user.getEmail());
        }
        return userList;
    }
}
