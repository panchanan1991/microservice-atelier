package io.start.productdetailsservice.productdetailsservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.start.productdetailsservice.productdetailsservice.business.ProductDetialsBusiness;
import io.start.productdetailsservice.productdetailsservice.model.ProductDetailsModel;
import io.start.productdetailsservice.productdetailsservice.model.ProductDetailsModelTO;
import io.start.productdetailsservice.productdetailsservice.service.ProductDetailsService;

/**
 * @author Panchanan
 *This is the rest controller class for product details service
 */
@RestController
@RequestMapping("/productdetails")
public class ProductDetailsController {
	
	@Autowired
	private ProductDetailsService productDetailsService;
	
	Logger Log = LoggerFactory.getLogger(ProductDetailsController.class);
	
	/**
	 * @param id
	 * @return ProductDetailsModel
	 * This method is rest API to Get product details like product name, product Details
	 */
	@GetMapping("/{id}")
	public ProductDetailsModel getProductDetails(@PathVariable("id") String id) {
		
		Log.debug("Inside class ProductDetailsController method getProductDetails ");
		
		return productDetailsService.getProductDetials(id);
		
	}
}
