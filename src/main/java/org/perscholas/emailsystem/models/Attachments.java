package org.perscholas.emailsystem.models;

import com.sun.istack.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.io.File;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Slf4j
public class Attachments implements Serializable {

    Long userId;

    @Id
    @GeneratedValue
    Long attachmentId;

    String name;

    @NotNull
    File file;

    @ManyToMany(mappedBy = "attachments")
    List<Emails> emails;
}
