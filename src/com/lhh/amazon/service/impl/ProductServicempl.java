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

	// 条件分页查询
	@Override
	public List<Product> showProduct(List<String> condition, int page) throws ServiceException {

		List<Product> list;
		Connection conn;

		conn = ConnectionFactory.getConnection();

		try {
			list = dao.select(condition, page, conn);
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new ServiceException("分页失败！");
		} finally {
			DBUtils.close(null, null, conn);
		}

		return list;
	}

	// 获取总数
	@Override
	public int totalPage(List<String> condition) throws ServiceException {
		List<Product> list;
		Connection conn;
		int totalPageNull = 0;
		conn = ConnectionFactory.getConnection();
		try {
			// 条件查询 分类
			list = dao.select(condition, conn);

			totalPageNull = list.size() % 12 == 0 ? list.size() / 12 : list.size() / 12 + 1;

		} catch (DataAccessException e) {
			throw new ServiceException("分页失败！");
		} finally {
			DBUtils.close(null, null, conn);
		}
		return totalPageNull;
	}

	@Override
	public List<Product> showProduct(List<String> condition) throws ServiceException {

		Connection conn;
		List<Product> list;

		conn = ConnectionFactory.getConnection();

		try {
			list = dao.select(condition, conn);
		} catch (DataAccessException e) {
			throw new ServiceException("查找失败！");
		} finally {
			DBUtils.close(null, null, conn);
		}

		return list;
	}
}
