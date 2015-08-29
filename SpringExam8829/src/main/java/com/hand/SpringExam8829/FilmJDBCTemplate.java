package com.hand.SpringExam8829;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class FilmJDBCTemplate implements FilmDAO {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	public void setDataSource(DataSource ds) {
		
		this.dataSource = ds;
		this.jdbcTemplateObject = new JdbcTemplate(ds);
	}

	public void create(String title,String description,Integer language_id) {

		String sql = "INSERT INTO film (title,description,language_id) VALUES(?,?,?)";
		jdbcTemplateObject.update(sql, title,description,language_id);
		System.out.println("Insert Record title = " + title +" description = " + description+ " language_id = " + language_id);
	}

	public Film getFilm(String title) {
		
		String sql = "SELECT * FROM film WHERE title = ?";
		Film film = jdbcTemplateObject.queryForObject(sql, new Object[]{title}, new FilmMapper());
		return film;
	}

	public List<Film> listFilms() {
		
		String sql = "SELECT * FROM film";
		List<Film> film = jdbcTemplateObject.query(sql, new FilmMapper());
		return film;
	}

	public List<Film> listFlims() {
		// TODO Auto-generated method stub
		return null;
	}


	public void update(String title,String description,Integer language_id) {

		String sql = "UPDATE film SET title = ? description = ? WHERE language_id = ?";
		jdbcTemplateObject.update(sql, title,description,language_id);
		System.out.println("Updated Record with title = " + title );
		return;
	}

//	public void create(String title, String description, Integer language_id) {
//		// TODO Auto-generated method stub
//		
//	}

	
}

