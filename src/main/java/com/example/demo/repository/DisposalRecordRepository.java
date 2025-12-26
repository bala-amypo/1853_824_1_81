package com.example.demo.repository;

import com.example.demo.entity.DisposalRecord;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisposalRecordRepository extends JpaRepository<DisposalRecord, Long> {

    Optional<DisposalRecord> findById(Long id);
}
