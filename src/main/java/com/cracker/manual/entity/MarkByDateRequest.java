package com.cracker.manual.entity;

import lombok.Data;

import java.util.Date;

@Data
public class MarkByDateRequest {

    private int mark;
    private Date date;
}
