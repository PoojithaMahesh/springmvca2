package studenmvcs2.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import studenmvcs2.dto.Student;
@Repository
public class StudentDao {
	
	@Autowired
	private EntityManager entityManager;
	
	public void saveStudent(Student student) {
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();
	}

	public List<Student> getAllStudents() {
		Query query=entityManager.createQuery("select s from Student s");
		return query.getResultList();
	}

	public void deleteStudentById(int id) {
		Student dbStudent=entityManager.find(Student.class, id);
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.remove(dbStudent);
		entityTransaction.commit();
		
	}

	public Student findStudent(int id) {
		// TODO Auto-generated method stub
		return entityManager.find(Student.class, id);
	}

	public void updateStudent(Student student) {
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(student);
		entityTransaction.commit();
		
	}

}
