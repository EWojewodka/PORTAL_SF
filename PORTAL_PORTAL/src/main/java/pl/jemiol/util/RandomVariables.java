package pl.jemiol.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class RandomVariables {

	public static int getRandomInteger() {
		return ThreadLocalRandom.current().nextInt();
	}

	public static int getRandomInteger(int min, int max) {
		return ThreadLocalRandom.current().nextInt(min, max);
	}

	public static String getRandomName(int lineOfName) throws IOException {
		return null;
	}

	//TODO ASAP!
	public static ArrayList<TripleMap> listOfNames() throws FileNotFoundException {
//		File file = new File("resources/static/famouse-people-list.txt");
//		Scanner scanner = new Scanner(file);
//		int lenght = 0;
//		
//			TripleMap tripleMap = new TripleMap(indexOfName, "fsdf", "Fds");
		return null;
	}
}
