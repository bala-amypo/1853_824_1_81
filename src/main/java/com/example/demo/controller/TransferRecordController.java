package com.example.demo.controller;

import com.example.demo.entity.TransferRecord;
import com.example.demo.service.TransferRecordService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/transfers")
public class TransferRecordController {

    private final TransferRecordService transferRecordService;

    public TransferRecordController(TransferRecordService transferRecordService) {
        this.transferRecordService = transferRecordService;
    }

    @PostMapping("/asset/{assetId}")
    public ResponseEntity<TransferRecord> createTransfer(@PathVariable Long assetId,
                                                         @RequestBody TransferRecord record) {
        return ResponseEntity.ok(
                transferRecordService.createTransfer(assetId, record)
        );
    }

    @GetMapping("/asset/{assetId}")
    public ResponseEntity<List<TransferRecord>> getTransfers(@PathVariable Long assetId) {
        return ResponseEntity.ok(
                transferRecordService.getTransfersForAsset(assetId)
        );
    }
}
