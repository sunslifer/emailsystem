package org.perscholas.emailsystem.models;


import com.sun.istack.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@Slf4j
public class Emails implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long emailId;

    @NotNull
    Date dateReceived;

    @NonNull
    String sender;

    @NonNull
    String title;

    @NonNull
    String body;

    @ManyToMany(mappedBy = "emails")
    List<Folders> folders;

    @ManyToMany(cascade = CascadeType.ALL)
    List<Attachments> attachments;

}
