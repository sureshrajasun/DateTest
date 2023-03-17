package com.my.workout.datediff.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DateDifferenceDTO {

    private String startDate;
    private String endDate;
    private String difference;

}
