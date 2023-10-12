package ws_server.creditcard.utils;

import io.spring.guides.gs_producing_web_service.GetAllCardsResponse;
import io.spring.guides.gs_producing_web_service.GetCreditRequest;
import io.spring.guides.gs_producing_web_service.GetCreditResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CreditEndPoint {
    private static final String  NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";
 public CreditRepository creditRepository;

 @Autowired
    public CreditEndPoint(CreditRepository creditRepository) {
        this.creditRepository = creditRepository;
    }
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCreditRequest")
    @ResponsePayload
    public GetCreditResponse getCredit(@RequestPayload GetCreditRequest request){
     GetCreditResponse response= new GetCreditResponse();
     response.setCustomer(creditRepository.findCard(request.getName()));
     return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllCardsRequest")
    @ResponsePayload
    public GetAllCardsResponse getAllCards(){
    GetAllCardsResponse response = new GetAllCardsResponse();
        response.getCollection().addAll(creditRepository.allCards());
        return response;
    }
}
