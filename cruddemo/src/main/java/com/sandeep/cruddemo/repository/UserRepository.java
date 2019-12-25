package com.sandeep.cruddemo.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sandeep.cruddemo.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
