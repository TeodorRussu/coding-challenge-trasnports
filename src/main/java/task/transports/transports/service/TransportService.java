package task.transports.transports.service;

import task.transports.transports.model.dto.TransportDTO;
import task.transports.transports.model.dataobject.Transport;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface TransportService<D extends TransportDTO, T extends Transport> {

    List<File> processFiles(List<File> files) throws IOException;
}
