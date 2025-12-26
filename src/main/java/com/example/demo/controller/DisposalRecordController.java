package com.example.demo.controller;

import com.example.demo.entity.DisposalRecord;
import com.example.demo.service.DisposalRecordService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/disposals")
public class DisposalRecordController {

    private final DisposalRecordService disposalRecordService;

    public DisposalRecordController(DisposalRecordService disposalRecordService) {
        this.disposalRecordService = disposalRecordService;
    }

    @PostMapping("/asset/{assetId}")
    public ResponseEntity<DisposalRecord> createDisposal(@PathVariable Long assetId,
                                                         @RequestBody DisposalRecord record) {
        return ResponseEntity.ok(
                disposalRecordService.createDisposal(assetId, record)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisposalRecord> getDisposal(@PathVariable Long id) {
        return ResponseEntity.ok(disposalRecordService.getDisposal(id));
    }
}
