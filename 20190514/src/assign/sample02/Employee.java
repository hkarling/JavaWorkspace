/** 
 * @author 윤참솔
 * created on 2019/05/14
 */
package assign.sample02;

public abstract class Employee {
	private int empNo;
	private String eName;
	private String job;
	private int mgr;
	private String hiredate;
	private String depName;

	////////////////////////////////////////////////////////////////////////////

	protected Employee() {

	}

	protected Employee(int empNo, String eName, String job, int mgr, String hiredate, String depName) {
		this.empNo = empNo;
		this.eName = eName;
		this.job = job;
		this.mgr = mgr;
		this.hiredate = hiredate;
		this.depName = depName;
	}

	////////////////////////////////////////////////////////////////////////////

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getMgr() {
		return mgr;
	}

	public void setMgr(int mgr) {
		this.mgr = mgr;
	}

	public String getHiredate() {
		return hiredate;
	}

	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	////////////////////////////////////////////////////////////////////////////

	public abstract void message();

	@Override
	public String toString() {
		String str = this.empNo + " | " + this.eName + " | " + this.job + " | " + this.mgr + " | " + this.hiredate + " | " + this.depName;
		return str;
	}
}
