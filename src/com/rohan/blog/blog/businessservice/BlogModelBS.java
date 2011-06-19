package com.rohan.blog.blog.businessservice;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import com.rohan.blog.entity.Blog;

public interface BlogModelBS {

	@RolesAllowed({"ROLE_ADMIN","ROLE_USER"})
	Blog saveBlog(Blog pBlog);
	
	@RolesAllowed({"ROLE_ADMIN","ROLE_USER"})
	Blog updateBlog(Blog pBlog);
	
	void deleteByKey(long pBlogId);
	
	List<Blog> getBlogs();
	
	Blog getBlogDetail(long pBlogId);

}