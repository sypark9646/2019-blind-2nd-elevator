package com.example.jsonparser.model;

import java.util.List;

import lombok.ToString;

@ToString
public class Elevator {
    private int id;
    private int floor;
    private List<Call> passengers;
    private Status status;
}
