/** 
 * @author 윤참솔
 * created on 2019/05/14
 */
package sample02;

public class FullTime extends Employee {
	private int salary;
	private int bonus;

	////////////////////////////////////////////////////////////////////////////

	public FullTime() {

	}

	public FullTime(int empNo, String eName, String job, int mgr, String hiredate, String depName, int salary,
			int bonus) {
		super(empNo, eName, job, mgr, hiredate, depName);
		this.salary = salary;
		this.bonus = bonus;
	}
	
	////////////////////////////////////////////////////////////////////////////

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	////////////////////////////////////////////////////////////////////////////

	@Override
	public void message() {
		super.message();
		System.out.println("정규직입니다.");
	}

	@Override
	public String toString() {
		return super.toString() + " | " + this.salary + " | " + this.bonus;
	}
}
