package com.hospital.manage;

public class Logger {

	public static Logger getInstance() {

		Logger logger = new Logger();
		return logger;

	}

	public void getInput(Object message) {

		Logger.log(message);

	}

	private static void log(Object message) {
		// TODO Auto-generated method stub
		System.out.println(message);
	}

	public void debug(Object message) {

		Logger.log(message);

	}

	public void info(Object message) {

		Logger.log(message);

	}

	public void error(Object message) {

		System.out.println(message);

	}

}
