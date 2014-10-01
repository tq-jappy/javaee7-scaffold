package examples.jms;

import java.io.Serializable;

import lombok.Data;

/**
 * 
 * @author t_endo
 */
@Data
public class CalcMessage implements Serializable {

    private static final long serialVersionUID = -5590708175585111186L;

    private int num1;

    private int num2;
}
