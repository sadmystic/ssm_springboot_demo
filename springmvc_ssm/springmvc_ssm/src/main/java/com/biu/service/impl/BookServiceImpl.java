package com.biu.service.impl;

import com.biu.controller.Code;
import com.biu.dao.BookDao;
import com.biu.domain.Book;
import com.biu.exception.BusinessException;
import com.biu.exception.SystemException;
import com.biu.service.BookService;
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
/*        if(id==1){
            throw new BusinessException(Code.BUSINESS_ERR,"请别挑战我的耐心");
        }
        try{
            int i=1/0;
        }catch (Exception e){
            throw new SystemException(Code.SYSTEM_TIMEOUT_ERR,"超时，重试");
        }*/
        return bookDao.getById(id);
    }

    @Override
    public List<Book> getAll() {
        return bookDao.getAll();
    }
}
