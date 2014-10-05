package examples.ejb;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

import examples.interceptor.LoggingInterceptor;

/**
 * シンプルなビジネスロジック
 * 
 * @author t_endo
 */
@Stateless
@Interceptors(LoggingInterceptor.class)
public class HelloEjb {

    /**
     * helloメッセージを組み立てる。
     * 
     * @param name
     *            名前
     * @return helloメッセージ
     */
    public String greet(String name) {
        return "Hello, " + name + "!";
    }
}
