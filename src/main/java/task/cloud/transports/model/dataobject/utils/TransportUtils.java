package task.cloud.transports.model.dataobject.utils;

import static java.util.Objects.nonNull;

import task.cloud.transports.model.dto.TransportDTO;

import java.util.Objects;

public class TransportUtils {

    public static final int CAR_CODE = 23; //sum of 3 + 7 + 13
    public static final int TRAIN_CODE = 83; //sum of 3 + 37 + 43
    public static final int PLANE_CODE = 51; //sum of 3 + 19 + 29

    private TransportUtils() {
    }

    /**
     * The method calculates a sum of distinct prime numbers associated with the non-null entry fields. Based on the
     * calculated code, it will be easy to find out the transport type.
     * <p>
     * If the entry will be a valid car, the code should be always 23, a train 83, and a plane 51.
     * <p>
     * If the entry will have more fields initialised than needed, the code will be different, and the entry will be
     * considered as unknown in further processing
     *
     * @param transportDTO
     * @return int
     */
    public static int getTransportTypeCode(TransportDTO transportDTO) {
        int code = 0;

        //common field, used to calculate the code for all known transports
        if (nonNull(transportDTO.getModel())) {
            code += 3;
        }

        //adding  car codes to transportCode
        if (nonNull(transportDTO.getManufacturer())) {
            code += 7;
        }
        if (nonNull(transportDTO.getPassengerCapacity())) {
            code += 13;
        }

        //adding plane codes to transportCode
        if (nonNull(transportDTO.getBPassengerCapacity())) {
            code += 19;
        }
        if (nonNull(transportDTO.getEPassengerCapacity())) {
            code += 29;
        }

        //adding train codes to transportCode
        if (nonNull(transportDTO.getWPassengerCapacity())) {
            code += 37;
        }
        if (nonNull(transportDTO.getNumberWagons())) {
            code += 43;
        }

        //if the input has unknown fields
        if (Objects.nonNull(transportDTO.getOther()) && !transportDTO.getOther().isEmpty()) {
            code += 97;
        }
        return code;
    }
}
