package task.transports.transports.controller;

import lombok.Data;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import task.transports.transports.input.datasource.DataSource;
import task.transports.transports.model.dataobject.TransportSummary;
import task.transports.transports.output.OutputService;
import task.transports.transports.service.TransportService;

import java.io.File;
import java.util.List;
import java.util.Map;

@Component
@Data
public class TransportController {

    @Setter(onMethod = @__({@Autowired}))
    private DataSource dataSource;
    @Setter(onMethod = @__({@Autowired}))
    private TransportService transportService;
    @Setter(onMethod = @__({@Autowired}))
    private OutputService outputService;

    public void processData() throws Exception {
        List<File> files = dataSource.getFiles();
        Map<String, TransportSummary> processed = transportService.processFiles(files);
        outputService.processOutput(processed);
    }
}
