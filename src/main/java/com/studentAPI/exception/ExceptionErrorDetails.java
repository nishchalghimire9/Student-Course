package com.studentAPI.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@ToString

public class ExceptionErrorDetails {

    private String excCode;
    private LocalDateTime currentTime;
    private String excDescription;

    public ExceptionErrorDetails(String excCode, LocalDateTime currentTime, String excDescription) {
        this.excCode = excCode;
        this.currentTime = currentTime;
        this.excDescription = excDescription;
    }


}

