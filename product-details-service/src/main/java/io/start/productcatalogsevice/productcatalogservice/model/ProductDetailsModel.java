package io.start.productcatalogsevice.productcatalogservice.model;

/**
 * @author Panchanan
 * This is pojo class which contains productId, Product Details, ProductName
 */
public class ProductDetailsModel {
	
	private String productId;
	private String productDetails;
	private String name;
	
	public ProductDetailsModel() {
		super();
	}
	
	
	public ProductDetailsModel(String productId, String productDetails, String name) {
		super();
		this.productId = productId;
		this.productDetails = productDetails;
		this.name = name;
	}


	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductDetails() {
		return productDetails;
	}

	public void setProductDetails(String productDetails) {
		this.productDetails = productDetails;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
