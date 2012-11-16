package course.elg5191.university.beans.session;

import java.util.List;
import javax.ejb.Local;
import course.elg5191.university.beans.entity.Student;

@Local
public interface StudentSession {
	public List<Student> getAllStudents();

	public Student getStudentByName(String name);

	public void addStudent(Student student);
}
