package com.lambdaschool.macroCalc.repository;

import com.lambdaschool.macroCalc.models.Usermetrics;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsermetricsRepository extends CrudRepository<Usermetrics, Long> {
    List<Usermetrics> findAllByUser_Username(String name);
}
