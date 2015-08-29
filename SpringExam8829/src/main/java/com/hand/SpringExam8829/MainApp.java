package com.hand.SpringExam8829;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hand.SpringExam8829.Film;
import com.hand.SpringExam8829.FilmJDBCTemplate;


import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.Scanner;



public class MainApp {

	public static void main(String[] args) {
		
		System.out.println("Context Start");
		Scanner input=new Scanner(System.in);
		System.out.println("请输入电影名称(title):");
		String fname=input.next();
		System.out.println("请输入电影描述(description):");
		String fdes=input.next();
		System.out.println("请输入ID(language_id[0 < id <= 6]):");
		int flangeid=input.nextByte();
		
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		FilmJDBCTemplate filmJDBCTemplate = (FilmJDBCTemplate) context.getBean("filmJDBCTemplate");
		System.out.println("------Records Creation--------" );
		filmJDBCTemplate.create(fname,fdes,flangeid);
		System.out.println("------Insert Records--------" );
		List<Film> films = filmJDBCTemplate.listFilms();
//		for(Film record:films) {
//			System.out.print("title : " + record.getTitle());
//			System.out.print("||, description : " + record.getDescription());
//			System.out.println("||, language_id : " + record.getLanguage_id());
//		}
		
		Film record = filmJDBCTemplate.getFilm(fname);
			System.out.print("title : " + record.getTitle());
			System.out.print(" || description : " + record.getDescription());
			System.out.println(" || language_id : " + record.getLanguage_id());
		
			System.out.println("Context Stop");
		
	}

	
		
}
