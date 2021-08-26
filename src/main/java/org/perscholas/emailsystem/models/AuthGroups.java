package org.perscholas.emailsystem.models;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Slf4j
public class AuthGroups {
    private static final long serialVersionUID = 8349938216666765198L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long aId;

    @NonNull
    @NotBlank
    String aUsername;

    @NonNull
    @NotBlank
    String aAuthGroup;
}
