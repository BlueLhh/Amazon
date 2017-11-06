package com.lhh.amazon.test.product;

import java.util.ArrayList;
import java.util.List;

import com.lhh.amazon.common.ServiceException;
import com.lhh.amazon.entity.Cart;
import com.lhh.amazon.entity.Product;
import com.lhh.amazon.service.ICartService;
import com.lhh.amazon.service.IProductService;
import com.lhh.amazon.service.impl.CartServiceImpl;
import com.lhh.amazon.service.impl.ProductServicempl;

/**
 * 通过用户查询购物车的信息 再获取商品的ID
 * 
 * @author 46512
 *
 */
public class FindProductTest {
	public static void main(String[] args) {
		Long userid = 1004L;
		ICartService ics = new CartServiceImpl();
		IProductService ips = new ProductServicempl();
		//Product product = new Product();
		//List<String> conditions = new ArrayList<String>();
		List<Product> pList = new ArrayList<Product>();
		Product pdt = null;
		List<Cart> cList;
		try {
			cList = ics.showCart(userid);
			for (Cart cart : cList) {
				System.out.println(cart);
				Long id = cart.getProductID();
				pdt = ips.findProduct(id);
				pList.add(pdt);
//				List<String> conditions = new ArrayList<String>();
//				conditions.add("hp_id = " + id);
//				pList = ips.showProduct(conditions);
//				for (Product product : pList) {
//					System.out.println(product);
//				}
			}
			//System.out.println(pdt);
			for (Product product : pList) {
				System.out.println(product);
			}
			System.out.println(pList.get(1).getProductID());
			//System.out.println("pid:"+pList.get(0).getProductID());
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
}
