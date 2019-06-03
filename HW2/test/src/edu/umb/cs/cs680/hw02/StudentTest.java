package edu.umb.cs.cs680.hw02;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

public class StudentTest {
	
@Test
public void createInStateStudent() {
Student student = Student.createInStateStudent("Sowmya", "33 middlesex circle", 4);
assertThat(student.getName(), is("Sowmya"));
assertThat(student.getusAddr(), is("33 middlesex circle"));
assertThat(student.getyrsInstate(), is(4));
assertThat(student.getStatus(),is(StudentStatus.INSTATE));
}

@Test
public void createOutStateStudent() {
Student student = Student.createOutStateStudent("John", "Morrisey boul", 2);
assertThat(student.getName(), is("John"));
assertThat(student.getusAddr(), is("Morrisey boul"));
assertThat(student.getyrsInstate(), is(2));
assertThat(student.getStatus(),is(StudentStatus.OUTSTATE));

}
 
@Test
public void createIntlStudent() {
Student student = Student.createIntlStudent("Man", 2222, "Harbor point", 1, "Hyderabad, India");
assertThat(student.getName(), is("Man"));
assertThat(student.getI20num(), is(2222));
assertThat(student.getusAddr(), is("Harbor point"));
assertThat(student.getyrsInstate(), is(1));
assertThat(student.getForeignaddr(), is("Hyderabad, India"));
assertThat(student.getStatus(),is(StudentStatus.INTL));
}

}