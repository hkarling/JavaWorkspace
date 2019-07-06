package ex0524.assign.weight;

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
	
	public void updateWeight(Person person) {
		try {
			service.selectPerson(person);
			ViewResult.printPerson(person);
			while(true) { 
				try {
					person.setWeight(Integer.parseInt(ViewMain.weightInput()));
					break;
				} catch (NumberFormatException e) {
					ViewResult.printMessage("몸무게로 장난치지 말죠...");
				}
			}
			service.updatePerson(person);
			ViewResult.printMessage("몸무게를 변경하였습니다.");
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
	
	public void updatePassword(Person person) {
		try {
			service.selectPerson(person);
			ViewResult.printPasswordInfo(person);
			person.setPassword(ViewMain.passwordInput());
			service.updatePerson(person);
			ViewResult.printMessage("패스워드를 변경하였습니다.");
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
