package ua.ali_x.studentshostel.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.ali_x.studentshostel.model.Student;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface StudentDao extends CrudRepository<Student, Integer> {

    @Query("SELECT s FROM Student s WHERE s.surname = :surname")
    Student findStudentBySurname(@Param("surname") String surname);

}
