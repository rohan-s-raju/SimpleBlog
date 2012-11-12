package com.rohan.blog.blog.businessservice;

import java.util.List;

import org.springframework.security.access.annotation.Secured;


import com.rohan.blog.entity.Blog;

public interface BlogModelBS {

	@Secured({"ROLE_ADMIN","ROLE_USER"})
	Blog saveBlog(Blog pBlog);
	
	@Secured({"ROLE_ADMIN","ROLE_USER"})
	Blog updateBlog(Blog pBlog);
	
	void deleteByKey(long pBlogId);
	
	List<Blog> getBlogs();
	
	Blog getBlogDetail(long pBlogId);

}