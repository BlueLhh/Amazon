package com.lhh.amazon.service.impl;

import java.sql.Connection;
import java.util.List;

import com.lhh.amazon.common.ConnectionFactory;
import com.lhh.amazon.common.DBUtils;
import com.lhh.amazon.common.DataAccessException;
import com.lhh.amazon.common.ServiceException;
import com.lhh.amazon.dao.IProductDao;
import com.lhh.amazon.dao.impl.ProductDaoImpl;
import com.lhh.amazon.entity.Product;
import com.lhh.amazon.service.IProductService;

public class ProductServicempl implements IProductService {

	private IProductDao dao;

	public ProductServicempl() {
		dao = new ProductDaoImpl();
	}

	@Override
	public List<Product> allProduct() throws ServiceException {

		Connection conn;
		List<Product> list;
		conn = ConnectionFactory.getConnection();
		try {
			list = dao.select(conn);
		} catch (DataAccessException e) {
			throw new ServiceException("显示失败！");
		} finally {
			DBUtils.close(null, null, conn);
		}
		return list;
	}

	@Override
	public Product findProduct(Long id) throws ServiceException {
		Connection conn;
		Product product = new Product();
		conn = ConnectionFactory.getConnection();
		try {
			product = dao.select(id, conn);
		} catch (DataAccessException e) {
			throw new ServiceException("查找失败！");
		} finally {
			DBUtils.close(null, null, conn);
		}
		return product;
	}
}
