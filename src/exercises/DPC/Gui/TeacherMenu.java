package exercises.DPC.Gui;

import exercises.DPC.Data.Person;
import exercises.DPC.Data.Teacher;

public class TeacherMenu extends Menu {
    PeopleManager pm = new PeopleManager();
    /**
     * Creates an instance of the class with the given header text and
     * menu options.
     *
     * @param header    The header text of the menu.
     * @param menuItems The list of menu items texts.
     */
    public TeacherMenu(String header, String... menuItems) {
        super("Teacher menu", "Create teacher", "Read teacher by ID", "Print all Teachers", "Add subjects to teacher", "Edit teacher", "Delete");
    }

    /**
     * does whatever you choose
     * @param option the menu option that has been selected.
     */
    @Override
    protected void doAction(int option) {
        switch (option) {
            case 0 -> showMainMenu();
            case 1 -> createTeacher();
            case 2 -> getPersonsInfo();
            case 3 -> printTeachers();
            case 4 -> addSubject();
            case 5 -> editTeacher();
            case 6 -> deleteTeacher();
            default -> System.out.println("Invalid input.");
        }
    }

    private void createTeacher() {
        System.out.print("Write Teacher number: ");
        int number = getOption();
        for(Person person : pm.people)
            if(person.getId()==number)
                number=pm.uniqueNumber(500);
        System.out.print("Write Teacher name: ");
        String name = getInput();
        System.out.print( "Write Teacher email: ");
        String email = getInput();
        System.out.print( "Write Initials: ");
        String initials = getInput();
        System.out.print( "Write Subjects: ");
        String main = getInput();
        pm.addTeacherToList(number, name, email, main, initials);
        System.out.println("The person has been added: " + number + " " + name + " " + email + " " + main + " " + initials);
        pause();
        showMenu();
    }

    private void getPersonsInfo() {
        System.out.println("Write persons name or number");
        System.out.println(pm.getPersonsInfo(getInput()));
        showMenu();
    }

    private void printTeachers() {
        pm.printTeachersInfo();
        pause();
        showMenu();
    }

    private void addSubject() {
        System.out.print("Write the teacher's number: ");
        for (Teacher teacher : pm.teachersList) {
            if (teacher.getId() == getOption()) {
                System.out.print("Write subject you want to add: ");
                teacher.addSubjects(getInput());
                System.out.println(teacher.getName() + "has been changed");
            }
            showMenu();
        }
    }

    private void editTeacher() {
        System.out.print("Write the number of the teacher you want to edit: ");
        for (Teacher teacher : pm.teachersList){
            if(teacher.getId()==getOption()){
                System.out.printf("%s%n%s%n%s%n", "Edit Menu","1: Name", "2: Email");
                switch (getOption()){
                    case (1) -> {
                        System.out.print("Write the name you want to change it to: ");
                        teacher.setName(getInput());
                    }
                    case(2) -> {
                        System.out.print("Write the email you want to change it to: ");
                        teacher.setEmail(getInput());
                        System.out.println(teacher.getName() + " has been changed");
                    }
                    default -> System.out.println("Invalid input.");
                }
            }
        }
        showMenu();
    }

    private void deleteTeacher() {
        System.out.println("Write the name or number of a person to delete then.");
        System.out.println(pm.removePerson(getInput()));
        showMenu();
    }
}