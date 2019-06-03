package edu.umb.cs.cs680.hw02;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

public class StudentTest {
	
@Test
public void createInStateStudent() {
Student s = Student.createInStateStudent("Raveena", "75 Peterborough St", 2);
String actual = s.getName() ;
String expected = "Raveena"; 
assertThat(actual, is(expected));
}

@Test
public void createOutStateStudent() {
Student s = Student.createOutStateStudent("Arvind", "100 Beacon St", 3);
String actual = s.getUsAddr();
String expected = "100 Beacon St";
assertThat(actual, is(expected));
}
 
@Test
public void createIntlStudent() {
Student s = Student.createIntlStudent("Raman", 12345, "50 Jersey St", 1, "House no. 619/9 Faridabad, Haryana,121006, India");
int actual = s.getI20num();
int expected = 12345;
assertThat(actual, is(expected));
}

}