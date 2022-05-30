package com.springboot_ssm.service;


import com.springboot_ssm.domain.Book;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface BookService {
    /*添加*/
    public boolean save(Book book);

    /*修改*/
    public boolean update(Book book);

    /*根据ID删除*/
    public boolean delete(Integer id);

    /*根据ID查找*/
    public Book getById(Integer id);

    /*查找所有*/
    public List<Book> getAll();
}
