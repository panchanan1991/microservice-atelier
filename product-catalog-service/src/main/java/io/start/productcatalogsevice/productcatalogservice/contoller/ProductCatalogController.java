package io.start.productcatalogsevice.productcatalogservice.contoller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.start.productcatalogsevice.productcatalogservice.model.CatalogModel;
import io.start.productcatalogsevice.productcatalogservice.service.ProductCatalogService;

/**
 * @author Panchanan
 *
 */
@RestController
@RequestMapping("/productcatalog")
public class ProductCatalogController {
	
	@Autowired
	ProductCatalogService productCatalogService;
	
	/**
	 * @param id
	 * @return CatalogModel
	 */
	Logger Log = LoggerFactory.getLogger(ProductCatalogController.class);
	
	@GetMapping("/{id}")
	public ResponseEntity<CatalogModel> getProductCatalogDetails(@PathVariable("id") String id) {
		
		CatalogModel catalogModel = null;
		Log.debug("Inside class ProductCatalogController method getProductCatalogDetails ");
		catalogModel = productCatalogService.getPoductNRatingDetails(catalogModel, id);
		
		if(null==catalogModel || null==catalogModel.getProductId()) {
			Log.error("Null Response returning");
			return new ResponseEntity<>(catalogModel, HttpStatus.OK);
		} else {
			Log.debug("Succesfull response returning");
			return new ResponseEntity<>(catalogModel, HttpStatus.OK);
		}
	}

}
