package com.lambdaschool.macroCalc.services;

import com.lambdaschool.macroCalc.exceptions.ResourceNotFoundException;
import com.lambdaschool.macroCalc.models.Usermetrics;
import com.lambdaschool.macroCalc.repository.UsermetricsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

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
    public Usermetrics save(Usermetrics todo) {
        return null;
    }

}
