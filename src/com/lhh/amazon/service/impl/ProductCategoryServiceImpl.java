package com.lhh.amazon.service.impl;

import java.sql.Connection;
import java.util.List;

import com.lhh.amazon.common.ConnectionFactory;
import com.lhh.amazon.common.DBUtils;
import com.lhh.amazon.common.DataAccessException;
import com.lhh.amazon.common.ServiceException;
import com.lhh.amazon.dao.IProductCategoryDao;
import com.lhh.amazon.dao.impl.ProductCategoryDaoImpl;
import com.lhh.amazon.entity.ProductCategory;
import com.lhh.amazon.service.IProductCategoryService;

public class ProductCategoryServiceImpl implements IProductCategoryService {

	private IProductCategoryDao dao;

	public ProductCategoryServiceImpl() {
		dao = new ProductCategoryDaoImpl();
	}

	@Override
	public List<ProductCategory> findCategory() throws ServiceException {

		Connection conn;
		List<ProductCategory> list;
		conn = ConnectionFactory.getConnection();
		try {
			//list = dao.select(conn);
			list = dao.bestSelect(conn);
		} catch (DataAccessException e) {
			throw new ServiceException("显示失败！");
		} finally {
			DBUtils.close(null, null, conn);
		}
		return list;
	}
}
