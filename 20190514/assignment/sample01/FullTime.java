/** 
 * @author 윤참솔
 * created on 2019/05/14
 */
package sample01;

public class FullTime {
    private int empNo;
    private String eName;
    private String job;
    private int mgr;
    private String hiredate;
    private String depName;
    private int salary;
    private int bonus;

    ////////////////////////////////////////////////////////////////////////////
    
    public FullTime() {

    }

    public FullTime(int empNo, String eName, String job, int mgr, String hiredate, String depName, int salary, int bonus) {
        this();
        this.empNo = empNo;
        this.eName = eName;
        this.job = job;
        this.mgr = mgr;
        this.hiredate = hiredate;
        this.depName = depName;
        this.salary = salary;
        this.bonus = bonus;
    }
    
    ////////////////////////////////////////////////////////////////////////////
    
    /**
     * @return the empNo
     */
    public int getEmpNo() {
        return empNo;
    }
    /**
     * @param empNo the empNo to set
     */
    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }
    /**
     * @return the eName
     */
    public String geteName() {
        return eName;
    }
    /**
     * @param eName the eName to set
     */
    public void seteName(String eName) {
        this.eName = eName;
    }
    /**
     * @return the job
     */
    public String getJob() {
        return job;
    }
    /**
     * @param job the job to set
     */
    public void setJob(String job) {
        this.job = job;
    }
    /**
     * @return the mgr
     */
    public int getMgr() {
        return mgr;
    }
    /**
     * @param mgr the mgr to set
     */
    public void setMgr(int mgr) {
        this.mgr = mgr;
    }
    /**
     * @return the hiredate
     */
    public String getHiredate() {
        return hiredate;
    }
    /**
     * @param hiredate the hiredate to set
     */
    public void setHiredate(String hiredate) {
        this.hiredate = hiredate;
    }
    /**
     * @return the depName
     */
    public String getDepName() {
        return depName;
    }
    /**
     * @param depName the depName to set
     */
    public void setDepName(String depName) {
        this.depName = depName;
    }
    /**
     * @return the salary
     */
    public int getSalary() {
        return salary;
    }
    /**
     * @param salary the salary to set
     */
    public void setSalary(int salary) {
        this.salary = salary;
    }
    /**
     * @return the bonus
     */
    public int getBonus() {
        return bonus;
    }
    /**
     * @param bonus the bonus to set
     */
    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
    
    ////////////////////////////////////////////////////////////////////////////
    
    public void message() {
    	System.out.println(this.eName +"사원은 정규직입니다.");
    } 
    @Override
    public String toString() {
    	String str = this.empNo + " | " + this.eName + " | " + this.job + " | " + this.mgr + " | " + this.hiredate + " | " + this.depName + " | " + this.salary + " | " + this.bonus;
        return str;
    }
}