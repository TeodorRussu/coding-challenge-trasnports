package task.transports.transports.input.datasource;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;
import java.util.Random;

import static java.util.Objects.nonNull;


class FileSystemDataSourceTest {

    FileSystemDataSource dataSource;

    private String path;

    @BeforeEach
    void setUp() {
        dataSource = new FileSystemDataSource();
    }

    @Test
    void getFilesInvalidPath() {
        dataSource.setPath(String.valueOf(new Random().nextLong()));
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            dataSource.getFiles();
        });
    }

    @Test
    void getFilesValidPath() {
        dataSource.setPath(Paths.get("").toAbsolutePath().toString());
        Assertions.assertTrue(nonNull(dataSource.getFiles()));
    }

}