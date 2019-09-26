//package com.lambdaschool.macroCalc;
//
//import com.lambdaschool.macroCalc.models.*;
//import com.lambdaschool.macroCalc.services.RoleService;
//import com.lambdaschool.macroCalc.services.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.ArrayList;
//
//@Transactional
//@Component
//public class SeedData implements CommandLineRunner
//{
//    @Autowired
//    RoleService roleService;
//
//    @Autowired
//    UserService userService;
//
//
//    @Override
//    public void run(String[] args) throws Exception
//    {
//        Role r1 = new Role("admin");
//        Role r2 = new Role("user");
//        Role r3 = new Role("data");
//
//        roleService.save(r1);
//        roleService.save(r2);
//        roleService.save(r3);
//
//        // admin, data, user
//        ArrayList<UserRoles> admins = new ArrayList<>();
//        admins.add(new UserRoles(new User(), r1));
//        admins.add(new UserRoles(new User(), r2));
//        admins.add(new UserRoles(new User(), r3));
//        User u1 = new User("admin", "password", admins);
//        userService.save(u1);
//
//        // data, user
//        ArrayList<UserRoles> datas = new ArrayList<>();
//        datas.add(new UserRoles(new User(), r3));
//        datas.add(new UserRoles(new User(), r2));
//        User u2 = new User("cinnamon", "1234567", datas);
//        userService.save(u2);
//
//        // user
//        ArrayList<UserRoles> users = new ArrayList<>();
//        users.add(new UserRoles(new User(), r2));
//        User u3 = new User("barnbarn", "ILuvM4th!", users);
//        userService.save(u3);
//
//        users = new ArrayList<>();
//        users.add(new UserRoles(new User(), r2));
//        User u4 = new User("Bob", "password", users);
//        userService.save(u4);
//
//        users = new ArrayList<>();
//        users.add(new UserRoles(new User(), r2));
//        User u5 = new User("Jane", "password", users);
//        u5.getUsermetrics()
//                .add(new Usermetrics(u5, "male", 25, "72", 210, "1-2 per week", "Lose weight moderately", "3 meals a day"));
//        userService.save(u5);
//    }
//}