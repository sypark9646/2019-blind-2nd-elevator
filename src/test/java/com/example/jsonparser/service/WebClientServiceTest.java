package com.example.jsonparser.service;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.jsonparser.dto.OnCallsResponseDto;
import com.example.jsonparser.dto.ElevatorStatusDto;
import com.example.jsonparser.model.Command;
import com.example.jsonparser.model.CommandElevator;
import reactor.core.publisher.Mono;

@SpringBootTest
public class WebClientServiceTest {

    @Autowired
    WebClientService webClientService;

    @DisplayName("start api 테스트")
    @Test
    void startAPI() {
        Mono<ElevatorStatusDto> startResponseDto = webClientService.getToken(1, 1, 1);
        System.out.println(startResponseDto.block());
    }

    @DisplayName("on calls api 테스트")
    @Test
    void onCallAPI(){
        ElevatorStatusDto startResponseDto = webClientService.getToken(1, 1, 1).block();
        Mono<OnCallsResponseDto> onCallsResponseDto = webClientService.onCalls(startResponseDto.getToken());
        System.out.println(onCallsResponseDto.block());
    }

    @DisplayName("action api 테스트")
    @Test
    void actionAPI(){
        ElevatorStatusDto startResponseDto = webClientService.getToken(1, 1, 1).block();
        CommandElevator commandElevator = new CommandElevator(0, Command.STOP, List.of(0));
        Mono<ElevatorStatusDto> elevatorStatusDto = webClientService.action(startResponseDto.getToken(), List.of(commandElevator));
        System.out.println(elevatorStatusDto.block());
    }
}
