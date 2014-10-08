package examples.cdi;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * CDIでロガーを取得するためのプロデューサ
 * 
 * @author t_endo
 */
@Named
@Dependent
public class LoggerProducer {

    /**
     * {@link Logger} を供給するプロデューサメソッド。
     * 
     * @param ip
     * @return
     */
    @Produces
    public Logger getLogger(InjectionPoint ip) {
        return LoggerFactory.getLogger(ip.getMember().getDeclaringClass());
    }
}
