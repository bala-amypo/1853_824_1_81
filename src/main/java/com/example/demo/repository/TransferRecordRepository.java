package com.example.demo.repository;

import com.example.demo.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface TransferRecordRepository extends JpaRepository<TransferRecord, Long> {
    List<TransferRecord> findByAsset_Id(Long assetId);
}
