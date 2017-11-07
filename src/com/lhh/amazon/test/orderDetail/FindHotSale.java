package com.lhh.amazon.test.orderDetail;

import java.util.List;

import com.lhh.amazon.common.ServiceException;
import com.lhh.amazon.entity.HotSale;
import com.lhh.amazon.service.IOrderDetailService;
import com.lhh.amazon.service.impl.OrderDetailServiceImpl;

/**
 * 销量测试
 * 
 * @author 46512
 *
 */
public class FindHotSale {
	public static void main(String[] args) {
		IOrderDetailService iods = new OrderDetailServiceImpl();
		List<HotSale> list = null;
		try {
			list = iods.hotSale();
			for (HotSale hotSale : list) {
				System.out.println(hotSale.getList().get(0).getProductID());
			}
			// System.out.println(list.get(0).getList().get(0).getProductID());
			// for (int i = 0; i < list.size(); i++) {
			// System.out.println(list.get(i).getList());
			// }
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
}
