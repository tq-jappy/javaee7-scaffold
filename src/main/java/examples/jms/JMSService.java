package examples.jms;

import javax.jms.JMSConnectionFactoryDefinition;
import javax.jms.JMSDestinationDefinition;

/**
 * 
 * @author t_endo
 */
@JMSConnectionFactoryDefinition(name = "java:app/jms/MyConnectionFactory",
        maxPoolSize = 30, minPoolSize = 10)
@JMSDestinationDefinition(name = JMSService.QUEUE, resourceAdapter = "jmsra",
        destinationName = "exampleQueue", interfaceName = "javax.jms.Queue")
public class JMSService {

    public static final String QUEUE = "java:global/queue/exampleQueue";
}
