package com.inditex.general.persistence.mapper;

import com.inditex.general.dto.PriceDTO;
import com.inditex.general.persistence.entity.Price;

import java.util.Objects;

public interface PriceMapper {

    static PriceDTO toDTO(Price price) {
        PriceDTO dto = new PriceDTO();
        if (Objects.nonNull(price)) {
            dto.setPrice(price.getPrice());
            dto.setPriceList(price.getPriceList());
            dto.setBrandId(price.getBrandId());
            dto.setStartDate(price.getStartDate());
            dto.setEndDate(price.getEndDate());
            dto.setProductId(price.getProductId());
        }
        return dto;
    }

    static Price toEntity(PriceDTO dto) {
        if (dto == null) {
            return null;
        }

        Price price = new Price();
        price.setPrice(dto.getPrice());
        price.setPriceList(dto.getPriceList());
        price.setBrandId(dto.getBrandId());
        price.setStartDate(dto.getStartDate());
        price.setEndDate(dto.getEndDate());
        price.setProductId(dto.getProductId());

        return price;
    }


}


