package com.lambdaschool.macroCalc;

import com.lambdaschool.macroCalc.models.Role;
import com.lambdaschool.macroCalc.models.User;
import com.lambdaschool.macroCalc.models.UserRoles;
import com.lambdaschool.macroCalc.models.Usermetrics;
import com.lambdaschool.macroCalc.repository.UsermetricsRepository;
import com.lambdaschool.macroCalc.services.RoleService;
import com.lambdaschool.macroCalc.services.UserService;
import com.lambdaschool.macroCalc.services.UsermetricsService;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Transactional
@Component
public class SeedData implements CommandLineRunner
{
    @Autowired
    RoleService roleService;

    @Autowired
    UserService userService;

    @Autowired
    UsermetricsService umService;


    @Override
    public void run(String[] args) throws Exception
    {
        Role r1 = new Role("admin");
        Role r2 = new Role("user");
        Role r3 = new Role("data");

        roleService.save(r1);
        roleService.save(r2);
        roleService.save(r3);

        // admin, data, user
        ArrayList<UserRoles> admins = new ArrayList<>();
        admins.add(new UserRoles(new User(), r1));
        admins.add(new UserRoles(new User(), r2));
        admins.add(new UserRoles(new User(), r3));
        User u1 = new User("admin", "ILuvM4th!", admins);
        u1 = userService.save(u1);

        // data, user
        ArrayList<UserRoles> datas = new ArrayList<>();
        datas.add(new UserRoles(new User(), r3));
        datas.add(new UserRoles(new User(), r2));
        User u2 = new User("cinnamon", "1234567", datas);
        u2 = userService.save(u2);

        // user
        ArrayList<UserRoles> users = new ArrayList<>();
        users.add(new UserRoles(new User(), r1));
        User u3 = new User("testbarn", "ILuvM4th!", users);
        u3 = userService.save(u3);

        users = new ArrayList<>();
        users.add(new UserRoles(new User(), r2));
        User u4 = new User("testcat", "password", users);
        u4 = userService.save(u4);

        users = new ArrayList<>();
        users.add(new UserRoles(new User(), r2));
        User u5 = new User("testdog", "password", users);
        u5.getUsermetrics()
                .add(new Usermetrics(u5, "male", 25, "72", 210, "1-2 per week", "Lose weight moderately", "3 meals a day"));
        u5.getUsermetrics()
                .add(new Usermetrics(u5, "male", 25, "72", 210, "1-2 per week", "Lose weight moderately", "3 meals a day"));
        u5 = userService.save(u5);

        System.out.println("\n*** Seed Data ***");
        System.out.println(u1);
        System.out.println(u2);
        System.out.println(u3);
        for (Usermetrics um : u5.getUsermetrics()) {
            System.out.println(um.getUsermetricsid());
        }
        System.out.println("*** Seed Data ***\n");
    }
}