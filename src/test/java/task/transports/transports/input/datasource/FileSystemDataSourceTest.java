package task.transports.transports.input.datasource;

import static java.util.Objects.nonNull;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import task.transports.transports.TestingResources;

import java.nio.file.Paths;


class FileSystemDataSourceTest {


    FileSystemDataSource dataSource;

    @BeforeEach
    void setUp() {
        dataSource = new FileSystemDataSource();
    }

    @Test
    void getFilesInvalidPath() {
        dataSource.setPath(Paths.get(TestingResources.VALID_INPUT_PATH).toAbsolutePath().toString());
        dataSource.setFileName(TestingResources.EMPTY_STRING);
        Assertions.assertThrows(IllegalArgumentException.class, () -> dataSource.getInputFile());
    }

    @Test
    void getFilesValidPath() {
        dataSource.setPath(Paths.get(TestingResources.VALID_INPUT_PATH).toAbsolutePath().toString());
        dataSource.setFileName(TestingResources.VALID_INPUT_FILE_NAME);
        Assertions.assertTrue(nonNull(dataSource.getInputFile()));
    }

}