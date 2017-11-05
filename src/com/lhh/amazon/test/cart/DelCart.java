package com.lhh.amazon.test.cart;

import com.lhh.amazon.common.ServiceException;
import com.lhh.amazon.service.ICartService;
import com.lhh.amazon.service.impl.CartServiceImpl;

/**
 * 删除购物车
 * 
 * @author 46512
 *
 */
public class DelCart {
	public static void main(String[] args) {
		ICartService ics = new CartServiceImpl();
		Long id = 1L;
		Long userid = 2L;
		try {
			ics.deleteCart(id);
			ics.deleteAllCart(userid);
			System.out.println("删除成功！");
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
}
