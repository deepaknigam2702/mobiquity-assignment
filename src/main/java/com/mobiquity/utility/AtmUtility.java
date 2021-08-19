package com.mobiquity.utility;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AtmUtility {
	public static String loadAtmDataFromFile () {
		String file = "src/main/resources/Atm.json";
        String jsonString = null;
		try {
			jsonString = new String(Files.readAllBytes(Paths.get(file)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return jsonString;
    }
}