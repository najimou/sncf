package fr.upmc.service;

import java.util.UUID;

public class TokenGenerator {
	
	public static String getToken(){
	String uuid = UUID.randomUUID().toString();
	return uuid;
	}
}
