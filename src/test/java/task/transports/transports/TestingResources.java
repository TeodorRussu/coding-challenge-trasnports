package task.transports.transports;

import task.transports.transports.model.dataobject.Car;
import task.transports.transports.model.dataobject.Plane;
import task.transports.transports.model.dataobject.Train;
import task.transports.transports.model.dataobject.Transport;
import task.transports.transports.model.dataobject.TransportSummary;
import task.transports.transports.model.dto.TransportDTO;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TestingResources {

    public static final String EMPTY_STRING = "";
    public static final String VALID_INPUT_PATH = "src/test/resources/test_folder/valid_input/";
    public static final String INVALID_INPUT_PATH = "src/test/resources/test_folder/invalid_input";
    public static final String OUTPUT_PATH = "src/test/resources/test_folder/output/";

    public static final String VALID_INPUT_FILE_NAME = "file_data";
    public static final String VALID_INPUT_FILE_NAME_NO_CARS = "no_cars";
    public static final String VALID_INPUT_FILE_NAME_CARS_ONLY = "cars_only";
    public static final String VALID_INPUT_FILE_NAME_DIESEL_CAR = "diesel_car";


    public static final String INVALID_INPUT_FILENAME_BICYCLES = "bicycles";
    public static final String INVALID_INPUT_FILENAME_QQQQ = "qqqq";
    public static final String INVALID_INPUT_FILENAME_EMPTY_JSON = "empty_json";
    public static final String INVALID_INPUT_FILENAME_EMPTY_FILE = "empty_file";
    public static final String INVALID_INPUT_FILENAME_ALL_MIXED = "all_mixed";

    private TestingResources() {
    }

    public static File getValidFile() {
        return new File(VALID_INPUT_PATH + VALID_INPUT_FILE_NAME);
    }

    public static File getInvalidFile() {
        return new File(INVALID_INPUT_PATH);
    }

    public static List<TransportDTO> getTransportDTOsList() {

        List<TransportDTO> dtoList = new ArrayList<>();

        dtoList.add(getValidPaneDTO());
        dtoList.add(getValidCarDTO());
        dtoList.add(getValidTrainDTO());

        return dtoList;
    }

    public static List<TransportDTO> getInvalidTransportDTOsList() {
        List<TransportDTO> dtoList = new ArrayList<>();

        dtoList.add(getInvalidPaneDTO());
        dtoList.add(getInvalidTrainDTO());
        dtoList.add(getInvalidPaneDTO());

        return dtoList;
    }

    public static List<Transport> createTransportList() {
        List<Transport> transports = new ArrayList<>();

        transports.add(createCar(5, "Ford", "Ascona"));
        transports.add(createCar(5, "Maserati", "Quattro Porte"));
        transports.add(createCar(4, "Fiat", "Stilo"));

        transports.add(createPlane("LU", 20, 50));
        transports.add(createPlane("AF", 15, 55));
        transports.add(createPlane("AL", 35, 45));

        transports.add(createTrain(4, 44, "St"));
        transports.add(createTrain(6, 30, "Alu"));
        transports.add(createTrain(4, 65, "Gd"));

        return transports;

    }

    private static Car createCar(int i, String brand, String model) {
        return Car.builder().passengerCapacity(i).manufacturer(brand).model(model).build();
    }

    private static Train createTrain(int wagons, int wCapacity, String model) {
        return Train.builder().wPassengerCapacity(wCapacity).numberWagons(wagons).model(model).build();
    }

    private static Plane createPlane(String model, int bCapacity, int eCapacity) {
        return Plane.builder().model(model).bPassengerCapacity(bCapacity).ePassengerCapacity(eCapacity).build();
    }

    public static TransportSummary createTransportSummary() {
        return TransportSummary.builder().cars(2).planes(3).trains(4).build();
    }

    public static TransportDTO getValidPaneDTO() {
        return TransportDTO.builder()
            .model("Boeing 777")
            .bPassengerCapacity(14)
            .ePassengerCapacity(300)
            .build();
    }

    public static TransportDTO getValidTrainDTO() {
        return TransportDTO.builder()
            .model("ICE")
            .numberWagons(14)
            .wPassengerCapacity(50)
            .build();
    }

    public static TransportDTO getValidCarDTO() {
        return TransportDTO.builder()
            .model("Q3")
            .manufacturer("Audi")
            .passengerCapacity(5)
            .build();
    }

    public static TransportDTO getInvalidPaneDTO() {
        return TransportDTO.builder()
            .model("Boeing 777")
            .bPassengerCapacity(14)
            .build();
    }

    public static TransportDTO getInvalidTrainDTO() {
        return TransportDTO.builder()
            .model("ICE")
            .wPassengerCapacity(50)
            .build();
    }

}
