package org.acme;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
public class Student {
    private Long id;
    private String fullName;
    private String email;
    private LocalDateTime birthDate;
}
