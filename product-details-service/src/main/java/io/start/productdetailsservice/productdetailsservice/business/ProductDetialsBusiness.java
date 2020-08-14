package io.start.productdetailsservice.productdetailsservice.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import io.start.productdetailsservice.productdetailsservice.model.ProductDetailsModel;
import io.start.productdetailsservice.productdetailsservice.model.ProductDetailsModelTO;

/**
 * @author Panchanan
 * This class is business class of the product details service
 *
 */
@Component
public class ProductDetialsBusiness {
	
	Logger Log = LoggerFactory.getLogger(ProductDetialsBusiness.class);

	/**
	 * This is business layer method, which will be invoked from service layer
	 * @param productDetailsModel
	 * @return ProductDetailsModel
	 * This method is a business method where the business logic will be written
	 */
	public ProductDetailsModel getProductDetails(ProductDetailsModelTO productDetailsModelTO) {
		
		Log.debug("Inside class ProductDetialsBusiness method getProductDetails");
		return getProduct(productDetailsModelTO);
				
	}

	/**
	 * This method will convert a transfer object to business object
	 * @param productDetailsModelTO
	 * This is a dummy method as no DB is here
	 * @return ProductDetailsModel
	 */
	private ProductDetailsModel getProduct(ProductDetailsModelTO productDetailsModelTO) {
		
		Log.debug("Inside class ProductDetialsBusiness method getProduct");
		ProductDetailsModel productDetailsModel = new ProductDetailsModel();
		
		if(null!=productDetailsModelTO && null!=productDetailsModelTO.getId()) {
			Log.debug("Poduct id : "+productDetailsModelTO.getId());
			productDetailsModel.setProductId(productDetailsModelTO.getId());
			if(null!=productDetailsModelTO.getOverview()) {
				Log.debug("Product Overview :: "+productDetailsModelTO.getOverview());
				productDetailsModel.setProductDetails(productDetailsModelTO.getOverview());
			}
			if(null!=productDetailsModelTO.getOriginal_title()) {
				Log.debug("Poduct Original Title :: "+productDetailsModelTO.getOriginal_title());
				productDetailsModel.setName(productDetailsModelTO.getOriginal_title());
			}
			if(null!=productDetailsModelTO.getRelease_date()) {
				Log.debug("Product release date :: "+productDetailsModelTO.getRelease_date());
				productDetailsModel.setRelease_date(productDetailsModelTO.getRelease_date());
			}
			Log.debug("returning the object with values");
			
			return productDetailsModel;
		}else {
			Log.debug("returning the object without values");
			
			return productDetailsModel;
		}

	}
}
