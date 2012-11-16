package course.elg5191.university.beans.session;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import course.elg5191.university.beans.entity.Student;

@Stateless(name = "StudentSession")
public class StudentSessionImpl implements StudentSession {
	@PersistenceContext
	EntityManager em;

	@Override
	public List<Student> getAllStudents() {
		Query query = em.createQuery("select s from Student s");
		@SuppressWarnings("unchecked")
		List<Student> allStudents = query.getResultList();
		return allStudents;
	}

	@Override
	public Student getStudentByName(String name) {
		Query query = em
				.createQuery("select s from Student s where s.name=:name");
		query = query.setParameter("name", name);
		@SuppressWarnings("unchecked")
		List<Student> students = query.getResultList();
		// assumes we have only one student with a given name
		// not something which should be assumed in real software (or a course
		// project)
		if (students.size() > 0)
			return students.get(0);
		else
			return null;
	}

	@Override
	public void addStudent(Student student) {
		em.persist(student);
	}
}