package task.cloud.transports.model.dataobject.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import task.cloud.transports.TestingResources;
import task.cloud.transports.model.dto.TransportDTO;

import java.util.HashMap;
import java.util.Map;

class TransportUtilsTest {

    private TransportDTO carDTO;
    private TransportDTO trainDTO;
    private TransportDTO planeDTO;

    @BeforeEach
    void setUp() {
        carDTO = TestingResources.getValidCarDTO();
        trainDTO = TestingResources.getValidTrainDTO();
        planeDTO = TestingResources.getValidPaneDTO();
    }

    @Test
    void getTransportTypeCodeTest() {
        Assertions.assertEquals(TransportUtils.CAR_CODE, TransportUtils.getTransportTypeCode(carDTO));
        Assertions.assertEquals(TransportUtils.TRAIN_CODE, TransportUtils.getTransportTypeCode(trainDTO));
        Assertions.assertEquals(TransportUtils.PLANE_CODE, TransportUtils.getTransportTypeCode(planeDTO));

    }

    @Test
    void getTransportTypeCodeWithOtherFieldsTest() {
        //add data to "other"-unknown fields -> not a valid transport
        Map<String, String> other = new HashMap<>();
        other.put("aaa", "bbb");
        carDTO.setOther(other);
        trainDTO.setOther(other);
        planeDTO.setOther(other);
        Assertions.assertNotEquals(TransportUtils.CAR_CODE, TransportUtils.getTransportTypeCode(carDTO));
        Assertions.assertNotEquals(TransportUtils.TRAIN_CODE, TransportUtils.getTransportTypeCode(trainDTO));
        Assertions.assertNotEquals(TransportUtils.PLANE_CODE, TransportUtils.getTransportTypeCode(planeDTO));
    }

    @Test
    void getTransportTypeCodeWithMissingModelTest() {
        carDTO.setModel(null);
        trainDTO.setModel(null);
        planeDTO.setModel(null);
        Assertions.assertNotEquals(TransportUtils.CAR_CODE, TransportUtils.getTransportTypeCode(carDTO));
        Assertions.assertNotEquals(TransportUtils.TRAIN_CODE, TransportUtils.getTransportTypeCode(trainDTO));
        Assertions.assertNotEquals(TransportUtils.PLANE_CODE, TransportUtils.getTransportTypeCode(planeDTO));
    }

    @Test
    void getTransportTypeCodeWithInvalidCapacityTestOne() {
        carDTO.setPassengerCapacity(null);
        trainDTO.setWPassengerCapacity(null);
        planeDTO.setEPassengerCapacity(null);
        Assertions.assertNotEquals(TransportUtils.CAR_CODE, TransportUtils.getTransportTypeCode(carDTO));
        Assertions.assertNotEquals(TransportUtils.TRAIN_CODE, TransportUtils.getTransportTypeCode(trainDTO));
        Assertions.assertNotEquals(TransportUtils.PLANE_CODE, TransportUtils.getTransportTypeCode(planeDTO));
    }

    @Test
    void getTransportTypeCodeWithInvalidCapacityTestTwo() {

        trainDTO.setNumberWagons(null);
        planeDTO.setBPassengerCapacity(null);
        Assertions.assertNotEquals(TransportUtils.TRAIN_CODE, TransportUtils.getTransportTypeCode(trainDTO));
        Assertions.assertNotEquals(TransportUtils.PLANE_CODE, TransportUtils.getTransportTypeCode(planeDTO));
    }
}