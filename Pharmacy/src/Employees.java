public class Employees {
	private int empID, empAge;
	private String empName, empGender, empPass, empPos;
	Employees(int empID, String empName, String empPass, int empAge, String empGender, String empPos){
		this.empID = empID;
		this.empName = empName;
		this.empPass = empPass;
		this.empAge = empAge;
		this.empGender = empGender;
		this.empPos = empPos;
	}
	public int getEmpID() {
		return this.empID;
	}
	public void setEmpID(int empID) {
		this.empID = empID;
	}
	public String getEmpName() {
		return this.empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpPass() {
		return this.empPass;
	}
	public void SetEmpPass(String empPass) {
		this.empPass = empPass;
	}
	public int getEmpAge() {
		return this.empAge;
	}
	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}
	public String getEmpGender() {
		return this.empGender;
	}
	public void setEmpGender(String empGender) {
		this.empGender = empGender;
	}
	public String getEmpPos() {
		return this.empPos;
	}
	public void serEmpPos(String empPos) {
		this.empPos = empPos;
	}
}
