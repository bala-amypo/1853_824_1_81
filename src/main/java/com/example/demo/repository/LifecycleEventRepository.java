package com.example.demo.repository;

import com.example.demo.entity.LifecycleEvent;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LifecycleEventRepository extends JpaRepository<LifecycleEvent, Long> {
    List<LifecycleEvent> findByAsset_Id(Long assetId);
}
