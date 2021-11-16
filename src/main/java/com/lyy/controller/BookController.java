package com.lyy.controller;

import com.lyy.serrvice.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @program: spring-annotation
 * @description:
 * @author: ly
 * @create: 2021-11-15 17:17
 **/
@Controller
public class BookController {
    @Autowired
    private BookService bookService;
}
