
package com.prizy.pricer.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.prizy.pricer.entity.ProductSurvey;

import java.math.BigDecimal;
import java.util.List;

@Repository
@RestResource(path="productSurvey")
public interface ProductSurveyRepository extends CrudRepository<ProductSurvey, Long> {

    @Query("select pl.price from ProductSurvey pl where pl.product.barcode = ?1")
    List<BigDecimal> getPrice(String barcode);

}
