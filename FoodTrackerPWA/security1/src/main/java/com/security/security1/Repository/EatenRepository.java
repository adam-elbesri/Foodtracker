package com.security.security1.Repository;

import java.util.List;

import com.security.security1.Model.Eaten;
import com.security.security1.Model.User;

import org.springframework.data.repository.CrudRepository;

public interface EatenRepository extends CrudRepository<Eaten, Long> {
    List<Eaten> findByUser(User user);
}
