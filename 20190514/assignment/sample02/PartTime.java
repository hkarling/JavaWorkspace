/** 
 * @author 윤참솔
 * created on 2019/05/14
 */
package sample02;

public class PartTime extends Employee {
	private int timePay;
	
    ////////////////////////////////////////////////////////////////////////////

	public PartTime() {
		
	}
	
	public PartTime(int empNo, String eName, String job, int mgr, String hiredate, String depName, int timePay) {
		super(empNo, eName, job, mgr, hiredate, depName);
		this.timePay = timePay;
	}

	////////////////////////////////////////////////////////////////////////////

	public int getTimePay() {
		return timePay;
	}

	public void setTimePay(int timePay) {
		this.timePay = timePay;
	}

    ////////////////////////////////////////////////////////////////////////////

	@Override
	public void message() {
		super.message();
		System.out.println("비정규직입니다.");
	}

	@Override
	public String toString() {
		return super.toString() + " | " + this.timePay;
	}	
}
