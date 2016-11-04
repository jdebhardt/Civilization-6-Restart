package com.joeebhardt.civ6;


public class Info {
	
	public static Civ civ;
	public static Speed speed;
	public static Difficulty difficulty;
	public static MapType mapType;
	public static MapSize mapSize;
	
	
	/*
	public static void init(){
		
		Resolution res = new Resolution(); // 2560x1440
		res.setCiv(1280, 495);
		res.setDifficulty(1280, 565);
		res.setSpeed(1280, 635);
		res.setMapType(1280, 705);
		res.setMapSize(1280, 775);
		res.setExitGame(1280, 740);
		res.setExitConfirmation(1380, 760);
		res.setStart(1280, 1080);
		res.setSinglePlayer(1320, 590);
		res.setCreateGame(1370, 790);
		resolutions.put("2560x1440", res);
		
		res = new Resolution(); // 1920x1080
		res.setCiv(952, 308);
		res.setDifficulty(960, 385);
		res.setSpeed(960, 455);
		res.setMapType(960, 525);
		res.setMapSize(960, 600);
		res.setExitGame(960, 560);
		res.setExitConfirmation(1065, 580);
		res.setStart(960, 900);
		res.setSinglePlayer(980, 410);
		res.setCreateGame(1070, 610);
		resolutions.put("1920x1080", res);
		
	}
	
	public static void setCurrentResolution(String res){
		resolution =  resolutions.get(res);
	}
	*/
	
	public static class Pause{
		
		public static int exitGame = 3000;
		public static int UI = 300;
		public static int button = 120;
		
	}


}
