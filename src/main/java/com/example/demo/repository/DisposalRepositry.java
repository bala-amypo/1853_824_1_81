package com.example.demo.repository;

import com.example.demo.entity.DiposalRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LifecycleEventRepository extends JpaRepository<LifecycleEvent, Long> {
 

}

