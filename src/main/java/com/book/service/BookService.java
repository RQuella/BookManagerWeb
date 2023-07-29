package com.book.service;

import com.book.entity.Book;
import com.book.entity.Borrow;
import com.book.entity.Student;

import java.util.List;
import java.util.Map;

public interface BookService {
    List<Borrow> getBorrowList();

    void returnBook(String id);

    //过滤掉已经借出的书，防止同一本书同时被两人借
    List<Book> getActiveBookList();

    List<Student> getStudentList();

    void addBorrow(int sid, int bid);

    //显示书籍借阅状态
    Map<Book, Boolean> getBookList();

    void deleteBook(int bid);

    void addBook(String title, String desc, double price);
}
