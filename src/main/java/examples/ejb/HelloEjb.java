package examples.ejb;

import javax.ejb.Stateless;

/**
 * シンプルなビジネスロジック
 * 
 * @author t_endo
 */
@Stateless
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
