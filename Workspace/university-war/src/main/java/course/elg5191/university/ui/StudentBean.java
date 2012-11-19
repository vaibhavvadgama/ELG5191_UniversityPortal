package course.elg5191.university.ui;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import course.elg5191.university.beans.entity.Student;
import course.elg5191.university.beans.session.StudentSession;

@ManagedBean(name = "studentBean")
@SessionScoped
public class StudentBean {
	@EJB
	private StudentSession studentSess;
	private String newStudentName;
	private Date newStudentBirth;
	private String searchStudentName;
	private Student searchStudentResult;

	public Student getSearchStudentResult() {
		return searchStudentResult;
	}

	public void setSearchStudentResult(Student searchStudentResult) {
		this.searchStudentResult = searchStudentResult;
	}

	public String getSearchStudentName() {
		return searchStudentName;
	}

	public void setSearchStudentName(String searchStudentName) {
		this.searchStudentName = searchStudentName;
	}

	public Date getNewStudentBirth() {
		return newStudentBirth;
	}

	public void setNewStudentBirth(Date newStudentBirth) {
		this.newStudentBirth = newStudentBirth;
	}

	public String getNewStudentName() {
		return newStudentName;
	}

	public void setNewStudentName(String newStudentName) {
		this.newStudentName = newStudentName;
	}

	public List<Student> getStudents() 
	{
		return studentSess.getAllStudents();
		//return null;
	}

	public void createStudent(ActionEvent event) {
		Student student = new Student();
		student.setBirthDate(newStudentBirth);
		student.setName(newStudentName);
		studentSess.addStudent(student);
	}

	public void searchStudentName(ActionEvent event) {
		searchStudentResult = studentSess.getStudentByName(searchStudentName);
	}
}