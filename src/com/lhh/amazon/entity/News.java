package com.lhh.amazon.entity;

import java.util.Date;

/**
 * 
 * 最新通知
 * 
 * @author 46512
 *
 */
public class News {
	private Long newsID;// 通知ID
	private String title;// 通知主题
	private String content;// 通知内容
	private Date createTime;// 创建通知的时间

	public News(Long newsID, String title, String content, Date createTime) {
		super();
		this.newsID = newsID;
		this.title = title;
		this.content = content;
		this.createTime = createTime;
	}

	public News() {
		super();
	}

	public Long getNewsID() {
		return newsID;
	}

	public void setNewsID(Long newsID) {
		this.newsID = newsID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	@Override
	public String toString() {
		return "News [newsID=" + newsID + ", title=" + title + ", content=" + content + ", createTime=" + createTime
				+ "]";
	}

}
