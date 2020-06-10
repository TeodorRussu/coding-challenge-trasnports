package task.transports.transports;

import task.transports.transports.model.dto.TransportDTO;

import java.io.File;
import java.util.*;

public class TestingResources {
    public static final String VALID_INPUT_PATH = "src/test/resources/test_folder/valid_input";
    public static final String INVALID_INPUT_PATH = "src/test/resources/test_folder/invalid_input";
    public static final String OUTPUT_PATH = "src/test/resources/test_folder/output";

    private TestingResources() {
    }

    public static List<File> getValidFiles() {
        File inputDirectory = new File(VALID_INPUT_PATH);
        return Arrays.asList(inputDirectory.listFiles());
    }

    public static List<File> getInvalidFiles() {
        File inputDirectory = new File(INVALID_INPUT_PATH);
        return Arrays.asList(inputDirectory.listFiles());
    }

    public static Map<String, List<TransportDTO>> getMapWithTransportDTOs(String filename) {
        Map<String, List<TransportDTO>> dtoMap = new HashMap<>();
        List<TransportDTO> dtoList = new ArrayList<>();

        TransportDTO dto = TransportDTO.builder()
                .model("Boeing 777")
                .bPassengerCapacity(14)
                .ePassengerCapacity(300)
                .build();
        TransportDTO dto1 = TransportDTO.builder()
                .model("Q3")
                .manufacturer("Audi")
                .passengerCapacity(5)
                .build();

        dtoList.add(dto);
        dtoList.add(dto1);

        dtoMap.put(filename, dtoList);

        return dtoMap;
    }

    public static Map<String, List<TransportDTO>> getMapWithInvalidTransportDTOs(String filename) {
        Map<String, List<TransportDTO>> dtoMap = new HashMap<>();
        List<TransportDTO> dtoList = new ArrayList<>();

        TransportDTO dto = TransportDTO.builder()
                .model("Boeing 777")
                .ePassengerCapacity(300)
                .build();
        TransportDTO dto1 = TransportDTO.builder()
                .model("Q3")
                .manufacturer("Audi")
                .build();

        dtoList.add(dto);
        dtoList.add(dto1);

        dtoMap.put(filename, dtoList);

        return dtoMap;
    }


}
