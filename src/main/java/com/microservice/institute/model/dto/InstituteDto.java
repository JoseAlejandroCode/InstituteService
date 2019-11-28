package com.microservice.institute.model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class InstituteDto implements Serializable {
  private String id;
  private String name;

  private List<TeacherDto> teachers;
  private List<StudentDto> students;
  private List<CourseDto> courses;

  public InstituteDto() {
    this.students = new ArrayList<>();
    this.courses = new ArrayList<>();
    this.teachers = new ArrayList<>();
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<StudentDto> getStudents() {
    return students;
  }

  public void addStudent(StudentDto student) {
    this.students.add(student);
  }

  public void setStudents(List<StudentDto> students) {
    this.students = students;
  }

  public List<CourseDto> getCourses() {
    return courses;
  }

  public void setCourses(List<CourseDto> courses) {
    this.courses = courses;
  }

  public void addCourse(CourseDto course) {
    this.courses.add(course);
  }

  public List<TeacherDto> getTeachers() {
    return teachers;
  }

  public void setTeachers(List<TeacherDto> teachers) {
    this.teachers = teachers;
  }

  public void addTeacher(TeacherDto teacher) {
    this.teachers.add(teacher);
  }
}
