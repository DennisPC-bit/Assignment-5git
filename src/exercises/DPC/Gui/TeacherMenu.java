package exercises.DPC.Gui;

import exercises.DPC.be.Person;
import exercises.DPC.be.Teacher;
import exercises.DPC.bll.PersonManager;

public class TeacherMenu extends Menu {

    public TeacherMenu(PersonManager personManager) {
        super(personManager,"Teacher menu", "Create teacher", "Read teacher by ID", "Print all Teachers", "Add subjects to teacher", "Edit teacher", "Delete");
    }

    /**
     * does whatever you choose
     * @param option the menu option that has been selected.
     */
    @Override
    protected void doAction(int option) {
        switch (option) {
            case 1 -> addTeacher();
            case 2 -> printTeacher("Write persons name or number", personManager.getPersonsInfo(getInput()));
            case 3 -> printTeachers();
            case 4 -> addSubjectToTeacher();
            case 5 -> editTeacher();
            case 6 -> removePerson("Write the name or number of a person to delete then.", personManager.removePerson(getInput()));
            case 0 -> showMainMenu();
            default -> System.out.println("Invalid input.");
            }
        }

    private void addTeacher() {
        System.out.print("Write Teacher number: ");
        int number = getOption();
        for(Person person : personManager.people)
            if(person.getId()==number)
                number=personManager.uniqueNumber(500);
        System.out.print("Write Teacher name: ");
        String name = getInput();
        System.out.print( "Write Teacher email: ");
        String email = getInput();
        System.out.print( "Write Initials: ");
        String initials = getInput();
        System.out.print( "Write Subjects: ");
        String main = getInput();
        personManager.addTeacherToList(number, name, email, main, initials);
        System.out.println("The person has been added: " + number + " " + name + " " + email + " " + main + " " + initials);
        pause();
        showMenu();
    }

    private void printTeacher(String s, String personsInfo) {
        System.out.println(s);
        System.out.println(personsInfo);
        showMenu();
    }

    private void printTeachers() {
        personManager.printTeachersInfo();
        pause();
        showMenu();
    }

    private void addSubjectToTeacher() {
        System.out.print("Write the teacher's number: ");
        for (Teacher teacher : personManager.teachersList) {
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
        for (Teacher teacher : personManager.teachersList){
            if(teacher.getId()==getOption()){
                System.out.print("write name or email to change it");
                switch (getInput().toLowerCase()){
                    case ("name") -> {
                        System.out.print("Write the name you want to change it to: ");
                        teacher.setName(getInput());
                    }
                    case("email") -> {
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

    private void removePerson(String s, String s2) {
        System.out.println(s);
        System.out.println(s2);
        showMenu();
    }
}