package FileOperations;

import Menu.Emenu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
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
        System.out.print("Введите путь файла который нужно зашифровать: ");
        return Paths.get(scanner.nextLine());
    }

    private Path getResult() {//То куда попадет зашифрованный текст
        return Paths.get(("C:\\Users\\Gigabyte\\IdeaProjects\\CryptoAnalyzer\\src\\Sources\\encrypt.txt"));
    }

    private int getKey(Scanner scanner) {//Ключ для шифровки
        System.out.print("Введите ключ для Шифровки: ");
        return scanner.nextInt();
    }

    private void encrypting(Path sourcePath, Path resultPath, List<Character> alphabet, int key) {
        try (BufferedReader source = Files.newBufferedReader(sourcePath, StandardCharsets.UTF_8);
             BufferedWriter result = Files.newBufferedWriter(resultPath, StandardCharsets.UTF_8)) {
            int char1;
            while ((char1 = source.read()) != -1) {
                    char c = (char) char1;
                    int index = alphabet.indexOf(c);
                    if (index != -1) {
                        int newIndex = Math.floorMod(index + key, alphabet.size());
                        result.write(alphabet.get(newIndex));
                    } else {
                        result.write(c);
                    }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}