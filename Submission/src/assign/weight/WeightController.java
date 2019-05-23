package assign.weight;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InvalidClassException;
import java.nio.file.FileAlreadyExistsException;

public class WeightController {

	private WeightService service = WeightService.getInstance();

	public void insert(Person person) {

		try {
			service.insert(person);
			ViewResult.printMessage("저장에 성공하였습니다.");
			
		} catch(FileAlreadyExistsException e) {
			ViewResult.printMessage(e.getMessage() + ": 파일이 이미 존재합니다.");
		
		} catch (IOException e) {
			ViewResult.printMessage("저장이 되지 않았습니다." + e.getMessage());
		
		}
	}

	public void selectPerson(Person person) {
		try {
			service.selectPerson(person);
			ViewResult.printPerson(person);

		} catch (FileNotFoundException e) {
			ViewResult.printMessage("파일을 찾을 수 없습니다.");

		} catch (InvalidClassException e ) { 
			ViewResult.printMessage(e.getMessage() + "가 올바르지 않습니다.");
		} catch (IOException e) {
			ViewResult.printMessage("파일을 불러오는데 문제가 발생하였습니다.");
		
		} catch (NumberFormatException e) {
			ViewResult.printMessage("정보가 올바르지 않습니다.");
		
		}
	}
}
