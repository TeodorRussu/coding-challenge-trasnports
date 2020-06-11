package task.transports.transports.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import task.transports.transports.model.dataobject.Transport;
import task.transports.transports.model.dataobject.TransportSummary;
import task.transports.transports.model.dto.TransportDTO;
import task.transports.transports.service.filehandler.FileHandler;
import task.transports.transports.service.mapper.TransportMapper;
import task.transports.transports.service.processor.DataProcessor;

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
