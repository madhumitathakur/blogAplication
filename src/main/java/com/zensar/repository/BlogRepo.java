package com.zensar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zensar.entity.BlogEntity;

@Repository
public interface BlogRepo extends JpaRepository<BlogEntity, Integer> {

}
