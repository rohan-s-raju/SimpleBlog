package com.rohan.blog.delegate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rohan.blog.blog.businessservice.BlogModelBS;
import com.rohan.blog.entity.Blog;



@Component("blogDelegate")
public class BlogDelegate {
	
	@Autowired
	private BlogModelBS blogModelBS;
	
	public Blog saveBlog(Blog pBlog){
		 return this.blogModelBS.saveBlog(pBlog);
	}
	
	public Blog updateBlog(Blog pBlog){
		 return this.blogModelBS.updateBlog(pBlog);
	}
	
	public void deleteByKey(long pBlogId){
		  this.blogModelBS.deleteByKey(pBlogId);
	}
	
	public List<Blog> getBlogs(){
		return blogModelBS.getBlogs();
	}
	
	public Blog getBlogDetail(long pBlogId){
		return blogModelBS.getBlogDetail(pBlogId);
	}

}
