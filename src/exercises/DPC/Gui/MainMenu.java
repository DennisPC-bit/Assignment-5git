package exercises.DPC.Gui;

import exercises.DPC.bll.PersonManager;

public class MainMenu extends Menu {

    public MainMenu(PersonManager personManager) {
        super(personManager,"Main menu", "Students Menu", "Teachers Menu", "Print all Assets");
    }
    /**
     * Does whatever you choose
     * @param option the menu option that has been selected.
     */
    @Override
    protected void doAction(int option) {
        switch (option) {
            case 1 -> new StudentsMenu(personManager).run();
            case 2 -> new TeacherMenu(personManager).run();
            case 3 -> {
                personManager.printPeoplesInfo();
                pause();
                showMenu();
            }
            case 0 -> System.out.println("Session ended. Goodbye :)");
            default -> {System.out.println("Invalid input.");
            showMenu();}
        }
    }
}