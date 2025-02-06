package FileOperations;

import Menu.Emenu;
import Menu.Menu;

public class FileExit implements FileOperation{
    @Override
    public void operation() {
        System.out.println("Вы вернули меню обратно");
        Menu menu = new Menu();
        menu.menuu();
    }

    @Override
    public boolean applicable(Emenu emenu) {
        return emenu == Emenu.EXIT;
    }
}
