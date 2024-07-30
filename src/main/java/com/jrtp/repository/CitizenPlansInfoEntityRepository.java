package com.jrtp.repository;

import com.jrtp.entity.CitizenPlansInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CitizenPlansInfoEntityRepository extends JpaRepository<CitizenPlansInfoEntity, Long> {
    @Query("select distinct(planName) from CitizenPlansInfoEntity")
    public List<String> getPlanName();

    @Query("select distinct(planStatus) from CitizenPlansInfoEntity")
    public List<String> getPlanStatus();

}