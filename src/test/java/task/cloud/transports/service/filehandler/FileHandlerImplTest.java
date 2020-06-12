package task.cloud.transports.service.filehandler;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import task.cloud.transports.TestingResources;
import task.cloud.transports.model.dto.TransportDTO;

import java.io.File;
import java.io.IOException;
import java.util.List;

class FileHandlerImplTest {

    FileHandlerImpl fileHandler;
    File inputFile;

    @BeforeEach
    void setUp() {
        fileHandler = new FileHandlerImpl();
    }

    @Test
    void getValidInputDataFromFiles() throws IOException {
        inputFile = TestingResources.getValidFile();
        List<TransportDTO> inputData = fileHandler.getInputDataFromFile(inputFile);
        Assertions.assertNotNull(inputData);
        Assertions.assertEquals(6, inputData.size());
    }

    @Test
    void getInvalidInputDataFromFiles() throws IOException {
        inputFile = TestingResources.getInvalidFile();
        List<TransportDTO> inputData = fileHandler.getInputDataFromFile(inputFile);
        Assertions.assertNotNull(inputData);
        Assertions.assertTrue(inputData.isEmpty());
    }
}