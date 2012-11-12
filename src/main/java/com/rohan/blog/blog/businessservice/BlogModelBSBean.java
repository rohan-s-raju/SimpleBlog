package com.rohan.blog.blog.businessservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.googlecode.ehcache.annotations.Cacheable;
import com.googlecode.ehcache.annotations.TriggersRemove;
import com.googlecode.ehcache.annotations.When;
import com.rohan.blog.blog.dataaccess.BlogModelDao;
import com.rohan.blog.entity.Blog;

@Service("blogModelBS")
@Transactional(readOnly=true)
public class BlogModelBSBean implements BlogModelBS {
	
	@Autowired
	private BlogModelDao blogModelDao;

	
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	@TriggersRemove(cacheName="findAllBlogCache",when=When.AFTER_METHOD_INVOCATION,removeAll=true)
	public Blog saveBlog(Blog pBlog) {
		return (Blog) this.blogModelDao.save(pBlog);
	}

	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	@TriggersRemove(cacheName="findAllBlogCache",when=When.AFTER_METHOD_INVOCATION,removeAll=true)
	public Blog updateBlog(Blog pBlog) {
		return (Blog) this.blogModelDao.update(pBlog);
	}
	
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	@TriggersRemove(cacheName="findAllBlogCache",when=When.AFTER_METHOD_INVOCATION,removeAll=true)
	public void deleteByKey(long pBlogId) {
		this.blogModelDao.deleteByKey(pBlogId);
		
	}

	@Cacheable(cacheName = "findAllBlogCache")
	public List<Blog> getBlogs() {
		return this.blogModelDao.findAll();
		 
	}


	public Blog getBlogDetail(long pBlogId) {
		return (Blog) this.blogModelDao.findByPrimaryKey(pBlogId);
	}

	
}










