package examples.jms;

import javax.jms.JMSDestinationDefinition;

/**
 * 
 * @author t_endo
 */
@JMSDestinationDefinition(name = JMSResources.QUEUE,
        destinationName = "HelloQueue", interfaceName = "javax.jms.Queue")
public class JMSResources {

    public static final String QUEUE = "java:/queue/HelloQueue";
}
