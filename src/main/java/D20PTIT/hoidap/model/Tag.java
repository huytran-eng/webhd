package D20PTIT.hoidap.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "tag")
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class Tag {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String tagId;
    @Length(min = 3, max = 10, message = "độ dài không dưới 5 và quá 10 kí tự")
    private String tagName;
    @NotBlank(message = "Không được để trống phần mô tả")
    private String tagDescription;

    @ManyToMany(mappedBy = "tags")
    private Set<Question> questions;
}
