package io.start.productratingservice.productratingservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.start.productratingservice.productratingservice.business.ProductRatingBusiness;
import io.start.productratingservice.productratingservice.model.ProductRatingModel;
import io.start.productratingservice.productratingservice.model.ProductRatingsModelTO;

/**
 * @author Panchanan
 * This class is Service class of the product rating service
 *
 */
@Service
@RefreshScope
public class ProductRatingService {

	@Value("${api.key}")
	private String apikey;

	@Autowired
	ProductRatingBusiness productRatingBusiness;

	Logger Log = LoggerFactory.getLogger(ProductRatingService.class);

	RestTemplate restTemplate = new RestTemplate();

	public ProductRatingModel getProductRating(String id) {

		Log.debug("Inside class ProductRatingService method getProductRating");
		ProductRatingsModelTO productRatingsModelTO=null;

		Log.debug("The url is -- https://api.themoviedb.org/3/movie/"
				+id+"?api_key="+apikey+" for calling the external rest API");
		try {
			productRatingsModelTO = restTemplate.getForObject(
					"https://api.themoviedb.org/3/movie/"+id+"?api_key="+apikey,
					ProductRatingsModelTO.class);
		} catch (Exception e) {

			Log.error("Getting error, "+e.getMessage());
		}

		return productRatingBusiness.getProductRating(productRatingsModelTO);
	}
}
