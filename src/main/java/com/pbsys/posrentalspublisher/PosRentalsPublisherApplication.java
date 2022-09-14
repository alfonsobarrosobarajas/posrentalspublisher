package com.pbsys.posrentalspublisher;

import com.pbsys.posrentalspublisher.helper.PropertiesHelper;
import com.pbsys.posrentalspublisher.helper.PubSubHelper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@PropertySources({
        @PropertySource(value = "file:${POS_RENTALS_CONFIG}"),
        @PropertySource(value = "classpath:application.properties")
})
public class PosRentalsPublisherApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(PosRentalsPublisherApplication.class, args);
        PropertiesHelper propertiesHelper = applicationContext.getBean(PropertiesHelper.class);
        String projectId = propertiesHelper.getGcpProjectName();
        String topicId = propertiesHelper.getPubSubTopic();
        PubSubHelper pubSubHelper = new PubSubHelper(projectId, topicId);
        String messageId = pubSubHelper.publishMessage("PubSub Testing");
        System.out.println("Message id: " + messageId);
    }

}
