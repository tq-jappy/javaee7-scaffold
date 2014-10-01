package examples.jms;

import javax.jms.JMSDestinationDefinition;

/**
 * 
 * @author t_endo
 */
@JMSDestinationDefinition(name = JMSService.QUEUE,
        destinationName = "HelloQueue", interfaceName = "javax.jms.Queue")
public class JMSService {

    public static final String QUEUE = "java:/queue/HelloQueue";
}
