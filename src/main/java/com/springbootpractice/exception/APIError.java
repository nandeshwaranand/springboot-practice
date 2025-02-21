package com.springbootpractice.exception;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class APIError {

    private LocalDateTime timestamp;

    private String message;

    private String description;

    private String path;
}
