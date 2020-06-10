package task.transports.transports.service.mapper;

import org.springframework.stereotype.Component;
import task.transports.transports.model.dataobject.Transport;
import task.transports.transports.model.dto.TransportDTO;

import java.util.List;
import java.util.Map;

@Component
public class TransportMapperImpl implements TransportMapper {
    @Override
    public Map<String, List<Transport>> mapTransportDTOsToTransport(Map<String, List<TransportDTO>> transportDTO) {
        return null;
    }
}
