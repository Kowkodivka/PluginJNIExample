package ru.kowkodivka.mindustry;

import arc.util.OS;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class RustBridge {
    static {
        // Пока только для Windows
        String fileName = OS.isWindows ? "RustBridge.dll" : "RustBridge.so";

        try {
            String targetDirectory = System.getProperty("user.home") + File.separator + "Documents";
            Path targetPath = Path.of(targetDirectory, fileName);

            if (!Files.exists(targetPath)) {
                var resource = RustBridge.class.getResource("/" + fileName);
                Files.copy(resource.openStream(), targetPath, StandardCopyOption.REPLACE_EXISTING);
            }

            System.load(targetPath.toString());
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public static native String hello(String input);
}
