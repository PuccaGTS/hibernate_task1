package ru.netology.netolhiber1.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class PersonPK implements Serializable {
    protected String name;
    protected String surname;
    protected int age;
}
