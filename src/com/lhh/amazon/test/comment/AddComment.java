package com.lhh.amazon.test.comment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.lhh.amazon.common.ServiceException;
import com.lhh.amazon.entity.Comment;
import com.lhh.amazon.service.ICommentService;
import com.lhh.amazon.service.impl.CommentServiceImpl;

/**
 * 
 * 测试增加留言
 * 
 * @author 46512
 *
 */
public class AddComment {
	public static void main(String[] args) {
		String reply;// 回复内容
		String content;// 评论内容
		Date createTime = null;// 创建评论的时间
		Date replyTime = null;// 回复评论的时间
		String nickname;// 昵称
		String state;// 状态

		// 强转时间格式
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("回复内容：");
		reply = sc.next();
		System.out.println("评论内容：");
		content = sc.next();
		System.out.println("创建时间：");
		String str1 = sc.next();
		System.out.println("回复时间：");
		String str2 = sc.next();
		System.out.println("留言昵称：");
		nickname = sc.next();
		System.out.println("状态：");
		state = sc.next();

		try {
			createTime = format.parse(str1);
			replyTime = format.parse(str2);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		ICommentService commentService = new CommentServiceImpl();
		Comment comment = new Comment();
		
		comment.setReply(reply);
		comment.setContent(content);
		comment.setCreateTime(createTime);
		comment.setReplyTime(replyTime);
		comment.setNickname(nickname);
		comment.setState(state);
		
		try {
			commentService.createComment(comment);
			System.out.println("留言成功！");
		} catch (ServiceException e) {
			e.printStackTrace();
		}

	}
}
