package com.example.jsonparser.dto;

import java.util.List;

import com.example.jsonparser.model.Elevator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class ElevatorStatusDto {
    private String token;
    private int timestamp;
    private List<Elevator> elevators;
    @JsonProperty("is_end")
    private boolean isEnd;
}
