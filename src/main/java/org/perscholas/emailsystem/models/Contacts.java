package org.perscholas.emailsystem.models;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@Slf4j
public class Contacts implements Serializable {

    @Id
    @NonNull
    String email;

    String firstName;

    String lastName;
}
