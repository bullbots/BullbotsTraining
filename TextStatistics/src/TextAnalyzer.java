import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * This class will be used to analyze text files and give information about them
 * @author sylsr
 *
 */
public class TextAnalyzer {
	private Scanner scan;
	/**
	 * Default constructor
	 * @param f file to analyze
	 * @throws FileNotFoundException If we cannot find the file
	 */
	public TextAnalyzer(File f) throws FileNotFoundException {
		scan = new Scanner(f);
	}
	
	/**
	 * Gets the next line of the text file
	 * @return the next line OR null if we are done.
	 */
	private String getNextLine() {
		try {
			return scan.nextLine();
		}catch(NoSuchElementException e) {
			return null;
		}
	}
	
	/**
	 * Gets the frequency that a certain character appears in the text file
	 * @param c the char to get the frequency of
	 * @return the number of times c appears in the file.
	 */
	public int getFrequencyOf(char c) {
		return -1;//TODO:
	}
	
	
}
