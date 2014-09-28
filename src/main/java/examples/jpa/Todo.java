package examples.jpa;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

/**
 * ToDoエンティティ
 * 
 * @author t_endo
 */
@Entity
@Data
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long Id;

    private String title;

    private boolean finished;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
}
