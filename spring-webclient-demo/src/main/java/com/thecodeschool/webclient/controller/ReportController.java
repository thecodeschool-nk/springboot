package com.thecodeschool.webclient.controller;

import com.thecodeschool.webclient.model.Report;
import com.thecodeschool.webclient.model.Student;
import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/reports")
public class ReportController {

    @GetMapping("/{id}")
    public Mono<Object> getReport(@PathVariable(name ="id") long id) {
        System.out.println("---- in getReport");

        WebClient webClient = WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(getHttpClient()))
                .baseUrl("http://localhost:8085/")
                .build();
//        Mono<Student> studentMono = webClient.get()
        Mono<Object> mono = webClient.get()
                .uri("students/{id}", id)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//                .retrieve()
//                .bodyToMono(Student.class);
                .exchangeToMono(response -> {
                    if (response.statusCode().equals(HttpStatus.OK)) {
                        return response.bodyToMono(Student.class);
                        /*Mono<Student> st = response.bodyToMono(Student.class);
                        Map<String, Integer> marks = new HashMap<>();
                        marks.put("English", 76);
                        marks.put("Mathematics", 98);
                        marks.put("Value Education", 89);
                        marks.put("Science", 86);
                        marks.put("Hindi", 78);*/
//                        return Mono.just(new Report(id, st, marks));
                    } else if (response.statusCode().is4xxClientError()) {
                        return Mono.just("Error response");
                    } else {
                        return response.createException().flatMap(Mono::error);
                    }
                });
        return mono;
    }

//        return Mono.just(new Report(id, studentMono, marks));

        /*Disposable disposable = studentMono.subscribe(student -> System.out.println(student.getName()));
        if(disposable.isDisposed()) {
            Map<String, Integer> marks = new HashMap<>();
            marks.put("English", 76);
            marks.put("Mathematics", 98);
            marks.put("Value Education", 89);
            marks.put("Science", 86);
            marks.put("Hindi", 78);
            Student st = studentMono.block();
            return new Report(id, st.getName(), marks);
        }*/

//        WebClient webClient = WebClient.create("http://localhost:8085/");
        /*System.out.println("---- calling students api");
        Mono<Student> studentMono = webClient.get()
                .uri("students/200")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToMono(Student.class)
                .doOnSuccess(e -> System.out.println(e.getName()));

        studentMono.log();*/

        /*studentMono.doOnSuccess(student -> {
            System.out.println("---- students api call completed");
            System.out.println("response from student service call: " + student);
            Map<String, Integer> marks = new HashMap<>();
                   marks.put("English", 76);
                   marks.put("Mathematics", 98);
                   marks.put("Value Education", 89);
                   marks.put("Science", 86);
                   marks.put("Hindi", 78);
                   Mono.just(new Report(id, student.getName(), marks));
               });

        studentMono.doOnError(ex -> {
            ex.printStackTrace();
        });*/

        /*while(report==null) {
            System.out.println("waiting for ");
            Thread.sleep(300);
        }*/

//        return report;

        /*Mono<Report> finalResponse = WebClient.create("http://localhost:8085/")
                .get()
                .uri("/employees/1")
                .exchangeToMono(response -> {

                    if (response.statusCode().equals(HttpStatus.OK)) {
                        Student student = response.bodyToMono(Student.class).block();
                        System.out.println("response from student service call: " + student);
                        Map<String, Integer> marks = new HashMap<>();
                        marks.put("English", 76);
                        marks.put("Mathematics", 98);
                        marks.put("Value Education", 89);
                        marks.put("Science", 86);
                        marks.put("Hindi", 78);
                        Mono.just(new Report(id, student.getName(), marks));
                    } else if (response.statusCode().is4xxClientError()) {
                       throw new RuntimeException("4XX error");
                    } else {
                        throw new RuntimeException("Other error");
                    }
                });*/

//        return finalResponse;
//    }

    private HttpClient getHttpClient() {
        return HttpClient.create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 10_000)
                .doOnConnected(conn -> conn
                        .addHandlerLast(new ReadTimeoutHandler(10))
                        .addHandlerLast(new WriteTimeoutHandler(10)));
    }
}
