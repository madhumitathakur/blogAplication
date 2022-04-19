package com.zensar.service;

import com.zensar.dto.Blog;

public interface BlogService {
	
	public Blog createNewBlog(Blog blog);
	public Blog getBlogPostedById(int id);
	public Blog updateBlog(int id, Blog blog);
	public boolean deleteBlogPostedById(int id);

}
