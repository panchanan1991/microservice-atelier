package io.start.productratingservice.productratingservice.contoller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.start.productratingservice.productratingservice.model.ProductRatingModel;
import io.start.productratingservice.productratingservice.service.ProductRatingService;

/**
 * This is the rest controller of product rating service 
 * @author Panchanan
 *
 */
@RestController
@RequestMapping("/productrating")
public class ProductRatingController {
	
	@Autowired
	ProductRatingService productRatingService;
	
	Logger Log = LoggerFactory.getLogger(ProductRatingController.class);
	
	/**
	 * This method is rest API to Get product rating details like product name, product Details
	 * @param id
	 * @return ProductRatingModel
	 */
	@GetMapping("/{id}")
	public ProductRatingModel getProductRating(@PathVariable("id") String id) {
		
		Log.debug("Inside class ProductRatingController metod  getProductRating");
		
		return productRatingService.getProductRating(id);
		
	}

}
