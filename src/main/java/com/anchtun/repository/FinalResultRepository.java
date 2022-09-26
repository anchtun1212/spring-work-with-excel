package com.anchtun.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anchtun.model.FinalResultEntity;

@Repository
public interface FinalResultRepository extends JpaRepository<FinalResultEntity, Long> {

}
