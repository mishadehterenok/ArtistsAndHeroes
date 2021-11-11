package com.example.artistsdemoee.heroesSRC.servlets;

import com.example.artistsdemoee.heroesSRC.dto.ViewHeroFullInfoDto;
import com.example.artistsdemoee.heroesSRC.service.HeroService;
import com.example.artistsdemoee.heroesSRC.util.ViewPathJsp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/heroInfo")
public class HeroInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("id"));
        ViewHeroFullInfoDto heroFullInfo = HeroService.getInstance().getFullInfo(id);
        req.setAttribute("full_info",heroFullInfo);
        getServletContext().getRequestDispatcher(ViewPathJsp.getPathToJsp("heroInfo")).forward(req,resp);
    }
}
