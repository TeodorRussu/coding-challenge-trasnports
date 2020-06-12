package task.cloud.transports.controller;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.util.ReflectionTestUtils;
import task.cloud.transports.TestingResources;

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
        //cleanDirectory();
    }

    //positive tests

    @SneakyThrows
    @Test
    void processValidFile() {
        File[] outputfiles = outputDirectory.listFiles();
        Assertions.assertEquals(0, Objects.requireNonNull(outputfiles).length);
        controller.processData();
        outputfiles = outputDirectory.listFiles();
        Assertions.assertTrue(Objects.requireNonNull(outputfiles).length > 0);
    }

    @SneakyThrows
    @Test
    void processValidFileCarsOnly() {
        testValidScenario(TestingResources.VALID_INPUT_FILE_NAME_CARS_ONLY);
    }

    @SneakyThrows
    @Test
    void processValidFileDieselCar() {
        testValidScenario(TestingResources.VALID_INPUT_FILE_NAME_DIESEL_CAR);
    }

    @SneakyThrows
    @Test
    void processValidFileNoCars() {
        testValidScenario(TestingResources.VALID_INPUT_FILE_NAME_NO_CARS);
    }

    private void testValidScenario(String validInputFileNameDieselCar) throws Exception {
        ReflectionTestUtils.setField(controller.getDataSource(), "path", TestingResources.VALID_INPUT_PATH);
        ReflectionTestUtils
            .setField(controller.getDataSource(), "fileName", validInputFileNameDieselCar);
        File[] outputfiles = outputDirectory.listFiles();
        Assertions.assertEquals(0, Objects.requireNonNull(outputfiles).length);
        controller.processData();
        outputfiles = outputDirectory.listFiles();
        Assertions.assertTrue(Objects.requireNonNull(outputfiles).length > 0);
    }


    //negative tests

    @Test
    @SneakyThrows
    void processInvalidFileQqqq() {
        ReflectionTestUtils.setField(controller.getDataSource(), "path", TestingResources.INVALID_INPUT_PATH);
        ReflectionTestUtils
            .setField(controller.getDataSource(), "fileName", TestingResources.INVALID_INPUT_FILENAME_QQQQ);

        Assertions.assertThrows(JsonParseException.class, () -> controller.processData());
        File[] outputfiles = outputDirectory.listFiles();
        Assertions.assertEquals(0, Objects.requireNonNull(outputfiles).length);
    }

    @Test
    @SneakyThrows
    void processInvalidFileBicycles() {
        testInvalidInput(TestingResources.INVALID_INPUT_FILENAME_BICYCLES);
    }

    @Test
    @SneakyThrows
    void processInvalidFileEmptyFile() {
        testInvalidInput(TestingResources.INVALID_INPUT_FILENAME_EMPTY_FILE);
    }

    @Test
    @SneakyThrows
    void processInvalidFileEmptyJson() {
        testEmptyFileOrNoOneValidEntry(TestingResources.INVALID_INPUT_FILENAME_EMPTY_JSON);
    }

    @Test
    @SneakyThrows
    void processInvalidFileAllMixed() {
        testEmptyFileOrNoOneValidEntry(TestingResources.INVALID_INPUT_FILENAME_ALL_MIXED);
    }

    private void testInvalidInput(String invalidInputFilenameEmptyFile) {
        ReflectionTestUtils.setField(controller.getDataSource(), "path", TestingResources.INVALID_INPUT_PATH);
        ReflectionTestUtils
            .setField(controller.getDataSource(), "fileName", invalidInputFilenameEmptyFile);

        Assertions.assertThrows(MismatchedInputException.class, () -> controller.processData());
        File[] outputfiles = outputDirectory.listFiles();
        Assertions.assertEquals(0, Objects.requireNonNull(outputfiles).length);
    }

    private void testEmptyFileOrNoOneValidEntry(String invalidInputFilenameEmptyJson) {
        ReflectionTestUtils.setField(controller.getDataSource(), "path", TestingResources.INVALID_INPUT_PATH);
        ReflectionTestUtils
            .setField(controller.getDataSource(), "fileName", invalidInputFilenameEmptyJson);

        Assertions.assertThrows(Exception.class, () -> controller.processData());
        File[] outputfiles = outputDirectory.listFiles();
        Assertions.assertEquals(0, Objects.requireNonNull(outputfiles).length);
    }


    private void cleanDirectory() {
        outputDirectory = new File(TestingResources.OUTPUT_PATH);
        for (File file : Objects.requireNonNull(outputDirectory.listFiles())) {
            if (!file.isDirectory()) {
                file.delete();
            }
        }
    }
}