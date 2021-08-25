package org.perscholas.emailsystem.models;

import lombok.NonNull;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class AuthGroups implements Serializable{
    private static final long serialVersionUID = 1337L;

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
