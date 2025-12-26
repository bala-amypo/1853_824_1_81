package com.example.demo.repository;

import com.example.demo.entity.Asset;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssetRepository extends JpaRepository<Asset, Long> {

    Optional<Asset> findById(Long id);

    List<Asset> findByStatus(String status);
}
