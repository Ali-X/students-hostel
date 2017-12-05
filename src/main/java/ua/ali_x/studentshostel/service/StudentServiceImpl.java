package ua.ali_x.studentshostel.service;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.ali_x.studentshostel.dao.StudentDao;
import ua.ali_x.studentshostel.model.Student;

import java.util.Comparator;
import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;
    @Override
    public List<Student> getAllSortedBySurname() {
        List<Student> students = Lists.newArrayList(studentDao.findAll());
        students.sort((o1, o2) -> o1.getSurname().compareToIgnoreCase(o2.getSurname()));
        return students;
    }

    @Override
    public Student create(Student student) {
        return studentDao.save(student);
    }

    @Override
    public Student update(Student student) {
        return studentDao.save(student);
    }

    @Override
    public Student getBySurname(String surname) {
        return studentDao.findStudentBySurname(surname);
    }

    @Override
    public void delete(Student student) {
        studentDao.delete(student);
    }
}
