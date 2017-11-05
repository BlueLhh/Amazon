package com.lhh.amazon.test.cart;

import java.util.List;

import com.lhh.amazon.common.ServiceException;
import com.lhh.amazon.entity.Cart;
import com.lhh.amazon.service.ICartService;
import com.lhh.amazon.service.impl.CartServiceImpl;

/**
 * 
 * 查询购物车内的信息
 * 
 * @author 46512
 *
 */
public class FindCart {
	public static void main(String[] args) {
		ICartService ics = new CartServiceImpl();
		List<Cart> list;
		Long userid = 1L;
		try {
			list = ics.showCart(userid);
			for (Cart cart : list) {
				System.out.println(cart);
			}
			System.out.println("一共有：" + list.size() + "条记录");
			System.out.println("数量：" + list.get(0).getQuantity());
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
}
