package com.mymy.mymy.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mymy.mymy.Dao.Dao;
import com.mymy.mymy.Dto.Dto;

@Controller
public class Handler
{
	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping("/home")
	public String home() 
	{
		return "home";
	}
	@RequestMapping("/BoardList")
	public String BaordList(Model model)
	{
		//1) DataBase -> Data -> model -> return View 
		Dao dao = sqlSession.getMapper(Dao.class);
		ArrayList<Dto>dtos = dao.BoardList();
		model.addAttribute("dtos",dtos);
	
		return "BoardList";
	}
	@RequestMapping("/BoardWrite_View")
	public String BoardWrite_View()
	{
		return "BoardWrite_View";
	}
	//글쓰기양식에서 POST방식으로 전달된 data 를 DataBase 에 Access 해주기 한 함수
	@RequestMapping(value="/Dowrite",method = RequestMethod.POST)
	public String Dowrite(HttpServletRequest req, Model model)
	{
		//view => paramter => handler 
		String bTitle = req.getParameter("bTitle");
		String bName =req.getParameter("bName");
		String bContent = req.getParameter("bContent");
		//mybatis sqlSession (AutoWired)
		Dao dao = sqlSession.getMapper(Dao.class);
		dao.Dowrite(bTitle,bName,bContent);
		return "redirect:BoardList";
		
		
	}
	//클릭한게시물조회하기 
	@RequestMapping("/ContentView")
	public String ContentView(HttpServletRequest req , Model model)
	{
		int bId = Integer.parseInt(req.getParameter("bId"));
		Dao dao = sqlSession.getMapper(Dao.class);
		Dto dto = dao.ContentView(bId);
		//dao.upHit(bId);
		model.addAttribute("ContentView",dto);
		return "ContentView";
		
		
		
	}
	//해당 게시물 삭제하기 (클릭한 게시물을 삭제하고 싶은것 )
	@RequestMapping(value="/delete")
	public String delete(HttpServletRequest req , Model model)
	{
		String bId = req.getParameter("bId");
		Dao dao = sqlSession.getMapper(Dao.class);
		dao.delete(Integer.parseInt(bId));
		return "redirect:BoardList";
	}
	//클릭한 , 해당 게시물의 수정 부분으로 가기 
	@RequestMapping("/modify_view")
	public String modify_view(HttpServletRequest req , Model model)
	{
		int bId = Integer.parseInt(req.getParameter("bId"));
		Dao dao = sqlSession.getMapper(Dao.class);
		Dto dto = dao.ContentView(bId);
		model.addAttribute("modify_view", dto);
		return "modify_view";
		
		
		
	}
	@RequestMapping(value="/modify",method = RequestMethod.POST)
	public String modify(HttpServletRequest req, Model model)
	{
		String bId = req.getParameter("bId");
		String bName = req.getParameter("bName");
		String bTitle = req.getParameter("bTitle");
		String bContent = req.getParameter("bContent");
		Dao dao = sqlSession.getMapper(Dao.class);
		dao.modify(Integer.parseInt(bId),bName,bTitle,bContent);
		return "redirect:BoardList";
	}
}
