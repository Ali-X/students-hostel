package ua.ali_x.studentshostel.service;

import ua.ali_x.studentshostel.model.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllSortedBySurname();
    Student create(Student student);
    Student update (Student student);
    Student getBySurname (String surname);
    void delete (Student student);


}
