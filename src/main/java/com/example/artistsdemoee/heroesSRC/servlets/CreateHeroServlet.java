package com.example.artistsdemoee.heroesSRC.servlets;

import com.example.artistsdemoee.heroesSRC.dto.CreateNewHeroDto;
import com.example.artistsdemoee.heroesSRC.entity.Ability;
import com.example.artistsdemoee.heroesSRC.entity.Gender;
import com.example.artistsdemoee.heroesSRC.service.AbilityService;
import com.example.artistsdemoee.heroesSRC.service.HeroService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.example.artistsdemoee.heroesSRC.util.ViewPathJsp.*;

@WebServlet("/create")
public class CreateHeroServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Ability> abilities = AbilityService.getInstance().getAllAbilities();
        req.setAttribute("abilities",abilities);
        getServletContext().getRequestDispatcher(getPathToJsp("createHero")).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String identity = req.getParameter("identity");
        Gender gender = Gender.valueOf(req.getParameter("gender"));
        int age = Integer.parseInt(req.getParameter("age"));
        long ability_id = Long.parseLong(req.getParameter("ability"));
        CreateNewHeroDto heroDto = new CreateNewHeroDto(name, identity,age,gender, ability_id);
        HeroService.getInstance().createNewHero(heroDto);
        resp.sendRedirect("/create");
    }
}
