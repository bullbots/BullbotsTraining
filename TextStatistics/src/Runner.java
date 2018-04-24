import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;

public class Runner {

	public static void main(String[] args) throws FileNotFoundException {
		String file = Paths.get(".").toAbsolutePath().normalize().toString()+"/large";
		File f = new File(file);
		TextAnalyzer text = new TextAnalyzer(f);
		Tester grader = new Tester(f);
		grader.grade(text);
	}
}
