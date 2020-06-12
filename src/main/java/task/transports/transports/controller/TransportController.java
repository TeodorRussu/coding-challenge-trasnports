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

        File inputFile = dataSource.getInputFile();
        TransportSummary processed = transportService.processFile(inputFile);

        if (processed.isEmpty()) {
            throw new Exception(String.format("The file %s, doesn't contain any valid entry", inputFile));
        }

        outputService.processOutput(inputFile.getName(), processed);
    }
}
