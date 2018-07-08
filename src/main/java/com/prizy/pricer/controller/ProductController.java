package com.prizy.pricer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.prizy.pricer.dto.ProductPriceDetail;
import com.prizy.pricer.entity.Product;
import com.prizy.pricer.service.ProductPriceDetailService;

@RestController
@RequestMapping("product")
public class ProductController {

	@Autowired
	ProductPriceDetailService productPriceService;

	@GetMapping("/getProductPriceDetails/{barcode}")
	public ProductPriceDetail getIdealPrice(@PathVariable String barcode) {
		return productPriceService.getProductPriceDetail(barcode);
	}

	@PostMapping("/create/{barcode}/{price}/{storeName}")
	public ResponseEntity<Void> createProduct(@PathVariable String barcode, @PathVariable String price,
			@PathVariable String storeName, UriComponentsBuilder uri) {
		Product product = productPriceService.createProduct(barcode, price, storeName);
		System.out.println("hello");
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri.path("/product?id={id}").buildAndExpand(product.getProductId()).toUri());
		return new ResponseEntity<>(headers, HttpStatus.CREATED);

	}

	@PutMapping("/update/{barcode}/{price}/{storeName}")
	public ResponseEntity<ProductPriceDetail> updateProduct(@PathVariable String barcode, @PathVariable String price,
			String storeName) {

		ProductPriceDetail productPriceDetail = productPriceService.storePrice(barcode, price, storeName);

		return new ResponseEntity<ProductPriceDetail>(productPriceDetail, HttpStatus.OK);
	}

}
