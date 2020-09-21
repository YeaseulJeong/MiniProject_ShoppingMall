package ShoppingMall.VO;

public class Product {
	
	private String productName;
	private String productId;
	private int productPrice;
	
	
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	
	@Override
	public String toString() {
		return "Product [productName=" + productName + ", productId=" + productId + "]";
	}
	
	

}
