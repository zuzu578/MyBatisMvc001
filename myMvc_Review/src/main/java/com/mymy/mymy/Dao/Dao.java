package com.mymy.mymy.Dao;

import java.util.ArrayList;

import com.mymy.mymy.Dto.Dto;

public interface Dao
{

	public void Dowrite(String bTitle, String bName, String bContent);

	public ArrayList<Dto> BoardList();

	public Dto ContentView(int bId);

	public int delete(int bId);

	public void modify(int bId, String bName, String bTitle, String bContent);

	//public void upHit(int bId);
	

}

