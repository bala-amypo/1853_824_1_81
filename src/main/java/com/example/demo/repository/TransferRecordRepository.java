package com.example.demo.repository;

import com.example.demo.entity.TransferRecord;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferRecordRepository extends JpaRepository<TransferRecord, Long> {

    List<TransferRecord> findByAsset_Id(Long assetId);
}
