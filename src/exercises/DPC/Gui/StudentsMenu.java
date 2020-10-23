package exercises.DPC.Gui;

import exercises.DPC.Data.Student;

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
            case (1) -> {
                System.out.print("Write Student number: ");
                int number = getOption();
                System.out.print("Write Student name: ");
                String name = getInput();
                System.out.print("Write Student email: ");
                String email = getInput();
                System.out.print("Write grade: ");
                double grade = getOption();
                System.out.print("Write Main Subjects: ");
                String main = getInput();
                pm.addStudentsToList(number, name, email, main, grade);
                System.out.println("The person has been added: " + number + " " + name + " " + email + " " + grade + " " + main);
                showMenu();
            }
            case (2) -> {
                System.out.println("Write persons name or number");
                System.out.println(pm.getPersonsInfo(getInput()));
                showMenu();
            }
            case (3) -> {
                pm.printStudentsInfo();
                showMenu();
            }
            case (4) -> {
                System.out.print("Write the Students number: ");
                for (Student student : pm.studentList){
                    int number=getOption();
                    if(number==student.getId()){
                        System.out.print("write name or email to change it: ");
                        switch (getInput().toLowerCase()){
                            case ("name") -> {
                                System.out.print("Write the name you want to change it to: ");
                                student.setName(getInput());
                                showMenu();
                            }
                            case("email") -> {
                                System.out.print("Write the email you want to change it to: ");
                                student.setEmail(getInput());
                                showMenu();
                            }
                        }
                    }
                }
            }
            case (5) -> {
                System.out.print("Write studentID: ");
                for (Student student : pm.studentList) {
                    if (student.getId() == getOption()) {
                        System.out.print("Write grade: ");
                        student.setGradeAVG(getOption());
                        System.out.println(student.getName() + "'s grade has been changed.");
                        showMenu();
                    }
                }
            }
            case (6) -> {
                System.out.print("Write the students number: ");
                for (Student student : pm.studentList){
                    if(student.getId()==getOption()) {
                        System.out.print("Write grade:");
                        student.addGrade(getOption());
                        System.out.println(student.getName() + " has been changed");
                        showMenu();
                    }
                }
            }
            case(7)->{
                System.out.print("Write the Students number: ");
                int number=getOption();
                for (Student student : pm.studentList){
                if(number==student.getId()) {
                    System.out.print("Write what you want to change it to: ");
                    String edu = getInput();
                    student.setEducation(edu);
                    System.out.println(student.getName() + " has been changed");
                }
                showMenu();
                }
            }
            case (8) -> {
                System.out.println("write the name or number of a person to delete then.");
                System.out.println(pm.removePerson(getInput()));
                showMenu();
            }
            default ->{ clear();
            System.out.printf("%n%s%n%s%n%s%n%s%n%s%n","Main menu","1: Students Menu", "2: Teachers Menu", "3: Print all Assets","0: Exit");}
        }
    }
}