package FileOperations;

import Menu.Emenu;

import java.util.List;

public class FileExecutor {
    private final List<FileOperation> fileOperations = List.of(new FileEncrypted(), new FileDecrypted(), new FileHacking());

    public void execute(Emenu emenu) {
        for (FileOperation fileOperation : fileOperations) {
            if (fileOperation.applicable(emenu)) {
                fileOperation.operation();
            }
        }
    }
}
