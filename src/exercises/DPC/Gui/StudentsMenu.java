package exercises.DPC.Gui;

import exercises.DPC.Data.Person;
import exercises.DPC.Data.Student;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentsMenu extends Menu {
PeopleManager pm = new PeopleManager();
    /**
     * Creates an instance of the class with the given header text and
     * menu options.
     *
     * @param header    The header text of the menu.
     * @param menuItems The list of menu items texts.
     */
    public StudentsMenu(String header, String... menuItems) {
        super("Students menu", "Create Student", "Read student by ID", "Print all Students", "Edit Student", "Edit GradeAVG", "Add grade", "Edit Education", "Delete");
    }


    /**
     * Does whatever you choose
     * @param option the menu option that has been selected.
     */
    @Override
    protected void doAction(int option) {
        switch (option) {
            case 0 -> showMainMenu();
            case 1 -> createStudent();
            case 2 -> getPersonsInfo();
            case 3 -> printStudentsInfo();
            case 4 -> editStudent();
            case 5 -> setGrade();
            case 6 -> addGrade();
            case 7 -> delPerson();
            default -> System.out.println("Invalid input.");}
        }

    private void createStudent() {
        System.out.print("Write Student number: ");
        int number = getOption();
        for(Person person : pm.people)
            if(person.getId()==number)
                number=pm.uniqueNumber(100);
        System.out.print("Write Student name: ");
        String name = getInput();
        System.out.print("Write Student email: ");
        String email = getInput();
        System.out.print("Write grade: ");
        double grade = getGrade();
        System.out.print("Write Main Subjects: ");
        String main = getInput();
        pm.addStudentsToList(number, name, email, main, grade);
        System.out.println("The person has been added: " + number + " " + name + " " + email + " " + grade + " " + main);
        pause();
        showMenu();
    }

    private void getPersonsInfo() {
        System.out.println("Write persons name or number");
        System.out.println(pm.getPersonsInfo(getInput()));
        pause();
        showMenu();
    }

    private void printStudentsInfo() {
        pm.printStudentsInfo();
        pause();
        showMenu();
    }
    private void editStudent() {
        System.out.print("Write the Students number: ");
        for (Student student : pm.studentList){
            int number=getOption();
            if(number==student.getId()){
                System.out.printf("%s%n%s%n%s%n%s%n", "Edit Menu","1: Name", "2: Email", "3: Education");
                switch (getOption()){
                    case (1) -> {
                        System.out.print("Write the name you want to change it to: ");
                        student.setName(getInput());
                    }
                    case(2) -> {
                        System.out.print("Write the email you want to change it to: ");
                        student.setEmail(getInput());
                        System.out.println(student.getName() + " has been changed");
                    }
                    case 3 -> {System.out.print("Write what you want to change it to: ");
                        String edu = getInput();
                        student.setEducation(edu);
                        System.out.println(student.getName() + " has been changed");
                    }
                    default -> System.out.println("Invalid input.");
                }
            }
        }
        showMenu();
    }

    private void addGrade() {
        System.out.print("Write the students number: ");
        for (Student student : pm.studentList){
            if(student.getId()==getOption()) {
                System.out.print("Write grade:");
                student.addGrade(getGrade());
                System.out.println(student.getName() + " has been changed");
                showMenu();
            }
        }
    }

    private void setGrade() {
        System.out.print("Write studentID: ");
        for (Student student : pm.studentList) {
            if (student.getId() == getOption()) {
                System.out.print("Write grade: ");
                student.setGradeAVG(getGrade());
                System.out.println(student.getName() + "'s grade has been changed.");
                showMenu();
            }
        }
    }

    private void delPerson() {
        System.out.println("write the name or number of a person to delete then.");
        System.out.println(pm.removePerson(getInput()));
        showMenu();
    }
}