package com.almundo.erozen.util;

import java.util.Random;

public class CallCenterUtils {

	private static final int RND_MAX = 10;
	private static final int RND_MIN = 5;
	
	public static int getRandomDuration() {
		Random r = new Random();
		return r.nextInt((RND_MAX - RND_MIN) + 1) + RND_MIN;
	}
	
}
