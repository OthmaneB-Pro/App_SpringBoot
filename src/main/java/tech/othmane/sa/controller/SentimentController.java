package tech.othmane.sa.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tech.othmane.sa.entites.Sentiment;
import tech.othmane.sa.service.SentimentService;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "sentiment", produces = APPLICATION_JSON_VALUE)
public class SentimentController {

    private SentimentService sentimentService;

    public SentimentController(SentimentService sentimentService) {
        this.sentimentService = sentimentService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void createSentiment(@RequestBody Sentiment sentiment){
        this.sentimentService.createSentiment(sentiment);
    }

    @GetMapping
    public @ResponseBody List<Sentiment> rechercher(){
        return this.sentimentService.rechercher();
    }
}
