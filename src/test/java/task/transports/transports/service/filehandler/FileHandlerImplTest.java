package task.transports.transports.service.filehandler;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import task.transports.transports.TestingResources;
import task.transports.transports.model.dto.TransportDTO;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

class FileHandlerImplTest {

    FileHandlerImpl fileHandler;
    List<File> filesList;

    @BeforeEach
    void setUp() {
        fileHandler = new FileHandlerImpl();
    }

    @Test
    void getValidInputDataFromFiles() throws IOException {
        filesList = TestingResources.getValidFiles();
        Map<String, List<TransportDTO>> inputData = fileHandler.getInputDataFromFiles(filesList);
        Assertions.assertNotNull(inputData);
        Assertions.assertEquals(6, inputData.values().iterator().next().size());
    }

    @Test
    void getInvalidInputDataFromFiles() throws IOException {
        filesList = TestingResources.getInvalidFiles();
        Map<String, List<TransportDTO>> inputData = fileHandler.getInputDataFromFiles(filesList);
        Assertions.assertNotNull(inputData);
        Assertions.assertTrue(inputData.isEmpty());
    }
}