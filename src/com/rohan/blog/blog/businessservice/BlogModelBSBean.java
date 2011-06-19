package com.rohan.blog.blog.businessservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rohan.blog.blog.dataaccess.BlogModelDao;
import com.rohan.blog.entity.Blog;

@Service("blogModelBS")
public class BlogModelBSBean implements BlogModelBS {
	
	@Autowired
	private BlogModelDao blogModelDao;

	
	@Override
	@Transactional
	public Blog saveBlog(Blog pBlog) {
		return (Blog) this.blogModelDao.save(pBlog);
	}

	@Override
	@Transactional
	public Blog updateBlog(Blog pBlog) {
		return (Blog) this.blogModelDao.update(pBlog);
	}
	
	@Override
	@Transactional
	public void deleteByKey(long pBlogId) {
		this.blogModelDao.deleteByKey(pBlogId);
		
	}

	@Override
	public List<Blog> getBlogs() {
		return this.blogModelDao.findAll();
		 
	}


	@Override
	public Blog getBlogDetail(long pBlogId) {
		return (Blog) this.blogModelDao.findByPrimaryKey(pBlogId);
	}




	
	
	
}










