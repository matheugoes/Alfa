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
@Table(name = "teacher", schema = "public")
public class Teacher implements Serializable {

    public static final long serialVersionUID = -3622078718102048984L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(optional = false, cascade=CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    @Column(name = "subject")
    private String subject;

    @Column(name = "education")
    private String education;

    @Column(name = "school")
    private String school;

    @Column(name = "eja")
    private Boolean eja;
}
