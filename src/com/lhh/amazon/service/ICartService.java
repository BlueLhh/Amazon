package com.lhh.amazon.service;

import com.lhh.amazon.common.ServiceException;
import com.lhh.amazon.entity.Cart;

public interface ICartService {
	// 创建一个购物车
	public Cart createCart(Cart cart) throws ServiceException;

	// 删除购物车
	public void deleteCart(Long id) throws ServiceException;
}
