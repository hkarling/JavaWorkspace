package dao.prepared;

import oracle.sql.DATE;

import java.util.List;

/**
 * 
 */
public class StartView {
	
	public static void main(String[] args) {
		EmpDAO empDao = new EmpDAOImpl();
		
		System.out.println("1. 전체 검색 하기 ------------------");
		EndView.printAll(empDao.selectAll());
		
		System.out.println("\n2. 등록하기 ------------------");
		//등록전에 중복체크하고 중복이면 오류메시지 출력, 중복아니면 등록하기 등록결과에 따라 메시지 출력.

		System.out.println("** 중복이 있는 경우 **");
		// executeUpdate에서 실행한 쿼리의 반환값이 int형이며 반환값은 영향을 미친 레코드의 갯수이다.
		// 따라서 반환값이 0일 경우 실패, 그 외의 경우 성공으로 본다.
		if(empDao.empInsert(new EmpDTO(7369, "AAAAAA", "가가가", 9000, "2019-04-29")) != 0)
			EndView.printMessage("등록에 성공하였습니다.");
		else
			EndView.printMessage("등록에 실패하였습니다.");
		System.out.println("** 중복이 없는 경우 **");
		if(empDao.empInsert(new EmpDTO(9000, "AAAAAA", "가가가", 9000, "2019-04-29")) != 0)
			EndView.printMessage("등록에 성공하였습니다.");
		else
			EndView.printMessage("등록에 실패하였습니다.");


		EndView.printAll(empDao.selectAll());

		int empno = 0;
		System.out.println("\n3. 사원번호 검색하기 ------------------");
		System.out.println("** 있는 경우 **");
		empno = 7369;
		EndView.printSingle(empDao.selectByEmpno(empno));
		
		System.out.println("** 없는 경우 **");
		empno = 3003;
		EmpDTO single = empDao.selectByEmpno(empno);
		if(single == null)
			EndView.printMessage("입력한 사원번호 '" + empno + "'에 해당하는 사원이 없습니다.");
		else
			EndView.printSingle(single);

		System.out.println("\n4. 사원번호에 해당하는 정보 삭제 ------------------");
		System.out.println("** 있는 경우 **");
		empno = 9000;
		if(empDao.empDelete(empno) != 0)
			EndView.printMessage("사원번호 " + empno + " 레코드를 삭제하였습니다.");
		else
			EndView.printMessage("사원번호 " + empno + " 레코드를 삭제하지 못했습니다.");

		System.out.println("** 없는 경우 **");
		empno = 0000;
		if(empDao.empDelete(empno) != 0)
			EndView.printMessage("사원번호 " + empno + " 레코드를 삭제하였습니다.");
		else
			EndView.printMessage("사원번호 " + empno + " 레코드를 삭제하지 못했습니다.");

		EndView.printAll(empDao.selectAll());

		System.out.println("\n5. 사원번호에 해당하는 정보 수정 ------------------");
		System.out.println("** 해당 사원 번호가 있는 경우 **");
		empno = 7934;
		if(empDao.empUpdate(new EmpDTO(empno, "AAAAAA", "가가가", 9000, "2019-04-29")) != 0){
			EndView.printMessage("사원번호 " + empno + " 레코드를 수정하였습니다..");
			EndView.printSingle(empDao.selectByEmpno(empno));
		}
		else
			EndView.printMessage("사원번호 " + empno + " 레코드를 수정하지 못했습니다.");

		System.out.println("** 해당 사원 번호가 없는 경우 **");
		empno = 0000;
		if(empDao.empUpdate(new EmpDTO(empno, "AAAAAA", "가가가", 9000, "2019-04-29")) != 0){
			EndView.printMessage("사원번호 " + empno + " 레코드를 수정하였습니다..");
			EndView.printSingle(empDao.selectByEmpno(empno));
		}
		else
			EndView.printMessage("사원번호 " + empno + " 레코드를 삭제하지 못했습니다.");

		/** 롤백용 -_______-... */
		EmpDAOImpl.rollback();
	}
}
