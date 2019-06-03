package edu.umb.cs.cs680.hw02;

public class Student {
	
	private final float tuition;
	private final String name;
	private final int i20num;
	private final String usAddr;
	private final int yrsInState;
	private final String foreignAddr;
	private static StudentStatus status;

	private Student(float tuition,String name, int i20num, String usAddr, int yrsInState, String foreignAddr, StudentStatus status) {
	
		this.tuition=tuition;
		this.name=name;
		this.i20num=i20num;
		this.usAddr=usAddr;
		this.yrsInState=yrsInState;
		this.foreignAddr=foreignAddr;
		this.status = status;
	}
     public static final Student createInStateStudent(String name,String usAddr, int yrsInState)
	
	{
	   return new Student(0, name, 0, usAddr, yrsInState, null, StudentStatus.INSTATE);
	}
	public static final Student createOutStateStudent(String name,String usAddr,int yrsInState)
	{
		return new Student(0, name, 0,usAddr, yrsInState, null, StudentStatus.OUTSTATE);
	}
	public static final Student createIntlStudent(String name,int i20num,String usAddr,int yrsInState,String foreignAddr)
   
	{
		return new Student(0, name, i20num, usAddr, yrsInState, foreignAddr, StudentStatus.INTL);
	}
	float getTuition() {
		return tuition;
	}
	String getName() {
		return name;
	}
	int getI20num() {
		return i20num;
	}
	String getusAddr() {
		return usAddr;
	}
	int getyrsInstate() {
		return yrsInState;
	}
	String getForeignaddr() {
		return foreignAddr;
	}
	public void setStatus(StudentStatus status) {
		Student.status = status;
	}
	public StudentStatus getStatus() {
	
		return status;
	}
}
