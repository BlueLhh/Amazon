package com.lhh.amazon.test.cart;

import com.lhh.amazon.common.ServiceException;
import com.lhh.amazon.entity.Cart;
import com.lhh.amazon.service.ICartService;
import com.lhh.amazon.service.impl.CartServiceImpl;

/**
 * 
 * 新增购物车测试
 * 
 * @author 46512
 *
 */
public class AddCart {
	public static void main(String[] args) {
		ICartService ics = new CartServiceImpl();
		Cart cart = new Cart();
		Long pid = 2L;
		int quantity = 10;
		Long userid = 2L;

		cart.setProductID(pid);
		cart.setQuantity(quantity);
		cart.setUserID(userid);

		try {
			ics.createCart(cart);
			System.out.println("添加成功！");
		} catch (ServiceException e) {
			e.printStackTrace();
		}

	}
}
