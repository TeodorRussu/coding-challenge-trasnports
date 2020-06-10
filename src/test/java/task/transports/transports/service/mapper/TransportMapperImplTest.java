package task.transports.transports.service.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import task.transports.transports.TestingResources;
import task.transports.transports.model.dataobject.Transport;
import task.transports.transports.model.dto.TransportDTO;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class TransportMapperImplTest {

    TransportMapperImpl transportMapper;

    @BeforeEach
    void setUp() {
        transportMapper = new TransportMapperImpl();
    }

    @Test
    void mapTransportDTOsToTransport() {
        String filename = "my file";
        Map<String, List<TransportDTO>> unmappedData = TestingResources.getMapWithTransportDTOs(filename);

        List<String> unmappedModels = unmappedData.values().stream().flatMap(list -> list.stream()).map(item -> item.getModel()).collect(Collectors.toList());

        Map<String, List<Transport>> mappedData = transportMapper.mapTransportDTOsToTransport(unmappedData);
        List<String> mappedModels = mappedData.values().stream().flatMap(list -> list.stream()).map(item -> item.getModel()).collect(Collectors.toList());
        Assertions.assertTrue(mappedData.keySet().iterator().next().equals(filename));
        Assertions.assertTrue(mappedData.values().iterator().next().size() == 2);
        Assertions.assertTrue(mappedModels.containsAll(unmappedModels));
    }

    @Test
    void mapInvalidTransportDTOsToTransport() {
        String filename = "my file";
        Map<String, List<TransportDTO>> unmappedData = TestingResources.getMapWithInvalidTransportDTOs(filename);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            transportMapper.mapTransportDTOsToTransport(unmappedData);
        });
    }


    @Test
    void mapTransportToTransportSummary() {
    }
}