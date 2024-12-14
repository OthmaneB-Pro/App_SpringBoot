package tech.othmane.sa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.othmane.sa.entites.Sentiment;

public interface SentimentRepository extends JpaRepository<Sentiment, Integer> {

}
