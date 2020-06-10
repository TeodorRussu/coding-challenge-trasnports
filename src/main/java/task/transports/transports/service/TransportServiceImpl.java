package task.transports.transports.service;

import org.springframework.beans.factory.annotation.Autowired;
import task.transports.transports.model.dataobject.Transport;
import task.transports.transports.model.dataobject.TransportSummary;
import task.transports.transports.model.dto.TransportDTO;
import task.transports.transports.service.filehandler.FileHandler;
import task.transports.transports.service.mapper.TransportMapper;
import task.transports.transports.service.processor.DataProcessor;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class TransportServiceImpl implements TransportService<TransportDTO, Transport> {

    @Autowired
    private TransportMapper mapper;
    @Autowired
    private FileHandler fileHandler;
    @Autowired
    private DataProcessor dataProcessor;

    @Override
    public List<File> processFiles(List<File> files) throws IOException {

        Map<String, List<TransportDTO>> inputObjects = fileHandler.getInputDataFromFiles(files);
        Map<String, List<Transport>> dataObjects = mapper.mapTransportDTOsToTransport(inputObjects);
        Map<String, List<TransportSummary>> transportSummary = dataProcessor.createSummary(dataObjects);

        return null;
    }
}
