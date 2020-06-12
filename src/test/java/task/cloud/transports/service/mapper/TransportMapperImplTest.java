package task.cloud.transports.service.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import task.cloud.transports.TestingResources;
import task.cloud.transports.model.dataobject.Transport;
import task.cloud.transports.model.dto.TransportDTO;

import java.util.List;
import java.util.stream.Collectors;

class TransportMapperImplTest {

    TransportMapperImpl transportMapper;

    @BeforeEach
    void setUp() {
        transportMapper = new TransportMapperImpl();
    }

    @Test
    void mapTransportDTOsToTransport() {
        List<TransportDTO> unmappedData = TestingResources.getTransportDTOsList();

        List<String> unmappedModels = unmappedData.stream().map(TransportDTO::getModel).collect(Collectors.toList());

        List<Transport> mappedData = transportMapper.mapTransportDTOsToTransport(unmappedData);
        List<String> mappedModels = mappedData.stream().map(Transport::getModel).collect(Collectors.toList());

        Assertions.assertEquals(unmappedData.size(), mappedData.size());
        Assertions.assertTrue(mappedModels.containsAll(unmappedModels));
    }

    @Test
    void mapInvalidTransportDTOsToTransport() {
        List<TransportDTO> unmappedData = TestingResources.getInvalidTransportDTOsList();

        List<Transport> mappedData = transportMapper.mapTransportDTOsToTransport(unmappedData);

        Assertions.assertTrue(mappedData.isEmpty());
    }
}