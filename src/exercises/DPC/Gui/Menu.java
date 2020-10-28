package exercises.DPC.Gui;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Abstract class implementing the basic functionality of a console based
 * menu class. A menu can be created by sub-classing this class and implement
 * the abstract method doAction(option).
 *
 * The constructor of the sub-class must invoke the super-class constructor by
 * the instruction
 *
 *          super(“some header”, “menuoption1", "menuoption2");
 *
 * Note, that this instruction must be the first instruction of the sub-class
 * constructor.
 *
 * @author bhp
 */
public abstract class Menu {
    // value used to exit the menu.
    // the value can be changed by the sub-class constructor.
    protected int EXIT_OPTION = 0;

    // The menu header text
    private String header;

    // The list of menu options texts.
    private String[] menuItems;

    PeopleManager pm= new PeopleManager();

    /**
     * Abstract method stating what should be done, when a
     * menu option is selected.
     * The method must be overridden by the sub-class.
     * @param option the menu option that has been selected.
     */
    protected abstract void doAction(int option);


    /**
     * Creates an instance of the class with the given header text and
     * menu options.
     * @param header    The header text of the menu.
     * @param menuItems The list of menu items texts.
     */
    public Menu(String header, String... menuItems)
    {
        this.header = header;
        this.menuItems = menuItems;
    }

    /**
     * Executes the menu until the EXIT_OPTION has been selected.
     * This is an implementation of the Template Method design pattern.
     */
    public void run()
    {
        boolean done = false;
        showMenu();
        while (!done)
        {
            int option = getOption();
            doAction(option);
            if (option == EXIT_OPTION)
            {
                done = true;
            }
        }
    }
    /**
     * Returns a valid menu-option input from the keyboard.
     * The method continues prompting for an option value, until
     * a valid option has been input.
     * @return A valid menu option.
     */
    public int getOption()
    {
        int output=-1;
        try {
            Scanner asd = new Scanner(System.in);
            output = asd.nextInt();
            return output;
        }
        catch(InputMismatchException e){
            System.out.println("That's not a valid input.");
            getOption();
        }
        return output;
    }

    /**
     * Prints out a console menu
     with a header text and a list
     * of menu options. The menu
     options will be assigned the numbers
     * from 1 to the number of
     options in the menu.
     */
    public void showMenu()
    {
        System.out.println(header);
        int i = 1;
        for(String menuitem: menuItems){
            System.out.printf("%-30s",i + ": " + menuitem);
            if(i%2==0)
                System.out.printf("%n");
            i++;
        }
        System.out.printf("%-30s%n", EXIT_OPTION + ": Exit");
    }

    /**
     * Waits until the 'enter' key is pressed.
     */
    protected void pause() {
        System.out.println("Press \"ENTER\" to continue...");
        try {
            System.in.read();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public String getInput() {
        Scanner inputScanner = new Scanner(System.in);
        return inputScanner.nextLine();
    }

    /**
     * Clears the screen by writing several empty lines.
     */
    protected void clear()
    {
        System.out.printf("%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n");
    }

    public void showMainMenu(){ clear();
        System.out.printf("%n%s%n%-30s%-30s%n%-30s%-30s%n","Main menu","1: Students Menu", "2: Teachers Menu", "3: Print all Assets","0: Exit");}
}