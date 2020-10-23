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
            case (1) -> {
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
                run();
            }
            case (2) -> {
                System.out.println("Write persons name or number");
                System.out.println(pm.getPersonsInfo(getInput()));
                showMenu();
            }
            case (3) -> {
                pm.printTeachersInfo();
                showMenu();
            }
            case (4) -> {
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
            case (5) -> {
                System.out.print("Write the number of the teacher you want to edit: ");
                for (Teacher teacher : pm.teachersList){
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
                        }
                    }
                }
                showMenu();
            }
            case (6) -> {
                System.out.println("Write the name or number of a person to delete then.");
                System.out.println(pm.removePerson(getInput()));
                showMenu();
            }
            case (0) -> { clear();
                System.out.printf("%n%s%n%s%n%s%n%s%n%s%n","Main menu","1: Students Menu", "2: Teachers Menu", "3: Print all Assets","0: Exit");}
            default -> System.out.println("something went wrong");
            }
        }
    }