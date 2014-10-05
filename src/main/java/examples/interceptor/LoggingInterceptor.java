package examples.interceptor;

import javax.interceptor.AroundConstruct;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 開始時と終了時にメソッドのログを記録するインターセプタクラス
 * 
 * @author t_endo
 */
public class LoggingInterceptor {

    private static final Logger logger = LoggerFactory
            .getLogger(LoggingInterceptor.class);

    @AroundConstruct
    private void init(InvocationContext ic) throws Exception {
        logger.debug("init");
        ic.proceed();
    }

    @AroundInvoke
    public Object logMethod(InvocationContext ic) throws Exception {
        logger.debug("enter {}: {}", ic.getTarget().toString(), ic.getMethod()
                .getName());
        try {
            return ic.proceed();
        } finally {
            logger.debug("exit {}: {}", ic.getTarget().toString(), ic
                    .getMethod().getName());
        }
    }
}
