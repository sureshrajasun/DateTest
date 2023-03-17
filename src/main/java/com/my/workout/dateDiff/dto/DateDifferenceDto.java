package com.my.workout.dateDiff.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DateDifferenceDto {

    private String startDate;
    private String endDate;
    private String difference;

}
