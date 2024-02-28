package com.inditex.general.controller;

import com.inditex.general.dto.PriceDTO;
import com.inditex.general.persistence.entity.Price;
import com.inditex.general.service.PriceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/prices")
public class PriceController {


    private static final Logger log = LoggerFactory.getLogger(PriceController.class);

    private final PriceService priceService;

    @Autowired
    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping("/{id:^[+-]?\\d+$}")
    @Operation(summary = "Get price By Id", description = "Gets a price by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Price not found")
    })
    public ResponseEntity<PriceDTO> getById(@PathVariable("id") Long id) {
        log.info("GET /api/prices/" + id);
        return priceService.getById(id)
                .map(price -> new ResponseEntity<>(price, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @Operation(summary = "Get all prices", description = "Gets a list of all prices")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK")
    })
    public ResponseEntity<List<Price>> getAll() {
        log.info("GET /api/prices");
        return new ResponseEntity<>(priceService.getAll(), HttpStatus.OK);
    }


    @GetMapping
    @Operation(summary = "Get price by date and productId and brand orderBy Priority", description = "Get a price by productId and brand and priority  between estarDate and endDate ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Price not found")
    })
    public ResponseEntity<PriceDTO> getFirstByDateAndProductIdAndBrandIdOrderByPriorityDesc(
            @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) @Schema(description = "Date in ISO 8601 format (yyyy-MM-dd'T'HH:mm:ss)", example = "2020-06-14T10:00:00") LocalDateTime date,
            @RequestParam("productId") @Schema(example = "35455") Long productId,
            @RequestParam("brand") @Schema(example = "1") int brand) {
        log.info(" GET /api/prices/?date=" + date + "&" + "?productId=" + productId + "&" + "?brand=" + brand);

        return priceService.findFirstByDateAndProductIdAndBrandIdOrderByPriorityDesc(productId, date, brand)
                .map(price -> new ResponseEntity<>(price, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


}
