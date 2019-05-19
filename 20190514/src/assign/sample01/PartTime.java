package assign.sample01;

public class PartTime {
    private int empNo;
    private String eName;
    private String job;
    private int mgr;
    private String hiredate;
    private String depName;
    private int timePay;

    ////////////////////////////////////////////////////////////////////////////

    public PartTime() {

    }

    public PartTime(int empNo, String eName, String job, int mgr, String hiredate, String depName, int timePay) {
        this();
        this.empNo = empNo;
        this.eName = eName;
        this.job = job;
        this.mgr = mgr;
        this.hiredate = hiredate;
        this.depName = depName;
        this.timePay = timePay;
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
     * @return the timePay
     */
    public int getTimePay() {
        return timePay;
    }

    /**
     * @param timePay the timePay to set
     */
    public void setTimePay(int timePay) {
        this.timePay = timePay;
    }

    ////////////////////////////////////////////////////////////////////////////

    public void message() {
        System.out.println(this.eName + "사원은 비정규직입니다.");
    }

    public String toString() {
        String str = this.empNo + " | " + this.eName + " | " + this.job + " | " + this.mgr + " | " + this.timePay;
        return str;
    }
}