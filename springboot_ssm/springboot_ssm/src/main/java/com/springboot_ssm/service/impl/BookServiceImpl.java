package com.springboot_ssm.service.impl;


import com.springboot_ssm.controller.Code;
import com.springboot_ssm.dao.BookDao;
import com.springboot_ssm.domain.Book;
import com.springboot_ssm.exception.BusinessException;
import com.springboot_ssm.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public boolean save(Book book) {
        return bookDao.save(book)>0;
    }

    @Override
    public boolean update(Book book) {
        return bookDao.update(book)>0;

    }

    @Override
    public boolean delete(Integer id) {
        return bookDao.delete(id)>0;
    }

    @Override
    public Book getById(Integer id) {
      if(id==1){
            throw new BusinessException(Code.BUSINESS_ERR,"请别挑战我的耐心");
        }

        return bookDao.getById(id);
    }

    @Override
    public List<Book> getAll() {
        return bookDao.getAll();
    }
}
