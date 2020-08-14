package io.start.productcatalogsevice.productcatalogservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.start.productcatalogsevice.productcatalogservice.Business.ProductCatalogBusiness;
import io.start.productcatalogsevice.productcatalogservice.model.CatalogModel;
import io.start.productcatalogsevice.productcatalogservice.model.ProductDetailsModel;
import io.start.productcatalogsevice.productcatalogservice.model.ProductRatingModel;

/**
 * @author Panchanan
 *
 */
@Service
@RefreshScope
public class ProductCatalogService {
	

	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	ProductCatalogBusiness productCatalogBusiness;
	
	Logger Log = LoggerFactory.getLogger(ProductCatalogService.class);
	/**
	 * This is the service class of product catalog service, from here the rest api will be called
	 * @param catalogModel
	 * @param id
	 * @return CatalogModel
	 */
	public CatalogModel getPoductNRatingDetails(CatalogModel catalogModel, String id) {

		Log.debug("Inside class ProductCatalogService method getPoductNRatingDetails.");
		ProductDetailsModel productDetailsModel=null;
		ProductRatingModel productRatingModel = null;
		try {
			
			Log.debug("Calling internal api on product-details-service ");
			productDetailsModel = restTemplate.getForObject(
					"http://product-details-service/productdetails/"+id, ProductDetailsModel.class);
			Log.debug("Calling internal api on product-rating-service ");
			productRatingModel = restTemplate.getForObject(
					"http://product-rating-service/productrating/"+id, ProductRatingModel.class);			
		}catch(Exception e) {
			
			Log.error("Getting exception while claiing internal api :: "+e.getMessage());
		}

		return productCatalogBusiness.getPoductNRatingDetails(productDetailsModel, productRatingModel, catalogModel, id);

	}

}
