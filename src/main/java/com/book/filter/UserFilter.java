package com.book.filter;

import com.book.entity.User;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

//过滤器
@WebFilter("/*")
public class UserFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        String url = req.getRequestURI().toString();
        if (!url.contains("/static/") && !url.endsWith("login")) {
//            用户保持登陆状态
            HttpSession session = req.getSession();
            User user = (User) session.getAttribute("user");
            if (user == null) {
                res.sendRedirect("login");
                return;
            }
        }
        chain.doFilter(req, res);
    }
}