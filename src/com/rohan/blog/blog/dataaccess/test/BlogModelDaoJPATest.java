package com.rohan.blog.blog.dataaccess.test;

import static org.junit.Assert.fail;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.rohan.blog.blog.dataaccess.BlogModelDao;
import com.rohan.blog.entity.Blog;


@ContextConfiguration(locations={"classpath:applicationContextTest.xml"})
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=false)
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class BlogModelDaoJPATest {
	
	@Autowired
	BlogModelDao blogModelDao;

	@Test
	public void testSave() {
		Blog blog = new Blog();
		blog.setBlogContentLable("uhasdjrfnwoenfhuebnui");
		blog.setBlogContent("uhasdjrfnwoenfhuebnuidhasfoeahondashfsosenfoewhfioenroenf");
		blog.setCreatedDate(new Date());
		
		blogModelDao.save(blog);
		
	}

	@Test
	public void testFindByPrimaryKey() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteByKey() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

}
