package com.example.jsonparser.service;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.jsonparser.dto.CommandListDto;
import com.example.jsonparser.dto.ElevatorStatusDto;
import com.example.jsonparser.dto.OnCallsResponseDto;
import com.example.jsonparser.model.CommandElevator;

import com.example.jsonparser.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class WebClientService {

    private final WebClient webClient;

    public WebClientService(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("http://localhost:8000").build();
    }

    public Mono<ElevatorStatusDto> getToken(int user_key, int problem_id, int number_of_elevators) {
        String startEndpoint = String.join("/", "/start", String.valueOf(user_key), String.valueOf(problem_id), String.valueOf(number_of_elevators));
        log.info(startEndpoint);
        return webClient.post()
            .uri(startEndpoint)
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToMono(ElevatorStatusDto.class);
    }

    public Mono<OnCallsResponseDto> onCalls(String token) {
        String onCallsEndpoint = "/oncalls";
        return webClient.get()
            .uri(onCallsEndpoint)
            .header("X-Auth-Token", token)
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToMono(OnCallsResponseDto.class);
    }

    public Mono<ElevatorStatusDto> action(String token, List<CommandElevator> commands) {
        String onCallsEndpoint = "/action";
        CommandListDto commandList = new CommandListDto(commands);
        log.info("token = " + token);
        log.info(JsonUtils.toJson(commandList));

        // TODO: 하드코딩 영역 object mapping으로 대체
        return webClient.post()
            .uri(onCallsEndpoint)
            .contentType(MediaType.APPLICATION_JSON)
            .header("X-Auth-Token", token)
            .body(BodyInserters.fromValue(JsonUtils.toJson(commandList)))
            .retrieve()
            .bodyToMono(ElevatorStatusDto.class);
    }
}
