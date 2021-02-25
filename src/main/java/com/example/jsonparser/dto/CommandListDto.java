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
}
