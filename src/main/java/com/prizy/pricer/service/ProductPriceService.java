package com.prizy.pricer.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface ProductPriceService {
	
    BigDecimal calculateProductIdealPrice(List<BigDecimal> priceList);
    BigDecimal calculateAveragePrice(List<BigDecimal> priceList);
    BigDecimal calculateLowestPrice(List<BigDecimal> priceList);
    BigDecimal calculateHighestPrice(List<BigDecimal> priceList);

}
