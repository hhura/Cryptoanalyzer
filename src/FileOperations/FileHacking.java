package FileOperations;

import Menu.Emenu;

public class FileHacking implements FileOperation {
    @Override
    public void operation() {
        System.out.println(Emenu.HACKING);
    }

    @Override
    public boolean applicable(Emenu emenu) {
        return emenu == Emenu.HACKING;
    }
}
