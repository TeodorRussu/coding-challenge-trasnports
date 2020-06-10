package task.transports.transports.service.mapper;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import task.transports.transports.model.dataobject.*;
import task.transports.transports.model.dataobject.utils.TransportUtils;
import task.transports.transports.model.dto.TransportDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Component
@Slf4j
public class TransportMapperImpl implements TransportMapper {
    @Override
    public Map<String, List<Transport>> mapTransportDTOsToTransport(Map<String, List<TransportDTO>> transportDTO) {

        Map<String, List<Transport>> mappedData = new HashMap<>();

        for (Map.Entry<String, List<TransportDTO>> me : transportDTO.entrySet()) {
            List<Transport> mappedTransportObjects = mapTransportDtoListToTransportList(me.getValue());
            if (mappedTransportObjects.contains(null)) {
                log.info("the file {} has been skipped due to inconsistency", me.getKey());
                continue;
            }
            mappedData.put(me.getKey(), mappedTransportObjects);

        }
        return mappedData;
    }

    @Override
    public TransportSummary mapTransportToTransportSummary(Map<String, Integer> transportsTotals) {
        return TransportSummary.builder()
                .cars(transportsTotals.get(Car.class.getSimpleName()))
                .trains(transportsTotals.get(Train.class.getSimpleName()))
                .planes(transportsTotals.get(Plane.class.getSimpleName()))
                .build();
    }

    private List<Transport> mapTransportDtoListToTransportList(List<TransportDTO> transportDTOs) {
        return transportDTOs
                .stream()
                .map(this::mapTransportDtoToTransport)
                .collect(Collectors.toList());
    }

    private Transport mapTransportDtoToTransport(TransportDTO transportDTO) {
        Transport transport = null;
        if (TransportUtils.isCar(transportDTO)) {
            transport = Car.builder()
                    .model(transportDTO.getModel())
                    .manufacturer(transportDTO.getManufacturer())
                    .passengerCapacity(transportDTO.getPassengerCapacity())
                    .build();
        } else if (TransportUtils.isPlane(transportDTO)) {
            transport = Plane.builder()
                    .model(transportDTO.getModel())
                    .bPassengerCapacity(transportDTO.getBPassengerCapacity())
                    .ePassengerCapacity(transportDTO.getEPassengerCapacity())
                    .build();
        } else if (TransportUtils.isTrain(transportDTO)) {
            transport = Train.builder()
                    .model(transportDTO.getModel())
                    .numberWagons(transportDTO.getNumberWagons())
                    .wPassengerCapacity(transportDTO.getWPassengerCapacity())
                    .build();
        }
        if (isNull(transport)) {
            log.error("Inconsistent input data: {}. File will be skipped", transportDTO.toString());
        }

        return transport;
    }
}
