package exercises.DPC.Gui;

public class MainMenu extends Menu {
    PeopleManager pm = new PeopleManager();
    TeacherMenu tm = new TeacherMenu("Teacher menu", "TeacherMenu", "Create", "Read", "Print all Teachers", "Add subjects to teacher", "Edit teacher", "Delete");
    StudentsMenu sm = new StudentsMenu("Students menu", "Create", "Read", "Print all Students", "Edit Student", "Edit GradeAVG", "Add grade", "Delete", "Go Back");
    public MainMenu() {
        super("Main menu", "Students Menu", "Teachers Menu", "Print all Assets");
    }

    /**
     * Does whatever you choose
     * @param option the menu option that has been selected.
     */
    @Override
    protected void doAction(int option) {
        switch (option) {
            case (1) -> sm.run();
            case (2) -> tm.run();
            case (3) -> {
                pm.printPeoplesInfo();
                showMenu();
            }
        }
    }
}