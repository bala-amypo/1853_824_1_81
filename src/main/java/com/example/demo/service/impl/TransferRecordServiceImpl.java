package com.example.demo.service.impl;

import com.example.demo.entity.Asset;
import com.example.demo.entity.TransferRecord;
import com.example.demo.entity.User;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.ValidationException;
import com.example.demo.repository.AssetRepository;
import com.example.demo.repository.TransferRecordRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.TransferRecordService;
import java.time.LocalDate;
import java.util.List;

public class TransferRecordServiceImpl implements TransferRecordService {

    private final TransferRecordRepository transferRecordRepository;
    private final AssetRepository assetRepository;
    private final UserRepository userRepository;

    public TransferRecordServiceImpl(TransferRecordRepository transferRecordRepository,
                                     AssetRepository assetRepository,
                                     UserRepository userRepository) {
        this.transferRecordRepository = transferRecordRepository;
        this.assetRepository = assetRepository;
        this.userRepository = userRepository;
    }

    @Override
    public TransferRecord createTransfer(Long assetId, TransferRecord record) {

        Asset asset = assetRepository.findById(assetId)
                .orElseThrow(() -> new ResourceNotFoundException("Asset not found"));

        if (record.getTransferDate().isAfter(LocalDate.now())) {
            throw new ValidationException("Transfer date cannot be in the future");
        }

        User admin = userRepository.findById(record.getApprovedBy().getId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        record.setId(null);
        record.setApprovedBy(admin);
        record = transferRecordRepository.save(
                new TransferRecord(
                        null,
                        asset,
                        record.getFromDepartment(),
                        record.getToDepartment(),
                        record.getTransferDate(),
                        admin
                )
        );

        asset.setStatus("TRANSFERRED");
        assetRepository.save(asset);

        return record;
    }

    @Override
    public List<TransferRecord> getTransfersForAsset(Long assetId) {
        return transferRecordRepository.findByAsset_Id(assetId);
    }
}
