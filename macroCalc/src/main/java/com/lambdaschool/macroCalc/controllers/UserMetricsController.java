package com.lambdaschool.macroCalc.controllers;

import com.lambdaschool.macroCalc.models.User;
import com.lambdaschool.macroCalc.models.Usermetrics;
import com.lambdaschool.macroCalc.services.UserService;
import com.lambdaschool.macroCalc.services.UsermetricsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserMetricsController {

    @Autowired
    private UsermetricsService usermetricsService;

    @Autowired
    private UserService userservice;

    // POST /usermetrics/{username}
    @PostMapping(value = "/usermetrics/{username}", consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<?> addUserMetricsByUserName(@PathVariable String username, @Valid @RequestBody Usermetrics newMetrics){
        newMetrics.setUser(userservice.findByName(username));
        newMetrics = usermetricsService.save(newMetrics);
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newMetricsURI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{usermetricsid}").buildAndExpand(newMetrics.getUsermetricsid()).toUri();
        responseHeaders.setLocation(newMetricsURI);
        return new ResponseEntity<>(newMetrics, responseHeaders, HttpStatus.CREATED);
    }

    // PUT /usermetrics/{usermetricsid}
    @PutMapping(value = "/usermetrics/{usermetricsid}")
    public ResponseEntity<?> updateMetrics(@RequestBody Usermetrics usermetrics, @PathVariable long usermetricsid) {
        usermetricsService.update(usermetrics, usermetricsid);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
