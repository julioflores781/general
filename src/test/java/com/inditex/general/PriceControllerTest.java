package com.inditex.general;

import com.inditex.general.dto.PriceDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PriceControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    Long productId = 35455L;
    int brandId = 1;

    @Test
    @DisplayName("Test 1: petición a las 10:00 del día 14 del producto 35455   para la brand 1 (ZARA)")
    public void testConsulta10AM14DProducto35455Marca1() {
        LocalDateTime date = LocalDateTime.parse("2020-06-14T10:00:00");

        ResponseEntity<PriceDTO> responseEntity = getPriceDTOResponseEntity(date);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(responseEntity.getBody().getPrice(), 35.5);
        System.out.println("Test 1: petición a las 10:00 del día 14 del producto 35455   para la brand 1 (ZARA) Price= " + responseEntity.getBody().getPrice());

    }

    @Test
    @DisplayName("Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)")
    public void testConsulta16AM14DProducto35455Marca1() {
        LocalDateTime date = LocalDateTime.parse("2020-06-14T16:00:00");

        ResponseEntity<PriceDTO> responseEntity = getPriceDTOResponseEntity(date);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(responseEntity.getBody().getPrice(), 25.45);
        System.out.println("Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA) Price= " + responseEntity.getBody().getPrice());

    }

    @Test
    @DisplayName("Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)")
    public void testConsulta21AM14DProducto35455Marca1() {
        LocalDateTime date = LocalDateTime.parse("2020-06-14T21:00:00");

        ResponseEntity<PriceDTO> responseEntity = getPriceDTOResponseEntity(date);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(responseEntity.getBody().getPrice(), 35.5);
        System.out.println("Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA) Price= " + responseEntity.getBody().getPrice());

    }

    @Test
    @DisplayName("Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)")
    public void testConsulta10AM16DProducto35455Marca1() {
        LocalDateTime date = LocalDateTime.parse("2020-06-15T10:00:00");

        ResponseEntity<PriceDTO> responseEntity = getPriceDTOResponseEntity(date);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(responseEntity.getBody().getPrice(), 30.5);
        System.out.println("Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA) Price= " + responseEntity.getBody().getPrice());

    }


    @Test
    @DisplayName("Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)")
    public void testConsulta21AM16DProducto35455Marca1() {
        LocalDateTime date = LocalDateTime.parse("2020-06-16T21:00:00");

        ResponseEntity<PriceDTO> responseEntity = getPriceDTOResponseEntity(date);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(responseEntity.getBody().getPrice(), 38.95);
        System.out.println("Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA) Price= " + responseEntity.getBody().getPrice());

    }


    private ResponseEntity<PriceDTO> getPriceDTOResponseEntity(LocalDateTime date) {
        ResponseEntity<PriceDTO> responseEntity = restTemplate.exchange(
                "/prices?date={date}&productId={productId}&brand={brandId}",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<PriceDTO>() {
                },
                date, productId, brandId
        );
        return responseEntity;
    }
}
