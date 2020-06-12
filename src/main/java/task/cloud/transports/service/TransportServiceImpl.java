package task.cloud.transports.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import task.cloud.transports.model.dataobject.Transport;
import task.cloud.transports.model.dataobject.TransportSummary;
import task.cloud.transports.model.dto.TransportDTO;
import task.cloud.transports.service.filehandler.FileHandler;
import task.cloud.transports.service.mapper.TransportMapper;
import task.cloud.transports.service.processor.DataProcessor;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Component
public class TransportServiceImpl implements TransportService {

    @Autowired
    private TransportMapper transportMapper;
    @Autowired
    private FileHandler fileHandler;
    @Autowired
    private DataProcessor dataProcessor;

    @Override
    public TransportSummary processFile(File file) throws IOException {

        List<TransportDTO> inputObjects = fileHandler.getInputDataFromFile(file);
        List<Transport> dataObjects = transportMapper.mapTransportDTOsToTransport(inputObjects);

        return dataProcessor.createSummary(dataObjects);
    }
}
