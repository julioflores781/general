package com.inditex.general.service;

import com.inditex.general.dto.PriceDTO;
import com.inditex.general.persistence.entity.Price;
import com.inditex.general.persistence.mapper.PriceMapper;
import com.inditex.general.persistence.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PriceService {


    private final PriceRepository priceRepository;

    @Autowired
    public PriceService(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    public Optional<PriceDTO> getById(Long id) {
        return priceRepository.findById(id).map(PriceMapper::toDTO);
    }


    public List<Price> getAll() {
        return (List<Price>) priceRepository.findAll();
    }

    public Optional<PriceDTO> findFirstByDateAndProductIdAndBrandIdOrderByPriorityDesc(Long productId, LocalDateTime date, int brandId) {
        return priceRepository
                .findFirstByProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualAndBrandIdOrderByPriorityDesc(productId, date, date, brandId)
                .map(PriceMapper::toDTO);
    }

}