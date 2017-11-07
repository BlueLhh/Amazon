package com.lhh.amazon.test.orderDetail;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.lhh.amazon.common.ServiceException;
import com.lhh.amazon.entity.Cart;
import com.lhh.amazon.entity.Order;
import com.lhh.amazon.entity.OrderDetail;
import com.lhh.amazon.entity.Product;
import com.lhh.amazon.service.ICartService;
import com.lhh.amazon.service.IOrderDetailService;
import com.lhh.amazon.service.IOrderService;
import com.lhh.amazon.service.IProductService;
import com.lhh.amazon.service.impl.CartServiceImpl;
import com.lhh.amazon.service.impl.OrderDetailServiceImpl;
import com.lhh.amazon.service.impl.OrderServiceImpl;
import com.lhh.amazon.service.impl.ProductServicempl;

/**
 * 测试
 * 
 * @author 46512
 *
 */
public class AddOrderAndODT {
	public static void main(String[] args) {
		ICartService ics = new CartServiceImpl();
		IProductService ips = new ProductServicempl();
		IOrderService ios = new OrderServiceImpl();
		Order order = new Order();
		Long userid = 1004L;
		List<Cart> cList;
		// List<Product> pList = null;
		Product product = null;
		double orderCost = 0;// 订单总额
		double odtCost = 0;// 子订单金额
		try {
			// 遍历查询购物车 通过当前用户的ID进行查询
			cList = ics.showCart(userid);
			for (Cart cart : cList) {
				// 商品的ID
				Long pid;
				pid = cart.getProduct().getProductID();
				// 通过商品的ID进行查找该商品
				product = ips.findProduct(pid);
				// 获取该购物车内的商品的总价
				orderCost += product.getPrice() * cart.getQuantity();
			}
			System.out.println("订单总额为：" + orderCost);
			// 获取时间戳作为订单的ID
			Date time = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			Long orderid = Long.parseLong(sdf.format(time));
			String username = "1234";
			String userAddress = "北海";
			int status = 1;
			int type = 1;
			// 开始添加订单
			order.setOrderID(orderid);
			order.getUser().setUserID(userid);
			order.setUsername(username);
			order.setUserAddress(userAddress);
			order.setCreateTime(time);
			order.setCost(orderCost);
			order.setStatus(status);
			order.setType(type);
			// 执行添加订单
			ios.creatOrder(order);
			System.out.println("添加订单成功！");

			// 添加到子订单
			for (Cart cart : cList) {
				Long pid;
				int quantity;// 商品的数量
				// 商品订单
				pid = cart.getProduct().getProductID();
				product = ips.findProduct(pid);
				quantity = cart.getQuantity();
				odtCost = product.getPrice() * quantity;
				// 开始添加子订单
				IOrderDetailService ids = new OrderDetailServiceImpl();
				OrderDetail orderDetail = new OrderDetail();
				orderDetail.getOrder().setOrderID(orderid);
				orderDetail.getProduct().setProductID(pid);
				orderDetail.setQuantity(quantity);
				orderDetail.setCost(odtCost);
				ids.creatOD(orderDetail);
				System.out.println("添加子订单成功！");
			}
			System.out.println("----到这里是完成订单的结算，开始更改商品的库存----");
			for (Cart cart : cList) {
				Long pid;
				@SuppressWarnings("unused")
				int quantity;// 购物车商品的数量
				int stock;// 库存
				// 商品订单ID
				pid = cart.getProduct().getProductID();
				// 购买的商品的数量
				quantity = cart.getQuantity();
				// 查询商品
				product = ips.findProduct(pid);
				// 用商品的库存减去购物车内的数量
				stock = product.getStock() - cart.getQuantity();
				// 根据商品的ID进行库存的修改
				ips.updateStock(pid, stock);
			}
			System.out.println("更新商品库存成功！");
			System.out.println("----完成所有订单结算，删除购物车内的信息----");
			ics.deleteAllCart(userid);
			System.out.println("----这里是最后的部分了----结算购物车完成----");
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
}
