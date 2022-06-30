package filevisitor;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

public class FileVisitorInt implements FileVisitor<Path> {
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs){
        System.out.println("Найден файл " + file);
        return FileVisitResult.CONTINUE;
    }

    public FileVisitResult visitFileFailed(Path file, IOException exc){
        System.out.println("Найден файл с ошибкой " + file);
        return FileVisitResult.CONTINUE;
    }

    public FileVisitResult postVisitDirectory(Path dir, IOException exc){
        System.out.println("Выходим из каталога " + dir);
        return FileVisitResult.CONTINUE;
    }

    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs){
        System.out.println("Заходим в каталог " + dir);
        return FileVisitResult.CONTINUE;
    }
}
