package com.volvo.assessment.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.volvo.assessment.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
