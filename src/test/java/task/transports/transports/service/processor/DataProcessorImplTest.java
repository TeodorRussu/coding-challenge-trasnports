package task.transports.transports.service.processor;

import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import task.transports.transports.TestingResources;
import task.transports.transports.service.mapper.TransportMapper;
import task.transports.transports.service.mapper.TransportMapperImpl;

class DataProcessorImplTest {

    @InjectMocks
    private DataProcessorImpl dataProcessorImpl;
    @Mock
    private TransportMapperImpl transportMapper;

    @BeforeEach
    void setUp() {
        initMocks(this);
    }

    @Test
    void createSummaryTest() {
        dataProcessorImpl.createSummary(TestingResources.createTransportList());
        verify(transportMapper, times(1)).mapTransportToTransportSummary(anyMap());
    }



}