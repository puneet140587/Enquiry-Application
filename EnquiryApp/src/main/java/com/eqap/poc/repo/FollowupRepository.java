package com.eqap.poc.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eqap.poc.entity.Followup;

public interface FollowupRepository extends JpaRepository<Followup, Long> {

}
