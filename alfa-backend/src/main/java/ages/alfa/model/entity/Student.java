package ages.alfa.model.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student", schema = "public")
public class Student  implements Serializable {

    public static final long serialVersionUID = 8608221581539359596L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "class_id")
    private Long classId;

    @OneToOne(optional = false, cascade=CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;


}
