package com.lambdaschool.macroCalc.services;

import com.lambdaschool.macroCalc.models.Usermetrics;

import java.util.List;

public interface UsermetricsService {
    List<Usermetrics> findAll();

    Usermetrics findUserMetricsById(long id);

    void delete(long id);

    Usermetrics save(Usermetrics usermetrics);

    Usermetrics update(Usermetrics usermetrics, long id);
}
