package com.lhh.amazon.service;

import java.util.List;

import com.lhh.amazon.common.ServiceException;
import com.lhh.amazon.entity.Comment;

public interface ICommentService {
	// 创建一条留言
	public Comment createComment(Comment comment) throws ServiceException;

	// 显示全部的留言信息
	public List<Comment> allComment(Comment comment) throws ServiceException;

	// List<Comment> allComment(Comment comment) throws ServiceException;
}
