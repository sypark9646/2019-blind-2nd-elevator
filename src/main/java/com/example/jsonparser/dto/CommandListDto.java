package com.example.jsonparser.dto;

import java.util.List;

import com.example.jsonparser.model.CommandElevator;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CommandListDto {
    private List<CommandElevator> commands;

    @JsonCreator
    public CommandListDto(@JsonProperty("commands") List<CommandElevator> commands) {
        this.commands = commands;
    }

    @Override
    public String toString(){
        // TODO: 하드코딩 영역 object mapping으로 대체
        return "{\n"
            + "    \"commands\": [{\n"
            + "      \"elevator_id\": 0,\n"
            + "      \"command\": \"STOP\",\n"
            + "      \"call_ids\": [0]\n"
            + "    }]\n"
            + "}";
    }
}
