package com.zensar.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.dto.Blog;
import com.zensar.entity.BlogEntity;
import com.zensar.repository.BlogRepo;


@Service
public class BlogServiceImpl implements BlogService{

	@Autowired
	BlogRepo blogRepo;
	
	@Autowired
	ModelMapper modelMapper;
	
	
	@Override
	public Blog createNewBlog(Blog blog) {
		BlogEntity stockEntity = convertDTOIntoEntity(blog);
		stockEntity = blogRepo.save(stockEntity);
		return convertEntityIntoDTO(stockEntity);
	}

	@Override
	public Blog getBlogPostedById(int id) {
		Optional<BlogEntity> blob = blogRepo.findById(id);
		return modelMapper.map(blob.isPresent()? blob.get():null,Blog.class);
	}

	@Override
	public Blog updateBlog(int id, Blog blog) {
		BlogEntity entity = modelMapper.map(blog, BlogEntity.class);
		entity.setId(id);
		blogRepo.save(entity);
		return blog;
	}

	@Override
	public boolean deleteBlogPostedById(int id) {
		blogRepo.deleteById(id);
		return true;
	}
	
	private BlogEntity convertDTOIntoEntity(Blog blog) {
		BlogEntity blogEntity = modelMapper.map(blog, BlogEntity.class);
		return blogEntity;
	}
	
	private Blog convertEntityIntoDTO(BlogEntity blogEntity) {
		Blog blog = modelMapper.map(blogEntity, Blog.class);
		return blog;
	}

}
