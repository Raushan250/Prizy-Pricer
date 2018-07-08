package com.prizy.pricer.service;

import org.springframework.stereotype.Service;

import com.prizy.pricer.dto.ProductPriceDetail;
import com.prizy.pricer.entity.Product;

@Service
public interface ProductPriceDetailService {
	
    ProductPriceDetail getProductPriceDetail(String barcode);
    
    Product  createProduct(String barcode, String price,String storeName);
    
    ProductPriceDetail storePrice(String barcode,String price,String storeName);


}
