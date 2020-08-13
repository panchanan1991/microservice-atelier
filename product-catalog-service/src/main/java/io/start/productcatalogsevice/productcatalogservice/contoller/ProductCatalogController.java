package io.start.productcatalogsevice.productcatalogservice.contoller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
	public CatalogModel getProductCatalogDetails(@PathVariable("id") String id) {
		
		Log.debug("Inside class ProductCatalogController method getProductCatalogDetails ");
		CatalogModel catalogModel = null;
		
		return productCatalogService.getPoductNRatingDetails(catalogModel, id);
		
	}

}
