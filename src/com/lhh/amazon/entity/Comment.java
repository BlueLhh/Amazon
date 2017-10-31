package com.lhh.amazon.entity;

import java.util.Date;

/**
 * 
 * 评论类
 * 
 * @author 46512
 *
 */
public class Comment {
	private Long commentID;// 评论ID
	private String reply;// 回复内容
	private String content;// 评论内容
	private Date createTime;// 创建评论的时间
	private Date replyTime;// 回复评论的时间
	private String nickname;// 昵称
	private String state;// 状态

	public Comment(Long commentID, String reply, String content, Date createTime, Date replyTime, String nickname,
			String state) {
		super();
		this.commentID = commentID;
		this.reply = reply;
		this.content = content;
		this.createTime = createTime;
		this.replyTime = replyTime;
		this.nickname = nickname;
		this.state = state;
	}

	public Comment() {
		super();
	}

	public Long getCommentID() {
		return commentID;
	}

	public void setCommentID(Long commentID) {
		this.commentID = commentID;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getReplyTime() {
		return replyTime;
	}

	public void setReplyTime(Date replyTime) {
		this.replyTime = replyTime;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
