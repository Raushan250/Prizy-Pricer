package com.prizy.pricer.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.prizy.pricer.app.ApplicationEntry;
import com.prizy.pricer.entity.Product;
import com.prizy.pricer.repository.ProductRepository;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ApplicationEntry.class)
@ContextConfiguration
public class ProductRepositoryIntegrationTests {

	@Autowired
	ProductRepository repository;

	
	@Test
	public void saveProduct() {
		Product product = new Product();
		product.setBarcode("BXXXLL22224L");
		product.setName("Demo Product");

		Product savedProduct = repository.save(product);

		assertThat(savedProduct.getProductId(), notNullValue());
		assertThat(savedProduct.getBarcode(), is(equalTo(product.getBarcode())));
		assertThat(savedProduct.getName(), is(equalTo(product.getName())));

	}
	
	@Test
	public void getProductById() {
		Optional<Product> product = repository.findById(Long.valueOf(1l));
		assertTrue(product.isPresent());
		assertThat(product.get().getProductId(), is(equalTo(1l)));
		assertThat(product.get().getBarcode(), is(equalTo("B12A33")));
	}


}
