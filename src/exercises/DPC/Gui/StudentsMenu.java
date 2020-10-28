package exercises.DPC.Gui;

import exercises.DPC.be.Person;
import exercises.DPC.be.Student;
import exercises.DPC.bll.PersonManager;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentsMenu extends Menu {
    /**
     * Creates an instance of the class with the given header text and
     * menu options.
     */
    public StudentsMenu(PersonManager personManager) {
        super(personManager,"Students menu", "Create Student", "Read student by ID", "Print all Students", "Edit Student", "Edit GradeAVG", "Add grade", "Edit Education", "Delete");
    }

    /**
     * Does whatever you choose
     * @param option the menu option that has been selected.
     */
    @Override
    protected void doAction(int option) {
        switch (option) {
            case 1 -> addStudent();
            case 2 -> getPersonsInfo("Write persons name or number", personManager.getPersonsInfo(getInput()));
            case 3 -> printAllStudentsInfo();
            case 4 -> editStudent();
            case 5 -> setGradeAVG();
            case 6 -> addGrade();
            case 7 -> removePerson("write the name or number of a person to delete then.",personManager.removePerson(getInput()));
            case 0 -> showMainMenu();
            default -> System.out.println("Invalid input.");}
        }

    private void addStudent() {
        System.out.print("Write Student number: ");
        int number = getOption();
        for(Person person : PersonManager.people)
            if(person.getId()==number)
                number=personManager.uniqueNumber(100);
        System.out.print("Write Student name: ");
        String name = getInput();
        System.out.print("Write Student email: ");
        String email = getInput();
        System.out.print("Write grade: ");
        double grade = getOption();
        System.out.print("Write Main Subjects: ");
        String main = getInput();
        personManager.addStudentsToList(number, name, email, main, grade);
        System.out.println("The person has been added: " + number + " " + name + " " + email + " " + grade + " " + main);
        pause();
        showMenu();
    }

    private void getPersonsInfo(String s, String personsInfo) {
        System.out.println(s);
        System.out.println(personsInfo);
        showMenu();
    }

    private void printAllStudentsInfo() {
        personManager.printStudentsInfo();
        pause();
        showMenu();
    }

    private void editStudent() {
        System.out.print("Write the Students number: ");
        for (Student student : personManager.studentList){
            int number=getOption();
            if(number==student.getId()){
                System.out.printf("%n%-30s%-30s%n%-30s%n","1: Change student name", "2: Change Student Email","3: Change Students Subjects");
                switch (getOption()){
                    case 1 -> setStudentName(student);
                    case 2 -> setStudentEmail(student);
                    case 3 -> setStudentEducation(student);
                    default -> System.out.println("Invalid Input.");
                }
            }
        }
    }

    private void setStudentName(Student student) {
        System.out.print("Write the name you want to change it to: ");
        student.setName(getInput());
        System.out.println(student.getName() + " has been changed");
        showMenu();
    }

    private void setStudentEmail(Student student) {
        System.out.print("Write the email you want to change it to: ");
        student.setEmail(getInput());
        System.out.println(student.getName() + " has been changed");
        showMenu();
    }

    private void setStudentEducation(Student student) {
        System.out.print("Write what you want to change it to: ");
        student.setEducation(getInput());
        System.out.println(student.getName() + " has been changed");
        showMenu();
    }

    private void setGradeAVG() {
        System.out.print("Write studentID: ");
        for (Student student : personManager.studentList) {
            if (student.getId() == getOption()) {
                System.out.print("Write grade: ");
                student.setGradeAVG(getOption());
                System.out.println(student.getName() + "'s grade has been changed.");
                showMenu();
            }
        }
    }

    private void addGrade() {
        System.out.print("Write the students number: ");
        for (Student student : personManager.studentList){
            if(student.getId()==getOption()) {
                System.out.print("Write grade:");
                student.addGrade(getOption());
                System.out.println(student.getName() + " has been changed");
                showMenu();
            }
        }
    }

    private void removePerson(String s, String s2) {
        System.out.println(s);
        System.out.println(s2);
        showMenu();
    }
}