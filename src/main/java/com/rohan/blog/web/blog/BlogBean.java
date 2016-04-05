package com.rohan.blog.web.blog;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.rohan.blog.delegate.BlogDelegate;
import com.rohan.blog.entity.Blog;


@ManagedBean(name = "blogBean")
@RequestScoped
public class BlogBean {

    private long blogId;
    private String blogLabel;
    private String blogContent;
    private Date blogCreatedDate;

    @ManagedProperty(name = "blogDelegate", value = "#{blogDelegate}")
    private BlogDelegate blogDelegate;


    @PostConstruct
    public void init() {
        System.out.println("PostConstruct");

    }

    @PreDestroy
    public void destroy() {
        this.blogLabel = null;
        this.blogContent = null;
        this.blogCreatedDate = null;
        System.out.println("PreDestroy");
    }


    public String addBlogDetails() {
        FacesMessage doneMessage = null;
        String outcome = null;

        Blog blog = new Blog();

        blog.setBlogContent(this.blogContent);
        blog.setBlogContentLable(this.blogLabel);
        blog.setCreatedDate(new Date());


        if (blogDelegate.saveBlog(blog) != null) {
            doneMessage = new FacesMessage("Successfully added new user");
            outcome = "success";
        } else {
            doneMessage = new FacesMessage("Failure to added new user");
            outcome = "failure";
        }

        FacesContext.getCurrentInstance().addMessage(null, doneMessage);

        return outcome;
    }


    public String updateBlogDetails() {
        FacesMessage doneMessage = null;
        String outcome = null;

        Blog blog = new Blog();

        blog.setBlogId(this.blogId);

        blog.setBlogContent(this.blogContent);

        blog.setBlogContentLable(this.blogLabel);

        blog.setCreatedDate(this.blogCreatedDate);

        blog.setModifiedDate(new Date());


        if (blogDelegate.updateBlog(blog) != null) {
            doneMessage = new FacesMessage("Updated Successfully ");
            outcome = "success";
        } else {
            doneMessage = new FacesMessage("Failed to update");
            outcome = "failure";
        }

        FacesContext.getCurrentInstance().addMessage(null, doneMessage);

        return outcome;
    }


    public String editblogDetails() {
        String outcome = null;

        Blog blog = this.blogDelegate.getBlogDetail(this.blogId);

        this.setBlogId(blog.getBlogId());
        this.setBlogContent(blog.getBlogContent());
        this.setBlogLabel(blog.getBlogContentLable());
        this.setBlogCreatedDate(blog.getCreatedDate());

        outcome = "/admin/editblog.xhtml";
        return outcome;

    }

    public String deleteblogDetails() {
        FacesMessage doneMessage = null;
        String outcome = null;


        blogDelegate.deleteByKey(this.blogId);
        doneMessage = new FacesMessage("Deleted Successfully ");
        outcome = "/admin/success";

        FacesContext.getCurrentInstance().addMessage(null, doneMessage);

        return outcome;
    }


    public List<Blog> getBlogList() {
        return this.blogDelegate.getBlogs();
    }


    public long getBlogId() {
        return blogId;
    }

    public void setBlogId(long blogId) {
        this.blogId = blogId;
    }


    public BlogDelegate getBlogDelegate() {
        return blogDelegate;
    }

    public void setBlogDelegate(BlogDelegate blogDelegate) {
        this.blogDelegate = blogDelegate;
    }


    public String getBlogLabel() {
        return blogLabel;
    }

    public void setBlogLabel(String blogLabel) {
        this.blogLabel = blogLabel;
    }

    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent;
    }

    public Date getBlogCreatedDate() {
        return blogCreatedDate;
    }

    public void setBlogCreatedDate(Date blogCreatedDate) {
        this.blogCreatedDate = blogCreatedDate;
    }


}
