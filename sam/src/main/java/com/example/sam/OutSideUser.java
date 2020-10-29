package com.example.sam;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity(name = "outside_users")
public class OutSideUser {
    @Id
    private Integer id;
    @Column
    private String userName;

}
