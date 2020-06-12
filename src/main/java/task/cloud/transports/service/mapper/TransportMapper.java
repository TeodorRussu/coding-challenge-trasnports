package task.cloud.transports.service.mapper;

import org.springframework.stereotype.Component;
import task.cloud.transports.model.dataobject.Transport;
import task.cloud.transports.model.dataobject.TransportSummary;
import task.cloud.transports.model.dto.TransportDTO;

import java.util.List;
import java.util.Map;

@Component
public interface TransportMapper {

    List<Transport> mapTransportDTOsToTransport(List<TransportDTO> transportDTOs);

    TransportSummary mapTransportToTransportSummary(Map<String, Integer> transportsTotals);
}
