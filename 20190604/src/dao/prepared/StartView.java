package dao.prepared;

import java.util.List;

/**
 * 
 */
public class StartView {
	
	public static void main(String[] args) {
		EmpDAO empDao = new EmpDAOImpl();
		
		System.out.println("1. 전체 검색 하기 ------------------");
		List<EmpDTO> list = empDao.selectAll();
		
		EndView.printAll(list);
		
		System.out.println("\n2. 등록하기 ------------------");
		//등록전에 중복체크하고 중복이면 오류메시지 출력, 중복아니면 등록하기 등록결과에 따라 메시지 출력.
		
		
		System.out.println("\n3. 사원번호 검색하기 ------------------");
		System.out.println("** 있는 경우 **");
		EndView.printSingle(empDao.selectByEmpno(7369));
		
		System.out.println("** 없는 경우 **");
		EmpDTO single = empDao.selectByEmpno(3003);
		
		if(single == null)
			EndView.printMessage("입력한 사원번호에 해당하는 사원이 없습니다.");
		else
			EndView.printSingle(single);

		System.out.println("\n4. 사원번호에 해당하는 정보 삭제 ------------------");
		
		System.out.println("\n5. 사원번호에 해당하는 정보 수정 ------------------");
		
		
		
		
	}
}
