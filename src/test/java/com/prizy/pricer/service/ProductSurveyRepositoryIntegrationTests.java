package com.prizy.pricer.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.prizy.pricer.app.ApplicationEntry;
import com.prizy.pricer.entity.ProductSurvey;
import com.prizy.pricer.repository.ProductSurveyRepository;

import java.math.BigDecimal;
import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ApplicationEntry.class)
@ContextConfiguration
public class ProductSurveyRepositoryIntegrationTests {

	@Autowired
    ProductSurveyRepository repository;

	 @Test
    public void saveProductSurvey(){
        ProductSurvey survey = new ProductSurvey();
        survey.setProductId(1l);
        survey.setStoreName("Store 1");
        survey.setPrice(new BigDecimal(33.5));

        ProductSurvey savedSurvey = repository.save(survey);

        assertThat(savedSurvey.getProductSurveyId(), notNullValue());
        assertThat(savedSurvey.getProductId(), is(equalTo(survey.getProductId())));
        assertThat(savedSurvey.getStoreName(), is(equalTo(survey.getStoreName())));

    }
	
    @Test
    public void getProductById(){
        Optional<ProductSurvey> productSurvey = repository.findById(Long.valueOf(11l));
        assertTrue(productSurvey.isPresent());
        assertThat(productSurvey.get().getProductSurveyId(), is(equalTo(11l)));
        assertThat(productSurvey.get().getProductId(), is(equalTo(2l)));
    }


}
