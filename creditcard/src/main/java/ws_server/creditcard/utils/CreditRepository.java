package ws_server.creditcard.utils;
import io.spring.guides.gs_producing_web_service.Card;
import io.spring.guides.gs_producing_web_service.CardType;
import io.spring.guides.gs_producing_web_service.Currency;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Component
public class CreditRepository {
  private static final Map<String, Card> cards = new HashMap<>();

  @PostConstruct
  public void initData() {
    Card card1 = new Card();
    card1.setName("person1");
    card1.setTotal(2000);
    card1.setBalance(1200);
    card1.setCurrency(Currency.EUR);
    card1.setCardType(CardType.MASTER);

    Card card2 = new Card();
    card2.setName("person2");
    card2.setTotal(5000);
    card2.setBalance(200);
    card2.setCurrency(Currency.EUR);
    card2.setCardType(CardType.VISA);

    Card card3 = new Card();
    card3.setName("person3");
    card3.setTotal(12000);
    card3.setBalance(2200);
    card3.setCurrency(Currency.EUR);
    card3.setCardType(CardType.MASTER);

    cards.put(card1.getName(), card1);
    cards.put(card2.getName(), card2);
    cards.put(card3.getName(), card3);
    }
    public  Card findCard(String name){
     return cards.get(name);
  }
  public Collection<Card> allCards(){
  return cards.values();
  }

}
