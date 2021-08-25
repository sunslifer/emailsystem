package org.perscholas.emailsystem.models;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
public class Users implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long userId;

    @NotNull
    @Column(unique = true)
    String userName;

    @NotNull
    @NotBlank
    String password;

    String firstName;

    String lastName;

    Date dateOfBirth;

    String pfpPath;

    @ManyToMany(cascade = CascadeType.ALL)
    List<Folders> folders;

    @ManyToMany(cascade = CascadeType.ALL)
    List<Contacts> contacts;

}
