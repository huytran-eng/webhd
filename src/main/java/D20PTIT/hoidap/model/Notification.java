package D20PTIT.hoidap.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.Date;

@Data
@Entity
@Table(name="notification")
@AllArgsConstructor
@NoArgsConstructor(force=true)

public class Notification {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String answerId;

    private boolean seen;

    private Date createdAt;

    private String content;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name="user_id", nullable=false)
    private User user;
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name="question_id", nullable=false)
    private Question question;

    @PrePersist
    void placedAt() {
        this.createdAt = new Date();
    }
}
