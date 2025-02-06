package FileOperations;

import Menu.Emenu;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;

public class FileEncrypted implements FileOperation {

    @Override
    public void operation() {
        List<Character> alphabeet = Alphabet.createAlphabet();
        var console = new Scanner(System.in);
        Path sourcePath = getSourse(console);//Получаем наш файл
        Path resultPath = getResult();//Туда куда зашифровывается
        int key = getKey(console);//Ключ шифровки
        encrypting(sourcePath, resultPath, alphabeet, key);//Сам шифратор
        System.out.println("Файл зашифрован");


    }

    @Override
    public boolean applicable(Emenu emenu) {
        return emenu == Emenu.ENCRYPTED;
    }

    private Path getSourse(Scanner scanner) {//То что надо зашифровать
        System.out.println("Введите путь файла который нужно зашифровать: ");
        return Paths.get(scanner.nextLine());
    }

    private Path getResult() {//То куда попадет зашифрованный текст
        return Paths.get("C:\\Users\\Gigabyte\\IdeaProjects\\CryptoAnalyzer\\src\\Sources\\encrypt.txt");
    }

    private int getKey(Scanner scanner) {//Ключ для шифровки
        System.out.println("Введите ключ для Шифровки: ");
        return scanner.nextInt();
    }

    private void encrypting(Path soursePath, Path resultPath, List<Character> alphabeet, int key) {//Шифратор
        try (FileChannel source = FileChannel.open(soursePath, StandardOpenOption.READ);
             FileChannel resultt = FileChannel.open(resultPath, StandardOpenOption.WRITE)) {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            while (source.read(buffer) != -1) {
                buffer.flip();
                while (buffer.hasRemaining()){
                    byte b = buffer.get();
                    char c = (char) b;
                    if (alphabeet.contains(c)) {
                        int index = alphabeet.indexOf(c);
                        int newIndex = (index + key);
                        char encrypted = alphabeet.get(newIndex);
                        resultt.write(ByteBuffer.wrap(new byte[] { (byte) encrypted }));
                    } else {
                        resultt.write(ByteBuffer.wrap(new byte[] { (byte) c }));
                    }
                }
                buffer.clear();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}