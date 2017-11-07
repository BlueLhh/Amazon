package com.lhh.amazon.test.cart;

import java.util.List;

import com.lhh.amazon.common.ServiceException;
import com.lhh.amazon.entity.Cart;
import com.lhh.amazon.entity.Product;
import com.lhh.amazon.service.ICartService;
import com.lhh.amazon.service.IProductService;
import com.lhh.amazon.service.impl.CartServiceImpl;
import com.lhh.amazon.service.impl.ProductServicempl;

/**
 * 获取总额测试
 * 
 * @author 46512
 *
 */
public class GetCost {
	public static void main(String[] args) {
		ICartService ics = new CartServiceImpl();
		IProductService ips = new ProductServicempl();
		Long userid = 1004L;
		List<Cart> cList;
		// List<Product> pList = null;
		Product product = null;
		double orderCost = 0;// 订单总额
		// double odtCost = 0;// 子订单金额
		try {
			cList = ics.showCart(userid);
			for (Cart cart : cList) {
				Long pid;
				pid = cart.getProduct().getProductID();
				product = ips.findProduct(pid);
				orderCost += product.getPrice() * cart.getQuantity();
			}
			System.out.println(orderCost);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
}
