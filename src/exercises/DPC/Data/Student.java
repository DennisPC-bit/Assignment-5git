package exercises.DPC.Data;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
    private String education;
    private double gradeAVG;
    private List<Double> grades = new ArrayList<>();

    public Student(int id, String name, String email, String education, double gradeAVG){
        super(id, name, email);
        this.education=education;
        grades.add(gradeAVG);
        this.gradeAVG=getGradeAVG();
    }

    public Student(int id, String name, String email){
        super(id,name,email);
    }

    /**
     * Returns the students id
     * @return
     */
    @Override
    public int getId() {
        return super.getId();
    }

    /**
     * Returns The email
     * @return
     */
    @Override
    public String getEmail() {
        return super.getEmail();
    }

    /**
     * Returns the name
     * @return
     */
    @Override
    public String getName() {
        return super.getName();
    }

    /**
     * Returns the education
     * @return
     */
    public String getEducation() {
        return education;
    }

    /**
     * Calculates the grade avg and returns it
     * @return
     */
    public double getGradeAVG() {
        double gradeTotal=0;
        for (Double grade: grades){
            gradeTotal+=grade;
        }
        return gradeTotal/grades.size();
    }

    /**
     * Adds a grade to the above avg grad calc
     * @param grade
     */
    public void addGrade(double grade){
        grades.add(grade);
    }

    /**
     * Sets the education
     * @param education
     */
    public void setEducation(String education) {
        this.education = education;
    }

    /**
     * Resets the gradeAVG to a value
     * @param gradeAVG
     */
    public void setGradeAVG(double gradeAVG) {
        grades.clear();
        grades.add(gradeAVG);
    }

    public String toString(Student person){
        return person.getId() + " " + person.getName() + " " + person.getEmail() + " " + person.getEducation() + " " + person.getGradeAVG();
    }
}
