package examples.jms;

import java.io.Serializable;

import lombok.Data;
import lombok.ToString;

/**
 * MDBに受け渡すためのシンプルなメッセージ
 * 
 * @author t_endo
 */
@Data
@ToString
public class SimpleMessage implements Serializable {

    private static final long serialVersionUID = -5590708175585111186L;

    private int aNumber;

    private String aString;
}
