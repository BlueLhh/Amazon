package com.lhh.amazon.test.cart;

import java.util.List;

import com.lhh.amazon.common.ServiceException;
import com.lhh.amazon.entity.Cart;
import com.lhh.amazon.service.ICartService;
import com.lhh.amazon.service.impl.CartServiceImpl;

/**
 * 根据用户的ID和商品ID来进行查询购物车内的信息
 * 
 * @author 46512
 *
 */
public class FindCartTest {
	public static void main(String[] args) {
		Long pid = 2L;
		Long userid = 1004L;
		ICartService ics = new CartServiceImpl();
		// 初始化不存在
		boolean isExisted = false;
		try {
			isExisted = ics.checkCart(pid, userid);
			if (isExisted) {
				System.out.println("存在");
				List<Cart> list;
				list = ics.showCart(userid);
				for (Cart cart : list) {
					System.out.println(cart);
				}
			} else {
				System.out.println("不存在！");
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
}
