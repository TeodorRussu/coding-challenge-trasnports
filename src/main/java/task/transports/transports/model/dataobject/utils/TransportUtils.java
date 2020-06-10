package task.transports.transports.model.dataobject.utils;

import org.apache.commons.lang3.ObjectUtils;
import task.transports.transports.model.dto.TransportDTO;

public class TransportUtils {

    private TransportUtils() {
    }

    public static boolean isCar(TransportDTO transportDTO) {

        return ObjectUtils.allNotNull(
                transportDTO.getModel(),
                transportDTO.getManufacturer(),
                transportDTO.getPassengerCapacity()
        );
    }

    public static boolean isPlane(TransportDTO transportDTO) {

        return ObjectUtils.allNotNull(
                transportDTO.getModel(),
                transportDTO.getBPassengerCapacity(),
                transportDTO.getEPassengerCapacity()
        );
    }

    public static boolean isTrain(TransportDTO transportDTO) {

        return ObjectUtils.allNotNull(
                transportDTO.getModel(),
                transportDTO.getNumberWagons(),
                transportDTO.getWPassengerCapacity()
        );
    }
}
