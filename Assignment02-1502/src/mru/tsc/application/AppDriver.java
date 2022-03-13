package mru.tsc.application;

import mru.tsc.controller.AppManager;

/**
 * This class is the main driver for the program
 * @author Denzel Pascual and Ghoza Ghazali
 *
 */
public class AppDriver {

	/**
	 * Calls the program logic from controller folder 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		//Instantiate the AppManager object
		new AppManager();

	}

}
