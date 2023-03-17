package com.my.workout.datediff.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ErrorMessage {

 private String message;
 private String type;
 private String errorCode;
 private String status;

}
