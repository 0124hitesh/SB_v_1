package com.example.JPA_TUT.JPA_TUT;

import com.example.JPA_TUT.JPA_TUT.Repositories.ProductRepository;
import com.example.JPA_TUT.JPA_TUT.entities.ProductEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class JpaTutApplicationTests {

	@Autowired
	ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testRepository() {
		ProductEntity productEntity = ProductEntity.builder()
				.sku("nestle234")
				.title("Nestle Chocolate")
				.price(BigDecimal.valueOf(123.45))
				.quantity(12)
				.build();
		ProductEntity savedProductEntity = productRepository.save(productEntity);
		System.out.println(savedProductEntity);
	}

	@Test
	void getRepository() {
//		List<ProductEntity> entities = productRepository.findAll();
//		List<ProductEntity> entities = productRepository.findByCreatedAtAfter(LocalDateTime.of(2024, 1, 1, 0, 0, 0));
		List<ProductEntity> entities = productRepository.findByQuantityAndPrice(12, BigDecimal.valueOf(123.45));

		System.out.println(entities);
	}

	@Test
	void getSingleFromRepository() {
		Optional<ProductEntity> productEntity = productRepository
				.findByTitleAndPrice("Peps", BigDecimal.valueOf(14.4));
		productEntity.ifPresent(System.out::println);
	}

}
