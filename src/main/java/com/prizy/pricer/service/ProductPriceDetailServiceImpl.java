package com.prizy.pricer.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prizy.pricer.dto.ProductPriceDetail;
import com.prizy.pricer.entity.Product;
import com.prizy.pricer.entity.ProductSurvey;
import com.prizy.pricer.repository.ProductRepository;
import com.prizy.pricer.repository.ProductSurveyRepository;

@Service
public class ProductPriceDetailServiceImpl implements ProductPriceDetailService {

	@Autowired
	ProductSurveyRepository productSurveyRepository;

	@Autowired
	ProductRepository productRepository;

	@Override
	public ProductPriceDetail getProductPriceDetail(String barcode) {

		ProductPriceService productPriceService = new ProductPriceServiceImpl();
		List<BigDecimal> priceList = productSurveyRepository.getPrice(barcode);

		Collections.sort(priceList);
		BigDecimal idealPrice = productPriceService.calculateProductIdealPrice(priceList);

		ProductPriceDetail productPriceDetail = new ProductPriceDetail();

		productPriceDetail.setProduct(productRepository.findByBarcode(barcode));

		productPriceDetail.setIdealPrice(idealPrice);
		productPriceDetail.setAveragePrice(productPriceService.calculateAveragePrice(priceList));
		productPriceDetail.setLowestPrice(productPriceService.calculateLowestPrice(priceList));
		productPriceDetail.setHighestPrice(productPriceService.calculateHighestPrice(priceList));

		return productPriceDetail;
	}

	@Override
	public Product createProduct(String barcode, String price, String storeName) {

		Product product = new Product();
		product.setBarcode(barcode);
		product.setName("New Product");
		product = productRepository.save(product);

		ProductSurvey productSurvery = new ProductSurvey();
		productSurvery.setPrice(new BigDecimal(price));
		productSurvery.setProductId(product.getProductId());
		productSurvery.setStoreName(storeName);
		productSurvery.setProduct(product);
		productSurveyRepository.save(productSurvery);
		return product;
	}

	@Override
	public ProductPriceDetail storePrice(String barcode, String price, String storeName) {

		Product product = productRepository.findByBarcode(barcode);

		ProductSurvey productSurvey = new ProductSurvey();
		productSurvey.setPrice(new BigDecimal(price));
		productSurvey.setProductId(product.getProductId());
		productSurvey.setProduct(product);
		productSurvey.setStoreName(storeName);
		return getProductPriceDetail(barcode);
	}

}
