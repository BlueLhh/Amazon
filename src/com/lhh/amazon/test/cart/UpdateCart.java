package com.lhh.amazon.test.cart;

import com.lhh.amazon.common.ServiceException;
import com.lhh.amazon.service.ICartService;
import com.lhh.amazon.service.impl.CartServiceImpl;

/**
 * 更新购物车
 * 
 * @author 46512
 *
 */
public class UpdateCart {
	public static void main(String[] args) {
		ICartService ics = new CartServiceImpl();
		Long pid = 1L;
		Long userid = 1L;
		int quantity = 50;

		try {
			// 在商品添加的时候使用
			// ics.updateCart(pid, userid, quantity);
			ics.updateCart(2L, quantity);
			System.out.println("更新成功！");
			System.out.println(pid);
			System.out.println(userid);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
}
