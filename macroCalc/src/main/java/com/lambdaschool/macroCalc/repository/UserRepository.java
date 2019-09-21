package com.lambdaschool.macroCalc.repository;

import com.lambdaschool.macroCalc.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>
{
    User findByUsername(String username);
}
