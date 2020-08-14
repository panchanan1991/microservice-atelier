package io.start.productdetailsservice.productdetailsservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.start.productdetailsservice.productdetailsservice.business.ProductDetialsBusiness;
import io.start.productdetailsservice.productdetailsservice.controller.ProductDetailsController;
import io.start.productdetailsservice.productdetailsservice.model.ProductDetailsModel;
import io.start.productdetailsservice.productdetailsservice.model.ProductDetailsModelTO;

/**
 * @author Panchanan
 * This class is service class of the product details service
 *
 */
@Service
@RefreshScope
public class ProductDetailsService {
	
	@Value("${api.key}")
	private String apikey;
	
	@Autowired
	ProductDetialsBusiness productDetialsBusiness;
	
	Logger Log = LoggerFactory.getLogger(ProductDetailsService.class);
	
	RestTemplate restTemplate = new RestTemplate();
	
	public ProductDetailsModel getProductDetials(String id) {
		
		Log.debug("Inside class ProductDetialsBusiness method getProductDetials ");
		ProductDetailsModelTO productDetailsModel=null;
		Log.debug("The url is -- https://api.themoviedb.org/3/movie/"+id+"?api_key="+apikey+" for the external API call");
		try {
			
			productDetailsModel = restTemplate.getForObject(
					"https://api.themoviedb.org/3/movie/"+id+"?api_key="+apikey,
					ProductDetailsModelTO.class);
		} catch(Exception e) {
			Log.error("Getting exception while calling external API :: "+e.getMessage());
		}
		return productDetialsBusiness.getProductDetails(productDetailsModel);
	}

}
