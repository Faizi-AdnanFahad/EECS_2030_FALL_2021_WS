package model;

public class StudentManagementSystem {
	
	private Student[] arrayOfStudents;
	private int noS;
	
	public StudentManagementSystem() {
		this.arrayOfStudents = new Student[10];
	}
	
	public Student[] getStudents() {
		Student[] students = new Student[this.noS];
		for (int i = 0; i < this.noS; i ++) {
			students[i] = this.arrayOfStudents[i];
		}
		return students;
	}
	
	public void addStudent(Student s) {
		this.arrayOfStudents[this.noS] = s;
		this.noS ++;
	}
	
	public void registerAll(Course c) {
		for (int i = 0; i < this.noS; i ++) {
			this.arrayOfStudents[i].register(c);
		}
	}
}