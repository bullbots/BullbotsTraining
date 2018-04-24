import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Tester {
	private HashMap<Character, Integer> frequencyMap;
	private File f;
	public Tester(File f) throws FileNotFoundException {
		this.f=f;
		frequencyMap = new HashMap<Character, Integer>();
		analyze();
	}
	
	/**
	 * Populates the HashMap
	 * @throws FileNotFoundException
	 */
	private void analyze() throws FileNotFoundException {
		Scanner scan = new Scanner(f);
		while(scan.hasNextLine()) {
			String next = scan.nextLine();
			for(char c : next.toCharArray()) {
				Character objC = c;
				if(frequencyMap.containsKey(objC)) {//We already have a key in there...
					frequencyMap.replace(objC, frequencyMap.get(objC)+1);
				}else {
					frequencyMap.put(objC, 1);
				}
			}
		}
	}
	
	public void grade(TextAnalyzer text) {
		frequencyMap.forEach((k, v)->{
			if(text.getFrequencyOf(k) == v) {
				System.out.println("Passed for: "+k);
			}else {
				System.out.println("FAILED: grader found: "+v+" and YOU found: "+text.getFrequencyOf(k)+" for character: "+k);
			}
		});
	}
}
