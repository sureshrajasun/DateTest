package com.qantas.common.datediff.controller;

import com.qantas.common.datediff.dto.DateDifferenceDTO;
import com.qantas.common.datediff.service.DateDifferenceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/date")
class DateDifferenceController {

    @Autowired
    DateDifferenceService dateDifferenceService;

    @GetMapping("/difference")
    @ResponseBody
    public ResponseEntity<DateDifferenceDTO> getDateDifference(@RequestParam String startDate, @RequestParam String endDate) {
        log.info("Start Date received: {}", startDate);
        log.info("End Date Received: {}", endDate);

        DateDifferenceDTO dateDifferenceDto = DateDifferenceDTO.builder()
                .startDate(startDate)
                .endDate(endDate)
                .difference(dateDifferenceService.getDateDifference(startDate, endDate))
                .build();

        log.info("Sending success response: {}", dateDifferenceDto);

        return new ResponseEntity<>(dateDifferenceDto, HttpStatus.OK);
    }
}