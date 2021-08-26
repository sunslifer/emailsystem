package org.perscholas.emailsystem.models;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Slf4j
public class Folders implements Serializable {

    @Id
    @Column(unique = true)
    String name;


}
