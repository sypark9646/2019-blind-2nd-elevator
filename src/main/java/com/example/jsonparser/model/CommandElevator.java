package com.example.jsonparser.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CommandElevator {
    // TODO: nested class 에서 snake case mapping 방법
    @JsonProperty("elevator_id")
    private final int elevator_id;
    private final Command command;
    @JsonProperty("call_ids")
    private final List<Integer> call_ids;

    @Override
    public String toString() {
        return "{\n"
            + "      \"elevator_id\": " + elevator_id + ","
            + "      \"command\": " + "\"" + command + "\"" + ","
            + "      \"call_ids\": " + call_ids
            + "    }";
    }
}
