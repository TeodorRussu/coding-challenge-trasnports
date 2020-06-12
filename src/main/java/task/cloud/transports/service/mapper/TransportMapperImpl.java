package task.cloud.transports.service.mapper;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import task.cloud.transports.model.dataobject.Car;
import task.cloud.transports.model.dataobject.Plane;
import task.cloud.transports.model.dataobject.Train;
import task.cloud.transports.model.dataobject.Transport;
import task.cloud.transports.model.dataobject.TransportSummary;
import task.cloud.transports.model.dataobject.utils.TransportUtils;
import task.cloud.transports.model.dto.TransportDTO;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
@Slf4j
public class TransportMapperImpl implements TransportMapper {

    @Override
    public List<Transport> mapTransportDTOsToTransport(List<TransportDTO> transportDTOs) {

        return transportDTOs
            .stream()
            .map(this::mapTransportDtoToTransport)
            .filter(Objects::nonNull)
            .collect(Collectors.toList());
    }

    private Transport mapTransportDtoToTransport(TransportDTO transportDTO) {
        Transport transport = null;
        int transportCode = TransportUtils.getTransportTypeCode(transportDTO);

        switch (transportCode) {
            case TransportUtils.CAR_CODE:
                transport = Car.builder()
                    .model(transportDTO.getModel())
                    .manufacturer(transportDTO.getManufacturer())
                    .passengerCapacity(transportDTO.getPassengerCapacity())
                    .build();
                break;
            case TransportUtils.PLANE_CODE:
                transport = Plane.builder()
                    .model(transportDTO.getModel())
                    .bPassengerCapacity(transportDTO.getBPassengerCapacity())
                    .ePassengerCapacity(transportDTO.getEPassengerCapacity())
                    .build();
                break;
            case TransportUtils.TRAIN_CODE:
                transport = Train.builder()
                    .model(transportDTO.getModel())
                    .numberWagons(transportDTO.getNumberWagons())
                    .wPassengerCapacity(transportDTO.getWPassengerCapacity())
                    .build();
                break;
            default:
                log.error("Inconsistent input data: {}. Entry will be skipped", transportDTO.toString());
        }
        return transport;

    }

    @Override
    public TransportSummary mapTransportToTransportSummary(Map<String, Integer> transportsTotals) {

        return TransportSummary.builder()
            .cars(transportsTotals.get(Car.class.getSimpleName()))
            .trains(transportsTotals.get(Train.class.getSimpleName()))
            .planes(transportsTotals.get(Plane.class.getSimpleName()))
            .build();

    }
}