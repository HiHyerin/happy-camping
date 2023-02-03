package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.annotation.Controller;
import com.sist.controller.annotation.RequestMapping;
import com.sist.dao.CampDAO;
import com.sist.util.Pagination;
import com.sist.vo.CampVO;

@Controller
public class CampModel {

    private final CampDAO campDAO;

    public CampModel() {
        this.campDAO = new CampDAO();
    }

    @RequestMapping("camp/list.do")
    public String campList(HttpServletRequest request, HttpServletResponse response) {
        String page = request.getParameter("page");
        if (page == null) {
            page = "1";
        }
        Pagination pagination = campDAO.campList(Integer.parseInt(page));
        request.setAttribute("page", pagination);
        return "/happy/camp/camp_list.jsp";
    }

    @RequestMapping("camp/detail.do")
    public String campDetail(HttpServletRequest request, HttpServletResponse response) {
        int cno = Integer.parseInt(request.getParameter("cno"));
        CampVO campVO = campDAO.campDetail(cno);
        request.setAttribute("camp", campVO);
        return "/happy/camp/camp_detail.jsp";
    }

}
