package com.cracker.manual.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class AssesmentDTO {
    private int mark;
    private LocalDate date;
}
