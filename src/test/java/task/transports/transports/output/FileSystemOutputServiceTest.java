package task.transports.transports.output;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import task.transports.transports.TestingResources;

import java.io.File;
import java.util.Objects;

class FileSystemOutputServiceTest {

    FileSystemOutputService fileSystemOutputService;

    private File outputDirectory;

    @BeforeEach
    void setUp() {
        fileSystemOutputService = new FileSystemOutputService();
        cleanOutputDirectory();
    }

    @AfterEach
    void tearDown() {
        cleanOutputDirectory();
    }

    @Test
    void processOutput() {
        outputDirectory = new File(TestingResources.OUTPUT_PATH);
        fileSystemOutputService.setPath(TestingResources.OUTPUT_PATH);
        final String fileName = "out_file";
        fileSystemOutputService.processOutput(fileName, TestingResources.createTransportSummary());
        File[] outputDirectoryFiles = outputDirectory.listFiles();

        assert outputDirectoryFiles != null;
        Assertions.assertEquals(1, outputDirectoryFiles.length);
        Assertions.assertEquals(fileSystemOutputService.getOUTPUT_JSON_FILENAME_PREFIX() + fileName,
                                outputDirectoryFiles[0].getName());
    }

    private void cleanOutputDirectory() {
        outputDirectory = new File(TestingResources.OUTPUT_PATH);
        for (File file : Objects.requireNonNull(outputDirectory.listFiles())) {
            if (!file.isDirectory()) {
                file.delete();
            }
        }
    }
}