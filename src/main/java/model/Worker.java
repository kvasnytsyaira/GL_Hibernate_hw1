package model;

import lombok.*;
import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int age;
    @Enumerated(EnumType.STRING)
    private Availability availability;
    private String full_name;
    @ManyToOne(fetch = FetchType.LAZY)
    private Department departmentId;

    @Override
    public String toString() {
        return "Worker{" +
                "id=" + id +
                ", age=" + age +
                ", availability=" + availability +
                ", full_name='" + full_name + '\'' +
                ", departmentId=" + departmentId +
                '}';
    }

    enum Availability {
        PARTTIME, FULLTIME;

    }
}