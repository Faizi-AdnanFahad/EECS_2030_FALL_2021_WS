package model;

public class Student {
	protected String name;
	protected Course[] arrayOfCourses;
	protected int noC;
	
	public Student() {
		this.arrayOfCourses = new Course[10];
	}
	
	public Course[] getCourses() {
		Course[] courses = new Course[this.noC];
		for (int i = 0; i < this.noC; i ++) {
			courses[i] = this.arrayOfCourses[i];
		}
		return courses;
	}
	
	public double getTuition() {
		double result = 0;
		for (int i = 0; i < this.noC; i ++) {
			result += this.arrayOfCourses[i].getFee();
		}
		return result;
	}
	
	public void register(Course c) {
		this.arrayOfCourses[this.noC] = c;
		this.noC ++;
	}
	
	public void drop(Course c) {
		int index = -1;
		
		for (int i = 0; i < this.noC; i ++) {
			if (this.arrayOfCourses[i].getCourseName().equals(c.getCourseName())) {
				this.arrayOfCourses[i] = null;
				index = i;
				break;
			}
		}
		
		if (index != -1) {
			for (int i = index; i < this.noC; i ++) {
				if (i < this.noC - 1) {
					this.arrayOfCourses[index] = this.arrayOfCourses[i + 1];
				}
				else {
					this.arrayOfCourses[i] = null;
				}
			}
			this.noC -= 1;
		}		
	}
}