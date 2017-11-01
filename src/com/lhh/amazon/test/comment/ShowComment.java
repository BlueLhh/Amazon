package com.lhh.amazon.test.comment;

import java.util.List;

import com.lhh.amazon.common.ServiceException;
import com.lhh.amazon.entity.Comment;
import com.lhh.amazon.service.ICommentService;
import com.lhh.amazon.service.impl.CommentServiceImpl;

/**
 * 
 * 测试显示留言
 * 
 * @author 46512
 *
 */
public class ShowComment {
	public static void main(String[] args) {
		ICommentService commentService = new CommentServiceImpl();
		Comment comment = new Comment();
		List<Comment> list = null;
		try {
			list = commentService.allComment(comment);
			for (Comment comm : list) {
				System.out.println(comm);
			}
			
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
}
