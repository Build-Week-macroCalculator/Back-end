package com.lambdaschool.macroCalc.controllers;

import com.lambdaschool.macroCalc.models.Usermetrics;
import com.lambdaschool.macroCalc.services.UsermetricsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserMetricsController {

    @Autowired
    private UsermetricsService usermetricsService;

    // PUT /usermetrics/{usermetricsid}
    @PutMapping(value = "/usermetrics/{usermetricsid}")
    public ResponseEntity<?> updateMetrics(@RequestBody Usermetrics usermetrics, @PathVariable long usermetricsid) {
        usermetricsService.update(usermetrics, usermetricsid);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
