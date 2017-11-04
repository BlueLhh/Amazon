package com.lhh.amazon.test.product;

import java.util.ArrayList;
import java.util.List;

import com.lhh.amazon.common.ServiceException;
import com.lhh.amazon.entity.Product;
import com.lhh.amazon.service.IProductService;
import com.lhh.amazon.service.impl.ProductServicempl;

/**
 * 按照指定查询第几页
 * 
 * @author 46512
 *
 */
public class GetPage {
	public static void main(String[] args) {
		IProductService ips = new ProductServicempl();
		// Long id = 22L;
		// 写条件
		List<String> conditions = new ArrayList<String>();
		int page = 6;
		List<Product> list;

		try {
			list = ips.showProduct(conditions, page);
			page = ips.totalPage(conditions);
			// 显示第一页的商品
			for (Product product : list) {
				System.out.println(product);
			}
			System.out.println("一共有：" + page + "页");
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
}
