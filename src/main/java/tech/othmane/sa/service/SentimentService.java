package tech.othmane.sa.service;

import org.springframework.stereotype.Service;
import tech.othmane.sa.entites.Client;
import tech.othmane.sa.entites.Sentiment;
import tech.othmane.sa.repository.SentimentRepository;

import java.util.List;

@Service
public class SentimentService {
    private SentimentRepository sentimentRepository;
    private ClientService clientService;

    public SentimentService(SentimentRepository sentimentRepository, ClientService clientService) {
        this.sentimentRepository = sentimentRepository;
        this.clientService = clientService;
    }

    public void createSentiment(Sentiment sentiment){
        Client client = this.clientService.lireOuCreer(sentiment.getClient());
        sentiment.setClient(client);
        this.sentimentRepository.save(sentiment);
    }

    public List<Sentiment> rechercher() {
        return this.sentimentRepository.findAll();
    }
}
