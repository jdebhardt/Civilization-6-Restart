package com.joeebhardt.civ6;

import java.awt.AWTException;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Scanner;
import javax.imageio.ImageIO;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Core.MinMaxLocResult;
import org.opencv.highgui.Highgui;
import org.opencv.imgproc.Imgproc;

public class Match {

	public static final String singlePlayer = "resources\\templates\\singlePlayer.JPG";
	public static final String createGame = "resources\\templates\\createGame.JPG";
	public static final String civilization = "resources\\templates\\civilization.JPG";
	public static final String speed = "resources\\templates\\speed.JPG";
	public static final String difficulty = "resources\\templates\\difficulty.JPG";
	public static final String mapType = "resources\\templates\\mapType.JPG";
	public static final String mapSize = "resources\\templates\\mapSize.JPG";
	public static final String startGame = "resources\\templates\\startGame.JPG";
	public static final String exitGame = "resources\\templates\\exitGame.JPG";
	public static final String exitConfirmation = "resources\\templates\\exitConfirmation.JPG";

	private static HashMap<String, Point> locations = new HashMap<String, Point>();
	private static String resolution;

	public static void init() {

		Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit()
				.getScreenSize());
		resolution = screenRect.width + "x" + screenRect.height;

		File res = new File("resources\\resolutions\\" + resolution + ".txt");

		if (res.exists()) {

			Scanner sc = null;
			try {
				sc = new Scanner(res);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

			while (sc.hasNext()) {

				String s = sc.next();
				Point p = new Point(sc.nextInt(), sc.nextInt());
				locations.put(s, p);

			}
		}
	}

	public static void save() {

		File res = new File("resources\\resolutions\\" + resolution + ".txt");

		if (res.exists()) {
			res.delete();
		}

		try {
			res.createNewFile();
			FileOutputStream out = new FileOutputStream(res);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));

			for (String s : locations.keySet()) {

				bw.write(s + " " + locations.get(s).x + " "
						+ locations.get(s).y);
				bw.newLine();

			}

			bw.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public static Point find(String path) {

		if (locations.containsKey(path)) {
			return locations.get(path);
		}

		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

		Robot r = null;

		int match_method = Imgproc.TM_CCOEFF_NORMED;

		try {
			r = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}

		Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit()
				.getScreenSize());
		BufferedImage capture = r.createScreenCapture(screenRect);
		File temp = null;

		try {
			temp = File.createTempFile("screenshot", ".png");
			ImageIO.write(capture, "png", temp);
		} catch (IOException e) {
			e.printStackTrace();
		}

		Mat img = Highgui.imread(temp.getPath());
		Mat template = Highgui.imread(path);

		int result_cols = img.cols() - template.cols() + 1;
		int result_rows = img.rows() - template.rows() + 1;
		Mat result = new Mat(result_rows, result_cols, CvType.CV_32FC1);

		Imgproc.matchTemplate(img, template, result, match_method);

		MinMaxLocResult mmr = Core.minMaxLoc(result);

		Point location = new Point((int) mmr.maxLoc.x + template.cols()/2,
				(int) mmr.maxLoc.y+template.rows()/2 );
		
		
		locations.put(path, location);

		return location;
	}

}
