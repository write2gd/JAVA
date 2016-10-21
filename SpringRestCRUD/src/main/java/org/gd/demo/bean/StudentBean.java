package org.gd.demo.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import org.gd.demo.entity.Course;


/**
 *
 *
 * @author Gouranga Das
 */

public class StudentBean implements Serializable {

    private long id;  
    private String studentName;

    private Set<String> courses = new HashSet<String>();

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

    public Set<String> getCourses() {
        return courses;
    }

    public void setCourses(Set<String> courses) {
        this.courses = courses;
    }

    public void addCourse(Course course) {
        courses.add(course.getCourseName());
    }
}
