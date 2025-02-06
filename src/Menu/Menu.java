package Menu;

import FileOperations.FileExecutor;

import java.util.Scanner;

public class Menu {
    public void menuu() {
        FileExecutor fileExecutor = new FileExecutor();
        menuVariants();
        var console = new Scanner(System.in);
        String variant = console.nextLine().toUpperCase();
        fileExecutor.execute(Emenu.valueOf(variant));
    }


    private void menuVariants() {
        System.out.println("Выберите пожалуйста опцию:");
        int i = 0;
        for (Emenu menu : Emenu.values()) {
            i++;
            System.out.println(i + ": " + menu);
        }
        System.out.print("Введите назвние опции: ");
    }

}


