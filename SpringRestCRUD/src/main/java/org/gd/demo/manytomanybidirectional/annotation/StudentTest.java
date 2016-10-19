package org.gd.demo.manytomanybidirectional.annotation;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 *
 * @author Gouranga Das
 */
@Entity(name = "Student")
@Table(name = "STUDENTS")
public class StudentTest implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "STUDENT_ID")
    private long id;

    @Column(name = "STUDENT_NAME")
    private String studentName;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "STUDENT_COURSE", joinColumns = @JoinColumn(name = "STUDENT_ID"), inverseJoinColumns = @JoinColumn(name = "COURSE_ID"))
    private Set<CourseTest> courses = new HashSet<CourseTest>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Set<CourseTest> getCourses() {
        return courses;
    }

    public void setCourses(Set<CourseTest> courses) {
        this.courses = courses;
    }

    public void addCourse(CourseTest course) {
        courses.add(course);
    }
}
