package com.lambdaschool.macroCalc.services;

import com.lambdaschool.macroCalc.exceptions.ResourceNotFoundException;
import com.lambdaschool.macroCalc.models.Usermetrics;
import com.lambdaschool.macroCalc.repository.UsermetricsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service(value = "userMetricsService")
public class UsermetricsServiceImpl implements UsermetricsService {

    @Autowired
    private UsermetricsRepository usermetricsrepo;

    @Override
    public List<Usermetrics> findAll() {
        List<Usermetrics> list = new ArrayList<>();
        usermetricsrepo.findAll()
                .iterator()
                .forEachRemaining(list::add);
        return list;
    }

    @Override
    public Usermetrics findUserMetricsById(long id) {
        return usermetricsrepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Useremail with id " + id + " Not Found!"));
    }

    @Override
    public List<Usermetrics> findByUserName(String username) {
        return usermetricsrepo.findAllByUser_Username(username);
    }

    @Override
    public void delete(long id) {
        if (usermetricsrepo.findById(id)
                .isPresent())
        {
            Authentication authentication = SecurityContextHolder.getContext()
                    .getAuthentication();
            if (usermetricsrepo.findById(id)
                    .get()
                    .getUser()
                    .getUsername()
                    .equalsIgnoreCase(authentication.getName()))
            {
                usermetricsrepo.deleteById(id);
            } else
            {
                throw new ResourceNotFoundException(authentication.getName() + " not authorized to make change");
            }
        } else
        {
            throw new ResourceNotFoundException("Useremail with id " + id + " Not Found!");
        }
    }

    @Override
    public Usermetrics save(Usermetrics usermetrics) {
        Authentication authentication = SecurityContextHolder.getContext()
                .getAuthentication();

        if (usermetrics.getUser()
                .getUsername()
                .equalsIgnoreCase(authentication.getName()))
        {
            Usermetrics data=new Usermetrics();
            if (usermetrics.getGender() != null) {
                data.setGender(usermetrics.getGender());
            }

            if (usermetrics.getAge() != null) {
                data.setAge(usermetrics.getAge());
            }

            if (usermetrics.getHeight() != null) {
                data.setHeight(usermetrics.getHeight());
            }

            if (usermetrics.getWeight() != null) {
                data.setWeight(usermetrics.getWeight());
            }

            if (usermetrics.getExercisefrequency() != null) {
                data.setExercisefrequency(usermetrics.getExercisefrequency());
            }

            if (usermetrics.getGoal() != null) {
                data.setGoal(usermetrics.getGoal());
            }

            if (usermetrics.getMeals() != null) {
                data.setMeals(usermetrics.getMeals());
            }

            return usermetricsrepo.save(data);
        }
        else
        {
            throw new ResourceNotFoundException((authentication.getName() + "not authorized to make change"));
        }
    }

    @Override
    public Usermetrics update(Usermetrics usermetrics, long id) {
        Usermetrics newMetrics = usermetricsrepo.findById(id).orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));

        if (usermetrics.getGender() != null) {
            newMetrics.setGender(usermetrics.getGender());
        }

        if (usermetrics.getAge() != null) {
            newMetrics.setAge(usermetrics.getAge());
        }

        if (usermetrics.getHeight() != null) {
            newMetrics.setHeight(usermetrics.getHeight());
        }

        if (usermetrics.getWeight() != null) {
            newMetrics.setWeight(usermetrics.getWeight());
        }

        if (usermetrics.getExercisefrequency() != null) {
            newMetrics.setExercisefrequency(usermetrics.getExercisefrequency());
        }

        if (usermetrics.getGoal() != null) {
            newMetrics.setGoal(usermetrics.getGoal());
        }

        if (usermetrics.getMeals() != null) {
            newMetrics.setMeals(usermetrics.getMeals());
        }

        return usermetricsrepo.save(newMetrics);
    }
}
