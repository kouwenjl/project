package com.example.sam.jpa;

import com.example.sam.OutSideUser;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OutSideUserRepository extends CrudRepository<OutSideUser,Integer> {
    List<OutSideUser> findAll(Pageable pageable);
}
