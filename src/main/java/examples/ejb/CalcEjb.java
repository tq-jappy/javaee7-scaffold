package examples.ejb;

import javax.ejb.Stateless;

/**
 * 数値計算ビジネスロジック
 * 
 * @author t_endo
 */
@Stateless
public class CalcEjb {

    /**
     * ２つの引数の和を計算して返す。
     * 
     * @param a
     *            数値
     * @param b
     *            数値
     * @return a と b の和
     */
    public int add(int a, int b) {
        return a + b;
    }
}
