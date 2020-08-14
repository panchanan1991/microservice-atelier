package io.start.productcatalogsevice.productcatalogservice.Business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import io.start.productcatalogsevice.productcatalogservice.model.CatalogModel;
import io.start.productcatalogsevice.productcatalogservice.model.ProductDetailsModel;
import io.start.productcatalogsevice.productcatalogservice.model.ProductRatingModel;

/**
 * @author Panchanan
 *
 */
@Component
public class ProductCatalogBusiness {

	Logger Log = LoggerFactory.getLogger(ProductCatalogBusiness.class);
	/**
	 * This is the business method for the product catalog service getPoduct and RatingDetails
	 * @param productDetailsModel
	 * @param productRatingModel
	 * @param catalogModel
	 * @param ProdctId
	 * @return CatalogModel
	 */
	public CatalogModel getPoductNRatingDetails(ProductDetailsModel productDetailsModel,ProductRatingModel productRatingModel, 
			CatalogModel catalogModel, String id) {
		
		Log.debug("inside class ProductCatalogBusiness, method getPoductNRatingDetails");
		 catalogModel = new CatalogModel(); 
		if(null!=productDetailsModel && null!= productDetailsModel.getProductId() &&
				productDetailsModel.getProductId().equals(id)) {
			Log.debug("Product id :: "+productDetailsModel.getProductId());
			catalogModel.setProductId(productDetailsModel.getProductId());
			if(null!=productDetailsModel.getName()) {
				Log.debug("Product name :: "+productDetailsModel.getName());
				catalogModel.setName(productDetailsModel.getName());
			}
			if(null!=productDetailsModel.getProductDetails()) {
				Log.debug("Product details :: "+productDetailsModel.getProductDetails());
				catalogModel.setProductDetails(productDetailsModel.getProductDetails());
			}
			if(null!=productDetailsModel.getRelease_date()) {
				Log.debug("Product release date :: "+productDetailsModel.getRelease_date());
				catalogModel.setRelease_date(productDetailsModel.getRelease_date());
			}
		}
		if(null!=productRatingModel && null!= productDetailsModel.getProductId() &&
				productRatingModel.getProductId().equals(id)) {
			if(null!=productRatingModel.getRating()) {
				Log.debug("product rating out of 10 is "+productRatingModel.getRating());
				catalogModel.setRating(productRatingModel.getRating());
			}
			if(null!=productRatingModel.getCountOfVoters()) {
				Log.debug("numer of user gave rating :: "+productRatingModel.getCountOfVoters());
				catalogModel.setCountOfVoters(productRatingModel.getCountOfVoters());
			}
		}
		if(null!=productRatingModel && null==productDetailsModel.getProductId()) {
			Log.error("Your provided id in url is wrong, please provide a correct id");
			catalogModel.setError("Your provided id in url is wrong, please provide a correct id");
		}
		Log.debug("retuning the object "+catalogModel);
		return catalogModel;
	}

}
