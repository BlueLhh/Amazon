package com.lhh.amazon.service.impl;

import com.lhh.amazon.common.ServiceException;
import com.lhh.amazon.entity.Cart;
import com.lhh.amazon.service.ICartService;

public class CartServiceImpl implements ICartService {

	// 创建一个购物车
	@Override
	public Cart createCart(Cart cart) throws ServiceException {
		return null;
	}

	// 结算账单之后删除购物车
	@Override
	public void deleteCart(Long id) throws ServiceException {

	}

}
