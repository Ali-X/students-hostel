package ua.ali_x.studentshostel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.ali_x.studentshostel.model.Student;
import ua.ali_x.studentshostel.service.StudentService;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Student> getAll() {
        return studentService.getAllSortedBySurname();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Student save(@RequestBody Student student) {
        studentService.create(student);
        return student;
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Student update(@RequestBody Student student) {
        studentService.update(student);
        return student;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void delete(@RequestBody Student student) {
        studentService.delete(student);
    }

    @RequestMapping(value = "/find/surname", method = RequestMethod.GET)
    public Student findBySurname(@RequestParam("surname") String surname) {
        return studentService.getBySurname(surname);
    }

}
