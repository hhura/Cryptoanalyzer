package FileOperations;

import Menu.Emenu;

public class FileDecrypted implements FileOperation {
    @Override
    public void operation() {
        System.out.println(Emenu.DECRYPTED);
    }

    @Override
    public boolean applicable(Emenu emenu) {
        return emenu == Emenu.DECRYPTED;
    }
}
