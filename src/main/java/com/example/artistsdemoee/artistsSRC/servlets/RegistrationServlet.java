package com.example.artistsdemoee.artistsSRC.servlets;

import com.example.artistsdemoee.artistsSRC.dto.ArtistDto;
import com.example.artistsdemoee.artistsSRC.entity.Artist;
import com.example.artistsdemoee.artistsSRC.service.ArtistService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/reg")
public class RegistrationServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/resources/jsp/artists/registration.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        Artist artist = new Artist(name, age);
        if (!name.isEmpty() && !request.getParameter("age").isEmpty()){
            ArtistDto artistDto = ArtistService.getInstance().save(artist);
            response.sendRedirect("/artist?id=" + artistDto.getId());
        } else {
            response.sendRedirect("/reg");
        }
    }
}
