package com.example.demo.service;
public class AdminNotFoundException extends RuntimeException 
{
	public AdminNotFoundException(String message)
	{
		super(message);
	}

}
