package com.inditex.general.persistence.repository;

import com.inditex.general.persistence.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PriceRepository extends JpaRepository<Price, Long> {

    Optional<Price> findFirstByProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualAndBrandIdOrderByPriorityDesc(
            Long productId,
            LocalDateTime startDate,
            LocalDateTime endDate,
            int brandId
    );

}
