package com.lhh.amazon.test.product;

import java.util.List;

import com.lhh.amazon.common.ServiceException;
import com.lhh.amazon.entity.Product;
import com.lhh.amazon.service.IProductService;
import com.lhh.amazon.service.impl.ProductServicempl;

public class FindProduct {
	public static void main(String[] args) {
		IProductService ips = new ProductServicempl();
		Product product = new Product();
		List<Product> list;
		try {
			product = ips.findProduct(1L);
			System.out.println(product);
			list = ips.allProduct();
			for (Product prod : list) {
				System.out.println(prod);
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
}
