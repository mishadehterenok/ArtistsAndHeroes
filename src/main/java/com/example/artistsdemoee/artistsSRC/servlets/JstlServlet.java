package com.example.artistsdemoee.artistsSRC.servlets;

import com.example.artistsdemoee.artistsSRC.service.ArtistService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/jstl")
public class JstlServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("artists", ArtistService.getInstance().findAll());
        getServletContext()
                .getRequestDispatcher("/resources/jsp/artists/jstl.jsp")
                .forward(req,resp);
    }
}
