package examples.jms;

import javax.jms.JMSDestinationDefinition;
import javax.jms.JMSDestinationDefinitions;

/**
 * 
 * @author t_endo
 */
@JMSDestinationDefinitions({
        @JMSDestinationDefinition(name = JMSResources.QUEUE1,
                destinationName = "HogeQueue",
                interfaceName = "javax.jms.Queue"),
        @JMSDestinationDefinition(name = JMSResources.QUEUE2,
                destinationName = "FugaQueue",
                interfaceName = "javax.jms.Queue") })
public class JMSResources {

    public static final String QUEUE1 = "java:/queue/HogeQueue";

    public static final String QUEUE2 = "java:/queue/FugaQueue";
}
