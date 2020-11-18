package com.example.sam;

import com.fasterxml.jackson.core.SerializableString;
import lombok.Data;

import java.io.Serializable;


@Data

public class OutSideUser implements Serializable {

    private Integer id;

    private String userName;

}
