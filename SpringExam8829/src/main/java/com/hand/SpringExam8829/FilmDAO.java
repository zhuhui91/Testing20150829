package com.hand.SpringExam8829;

import java.util.List;

import javax.sql.DataSource;

import com.hand.SpringExam8829.Film;

public interface FilmDAO {

	public void setDataSource(DataSource ds);
	
	public void create(String title,String description,Integer language_id);
	
	public Film getFilm(String title);
	
	public List<Film> listFlims();
	
	//public void delete(String title);
	
	//public void update(String title, Integer language_id);
	
	
	
}
