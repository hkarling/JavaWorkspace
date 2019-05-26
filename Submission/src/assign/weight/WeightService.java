package assign.weight;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InvalidClassException;
import java.nio.file.FileAlreadyExistsException;

public class WeightService {

	/**
	 * Service는 하나만 있으면 되지 않을까 싶슴다.
	 */
	private static WeightService instance = null;

	private BufferedWriter bw = null;
	private BufferedReader br = null;

	private WeightService() {
	}

	public static WeightService getInstance() {
		if (instance == null)
			instance = new WeightService();
		return instance;
	}

	/**
	 * 1. 몸무게 입력 항목.
	 *
	 * @param person
	 * @throws IOException
	 */
	public void insert(Person person) throws IOException {
		File file = new File("weights/" + person.getName() + ".txt");
		if (file.exists())
			throw new FileAlreadyExistsException(file.getName());
		bw = new BufferedWriter(new FileWriter(file));
		bw.write(person.getWeight() + " : " + person.getPassword());
		bw.flush();
		bw.close();
	}

	/**
	 * 2. 몸무게 검색 항목.
	 *
	 * @param person
	 * @return person
	 * @throws IOException, NumberFormatException
	 */
	public Person selectPerson(Person person) throws IOException, NumberFormatException {
		br = new BufferedReader(new FileReader("weights/" + person.getName() + ".txt"));
		String inputStr = br.readLine();
		String data[] = inputStr.split(" : ");
		if (!person.getPassword().equals(data[1]))
			throw new InvalidClassException("Password");
		person.setWeight(Integer.parseInt(data[0]));
		person.setPassword(data[1]);
		return person;
	}

	/**
	 * 3. 몸무게 변경 항목.
	 */
	public Person updateWeight(Person person) {
		return null;
	}

	/**
	 * 4.
	 */

}
