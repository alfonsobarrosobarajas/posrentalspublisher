package com.pbsys.posrentalspublisher.helper;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertiesHelper {

    @Value("${project.name}")
    private String projectName;
    @Value("${project.version}")
    private String projectVersion;
    @Value("${local.xml.output.path}")
    private String localXmlOutputPath;
    @Value("${local.filename.prefix}")
    private String filePrefix;
    @Value("${local.filename.suffix}")
    private String fileSuffix;
    @Value("${gcp.project.name}")
    private String gcpProjectName;
    @Value("${bq.rental.dataset}")
    private String bqDataset;
    @Value("${gcp.pubsub.topic}")
    private String pubSubTopic;
    @Value("${bq.rental.table.rentals_by_customer}")
    private String bqRentalsByCustomer;


    public String getProjectName() {
        return projectName;
    }

    public String getProjectVersion() {
        return projectVersion;
    }

    public String getLocalXmlOutputPath() {
        return localXmlOutputPath;
    }

    public String getFilePrefix() {
        return filePrefix;
    }

    public String getFileSuffix() {
        return fileSuffix;
    }

    public String getGcpProjectName() {
        return gcpProjectName;
    }

    public String getPubSubTopic() {
        return pubSubTopic;
    }

    public String getBqDataset() {
        return bqDataset;
    }

    public String getBqRentalsByCustomer() {
        return bqRentalsByCustomer;
    }
}