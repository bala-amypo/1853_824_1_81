package com.example.demo.service.impl;

import com.example.demo.entity.Asset;
import com.example.demo.entity.DisposalRecord;
import com.example.demo.entity.User;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.AssetRepository;
import com.example.demo.repository.DisposalRecordRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.DisposalRecordService;
import java.util.Optional;

public class DisposalRecordServiceImpl implements DisposalRecordService {

    private final DisposalRecordRepository disposalRecordRepository;
    private final AssetRepository assetRepository;
    private final UserRepository userRepository;

    public DisposalRecordServiceImpl(DisposalRecordRepository disposalRecordRepository,
                                     AssetRepository assetRepository,
                                     UserRepository userRepository) {
        this.disposalRecordRepository = disposalRecordRepository;
        this.assetRepository = assetRepository;
        this.userRepository = userRepository;
    }

    @Override
    public DisposalRecord createDisposal(Long assetId, DisposalRecord record) {

        Asset asset = assetRepository.findById(assetId)
                .orElseThrow(() -> new ResourceNotFoundException("Asset not found"));

        User admin = userRepository.findById(record.getApprovedBy().getId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        record.setId(null);
        record.setApprovedBy(admin);
        DisposalRecord saved = disposalRecordRepository.save(
                new DisposalRecord(
                        null,
                        asset,
                        record.getDisposalMethod(),
                        record.getDisposalDate(),
                        admin,
                        record.getNotes(),
                        null
                )
        );

        asset.setStatus("DISPOSED");
        assetRepository.save(asset);

        return saved;
    }

    @Override
    public DisposalRecord getDisposal(Long id) {
        Optional<DisposalRecord> record = disposalRecordRepository.findById(id);
        return record.orElseThrow(
                () -> new ResourceNotFoundException("Disposal record not found")
        );
    }
}
