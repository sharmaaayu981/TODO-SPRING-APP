package comm.example.model;

import lombok.Data;
import lombok.extern.apachecommons.CommonsLog;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.sql.CallableStatement;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@Entity
public class Todos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "todo_name")
    @NotNull(message="Must not be Null ")
    @Size(min=1, message="Must not be Null")
    private String todoName;

    @Column(name = "todo_date")
    @NotNull(message="Must not be Null ")
    @Size(min=1, message="Must not be Null")
    private String todoDate;

}
