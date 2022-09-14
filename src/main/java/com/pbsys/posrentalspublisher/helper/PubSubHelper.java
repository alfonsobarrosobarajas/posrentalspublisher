package com.pbsys.posrentalspublisher.helper;

import com.google.api.core.ApiFuture;
import com.google.cloud.pubsub.v1.Publisher;
import com.google.protobuf.ByteString;
import com.google.pubsub.v1.PubsubMessage;
import com.google.pubsub.v1.TopicName;
import com.pbsys.posrentalspublisher.utils.Messages;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;


public class PubSubHelper {

    private static Logger logger = Logger.getLogger(PubSubHelper.class.getName());
    private String projectId;
    private String topicId;

    public PubSubHelper(String projectId, String topicId) {
        this.projectId = projectId;
        this.topicId = topicId;
    }

    public String publishMessage(String message) {
        Publisher publisher = null;
        try {
            logger.info(Messages.TRYING_TO_SENDING_MESSAGE);
            TopicName topicName = TopicName.of(projectId, topicId);
            publisher = Publisher.newBuilder(topicName).build();
            ByteString byteString = ByteString.copyFromUtf8(message);
            PubsubMessage pubsubMessage = PubsubMessage.newBuilder().setData(byteString).build();
            ApiFuture<String> messageIdFuture = publisher.publish(pubsubMessage);
            String messageId = messageIdFuture.get();
            logger.info(Messages.MESSAGE_PUBLISHED);
            return messageId;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(Messages.MESSAGE_NOT_PUBLISHED + " " + e.getMessage());
        } catch (ExecutionException e) {
            e.printStackTrace();
            throw new RuntimeException(Messages.MESSAGE_NOT_PUBLISHED + " " + e.getMessage());
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(Messages.MESSAGE_NOT_PUBLISHED + " " + e.getMessage());
        } finally {
            if (publisher != null) {
                publisher.shutdown();
                try {
                    publisher.awaitTermination(1, TimeUnit.MINUTES);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
