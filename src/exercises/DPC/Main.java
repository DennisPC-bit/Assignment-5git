package exercises.DPC;

import exercises.DPC.Gui.MainMenu;
import exercises.DPC.bll.PersonManager;

public class Main {
    private static PersonManager pm = new PersonManager();

    public static void main(String[] args) {
	new MainMenu(pm).run();
    }
}
