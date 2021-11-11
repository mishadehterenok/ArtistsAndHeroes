package com.example.artistsdemoee.artistsSRC.servlets;

import com.example.artistsdemoee.artistsSRC.dto.ArtistDto;
import com.example.artistsdemoee.artistsSRC.service.ArtistService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/artist")
public class ShowArtistServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        ArtistDto artistDto = ArtistService.getInstance().findById(id);
        req.setAttribute("artist", artistDto);
        getServletContext().getRequestDispatcher("/resources/jsp/artists/show.jsp").forward(req,resp);

    }
}
