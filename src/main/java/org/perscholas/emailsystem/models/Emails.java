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
@ToString
@Slf4j
public class Emails implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long emailId;

    @NotNull
    Long userId;

    @NotNull
    String dateReceived;

    @NotNull
    String sender;

    @NotNull
    String title;

    String body;

    @ManyToMany(cascade = CascadeType.ALL)
    @NotNull
    List<Folders> folders;

    @ManyToMany(cascade = CascadeType.ALL)
    List<Attachments> attachments;

}
