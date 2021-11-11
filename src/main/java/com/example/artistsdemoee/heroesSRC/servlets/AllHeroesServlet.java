package com.example.artistsdemoee.heroesSRC.servlets;

import com.example.artistsdemoee.heroesSRC.dto.ViewHeroBasicInfoDto;
import com.example.artistsdemoee.heroesSRC.service.HeroService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.example.artistsdemoee.heroesSRC.util.ViewPathJsp.*;

@WebServlet("/heroes")
public class AllHeroesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ViewHeroBasicInfoDto> heroes = HeroService.getInstance().getAllHeroes();
        req.setAttribute("all_heroes",heroes);
        getServletContext().getRequestDispatcher(getPathToJsp("allHeroes")).forward(req,resp);
    }
}
