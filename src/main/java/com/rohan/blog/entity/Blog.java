package com.rohan.blog.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.rohan.blog.framework.entity.BaseDO;


/**
 * The persistent class for the BLOG database table.
 * 
 */
@Entity
public class Blog extends BaseDO {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	//@SequenceGenerator(name="BlogSeq",sequenceName="BLOG_SEQ")
	@Column(name="BLOG_ID")
	private long blogId;

	@Column(name="BLOG_CONTENT")
	private String blogContent;

	@Column(name="BLOG_CONTENT_LABLE")
	private String blogContentLable;

    @Temporal( TemporalType.DATE)
	@Column(name="CREATED_DATE")
	private Date createdDate;

    @Temporal( TemporalType.DATE)
	@Column(name="MODIFIED_DATE")
	private Date modifiedDate;

    public Blog() {
    }

	public long getBlogId() {
		return this.blogId;
	}

	public void setBlogId(long blogId) {
		this.blogId = blogId;
	}

	public String getBlogContent() {
		return this.blogContent;
	}

	public void setBlogContent(String blogContent) {
		this.blogContent = blogContent;
	}

	public String getBlogContentLable() {
		return this.blogContentLable;
	}

	public void setBlogContentLable(String blogContentLable) {
		this.blogContentLable = blogContentLable;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

}