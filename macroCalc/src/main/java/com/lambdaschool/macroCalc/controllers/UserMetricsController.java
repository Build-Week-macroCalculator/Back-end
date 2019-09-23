package com.lambdaschool.macroCalc.controllers;

import com.lambdaschool.macroCalc.models.User;
import com.lambdaschool.macroCalc.models.Usermetrics;
import com.lambdaschool.macroCalc.services.UserService;
import com.lambdaschool.macroCalc.services.UsermetricsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserMetricsController {

    @Autowired
    private UsermetricsService usermetricsService;

    @Autowired
    private UserService userservice;

    // POST /usermetrics/{username}
    @PostMapping(value = "/usermetrics/{username}")
    public ResponseEntity<?> addUserMetricsByUserName( @PathVariable String username){
        List<Usermetrics> um = usermetricsService.findByUserName(username);
        User user=userservice.findByName(username);

        usermetricsService.save((Usermetrics) um);
        user.setUsermetrics(um);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // PUT /usermetrics/{usermetricsid}
    @PutMapping(value = "/usermetrics/{usermetricsid}")
    public ResponseEntity<?> updateMetrics(@RequestBody Usermetrics usermetrics, @PathVariable long usermetricsid) {
        usermetricsService.update(usermetrics, usermetricsid);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
