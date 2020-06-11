package task.transports.transports.controller;

import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.util.ReflectionTestUtils;
import task.transports.transports.TestingResources;

import java.io.File;
import java.util.Objects;

@SpringBootTest
@ActiveProfiles(profiles = "fs")
class TransportControllerTest {

    @Autowired
    TransportController controller;
    private File outputDirectory;

    @BeforeEach
    private void setUp() {
        //clean output directory
        cleanDirectory();
    }

    @AfterEach
    void tearDown() {
        //clean output directory
        cleanDirectory();
    }

    @SneakyThrows
    @Test
    void processValidFile() {
        File[] outputfiles = outputDirectory.listFiles();
        Assertions.assertEquals(0, Objects.requireNonNull(outputfiles).length);
        controller.processData();
        outputfiles = outputDirectory.listFiles();
        Assertions.assertTrue(Objects.requireNonNull(outputfiles).length > 0);
    }

    @Test
    @SneakyThrows
    void processInvalidFile() {
        ReflectionTestUtils.setField(controller.getDataSource(), "path", TestingResources.INVALID_INPUT_PATH);

        File[] outputfiles = outputDirectory.listFiles();
        Assertions.assertEquals(0, Objects.requireNonNull(outputfiles).length);

        controller.processData();
        Assertions.assertEquals(0, outputfiles.length);
    }

    private void cleanDirectory() {
        outputDirectory = new File(TestingResources.OUTPUT_PATH);
        for (File file : Objects.requireNonNull(outputDirectory.listFiles()))
            if (!file.isDirectory())
                file.delete();
    }
}