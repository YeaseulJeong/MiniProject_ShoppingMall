package ShoppingMall.VO;

import java.util.List;

public class Order {
	
	private int productNum;
	private int orderTotalPrice;
	private List<Product> orderProductList;
	private String customerId;
	
	
	public int addOrder(int num) {
		return productNum += num;
	}
	
	public int minusOrder(int num) {
		return productNum -= num;
	}

	
	public int getProductNum() {
		return productNum;
	}

	public void setProductNum(int productNum) {
		this.productNum = productNum;
	}

	public int getOrderTotalPrice() {
		return orderTotalPrice;
	}

	public void setOrderTotalPrice(int orderTotalPrice) {
		this.orderTotalPrice = orderTotalPrice;
	}

	public List<Product> getOrderProductList() {
		return orderProductList;
	}

	public void setOrderProductList(List<Product> orderProductList) {
		this.orderProductList = orderProductList;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "Order [productNum=" + productNum + ", orderTotalPrice=" + orderTotalPrice + ", orderProductList="
				+ orderProductList + ", customerId=" + customerId + "]";
	}

	
	
	

}
