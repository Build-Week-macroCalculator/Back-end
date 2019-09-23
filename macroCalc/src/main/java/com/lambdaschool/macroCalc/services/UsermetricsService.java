package com.lambdaschool.macroCalc.services;

import com.lambdaschool.macroCalc.models.Usermetrics;

import java.util.List;

public interface UsermetricsService {
    List<Usermetrics> findAll();

    Usermetrics findUserMetricsById(long id);

    List<Usermetrics> findByUserName(String username);

    void delete(long id);

    Usermetrics save(Usermetrics todo);

    Usermetrics update(Usermetrics usermetrics, long id);
}
