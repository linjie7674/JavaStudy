package com.jielin.controller;

import com.jielin.Datasource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@RestController
public class BookController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private Datasource datasource;

    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public String deleteById(@PathVariable Integer id) {
        System.out.println("deleted id is: " + id);
        return String.format("{'id': %d, 'method': 'delete'}", id);
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String getUser(Integer id) {
        String str = "id: " + id;
        System.out.println(str);
        System.out.println("---------------------------------");
        System.out.println(datasource);
        return str;
    }
}
