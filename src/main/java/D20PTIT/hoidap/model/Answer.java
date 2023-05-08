package D20PTIT.hoidap.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.Date;

@Data
@Entity
@Table(name="answer")
@AllArgsConstructor
@NoArgsConstructor( force=true)

public class Answer {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String answerId;

    private String title;

    @Lob
    private String content;

    @Column(name="created_at")
    private Date createdAt;

    private boolean isCorrect;

    private int upvoteNo;

    private int downvoteNo;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name="question_id", nullable=false)
    private Question question;

    @ElementCollection
    @CollectionTable(
            name = "answer_pic",
            joinColumns = @JoinColumn(name = "answer_id"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"answer_id", "answerPic"})
    )
    ArrayList<String> answerPic;

    @PrePersist
    void placedAt() {
        this.createdAt = new Date();
    }

}
