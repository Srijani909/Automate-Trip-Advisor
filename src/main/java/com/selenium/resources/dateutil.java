package com.selenium.resources;

import java.util.Date;

public class dateutil {

	public static String gettimedata() {

		Date date = new Date();
		return date.toString().replaceAll(":", "_").replaceAll(" ", "_");

	}
}
