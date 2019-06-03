package edu.umb.cs.cs680.hw02;

public final class Student {
	private final float tuition;
	private final String name;
	private final int i20num;
	private final String usAddr;
	private final int yrsInState;
	private final String foreignAddr;

	private Student(float tuition,String name, int i20num, String usAddr, int yrsInState, String foreignAddr, StudentStatus status) {
	
		this.tuition=tuition;
		this.name=name;
		this.i20num=i20num;
		this.usAddr=usAddr;
		this.yrsInState=yrsInState;
		this.foreignAddr=foreignAddr;
	}
	public static final Student createInStateStudent(String name,String usAddr, int yrsInState)
	
	{
	     return new Student(0, name, 0, usAddr, yrsInState, null, StudentStatus.INSTATE);
	/*{ Student student= new Student(0, name, 0, usAddr, yrsInState, null, StudentStatus.INSTATE);
	return student;*/
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
	String getUsAddr() {
		return usAddr;
	}
	int getYrsinstate() {
		return yrsInState;
	}
	String getForeignaddr() {
		return foreignAddr;
	}
}