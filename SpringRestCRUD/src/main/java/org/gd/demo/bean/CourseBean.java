package org.gd.demo.bean;


import java.io.Serializable;
import java.util.Set;


/**
 *
 *
 * @author Gouranga Das
 */

public class CourseBean implements Serializable {

   
    private long id;
    private String courseName;
    private String studentName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }


}
