package model;

import lombok.*;
import javax.persistence.*;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Department {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idDepartment;
    private String name;
    private boolean status ;
    @OneToMany(mappedBy = "departmentId" , fetch = FetchType.LAZY )
    private List<Worker>workers;


    @Override
    public String toString() {
        return "Department{" +
                "idDepartment=" + idDepartment +
                ", name='" + name + '\'' +
                ", status=" + status + '}';
    }

}
