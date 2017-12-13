package ua.ali_x.studentshostel.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Room")
public class Room {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "roomnum")
    private Integer roomNumber;
    @Column(name = "ROOMINESS")
    private Integer studentMaxNumber;
    @OneToMany(mappedBy = "room", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Student> students;
    @Formula("select count(*) from Student s where s.roomnum=id")
    private Integer studentCurNumber;
    @Transient
    private Integer persentageLoading;

    public Integer getStudentCurNumber() {
        return studentCurNumber;
    }

    public void setStudentCurNumber(Integer studentCurNumber) {
        this.studentCurNumber = studentCurNumber;
    }

    public Integer getPersentageLoading() {
        return persentageLoading;
    }

    public void setPersentageLoading(Integer persentageLoading) {
        this.persentageLoading = persentageLoading;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Integer getStudentMaxNumber() {
        return studentMaxNumber;
    }

    public void setStudentMaxNumber(Integer studentMaxNumber) {
        this.studentMaxNumber = studentMaxNumber;
    }
}
