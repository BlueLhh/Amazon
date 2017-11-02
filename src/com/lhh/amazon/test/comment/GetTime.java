package com.lhh.amazon.test.comment;

import java.util.Date;

/**
 * 获取时间测试
 * @author 46512
 *
 */
public class GetTime {
	public static void main(String[] args) {
		System.out.println("获取系统时间");
		//设置格式
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date time = new Date();
//		String getTime = sdf.format(time);
//		Date dd=null;
//		try {
//			dd = sdf.parse(getTime);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		System.out.println(time);
//		System.out.println(getTime);
//		System.out.println("dd="+dd);
	}
}
