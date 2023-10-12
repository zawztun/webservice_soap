package com.credit.client.utils;

import com.cards.wsdl.GetAllCardsRequest;
import com.cards.wsdl.GetAllCardsResponse;
import com.cards.wsdl.GetCreditRequest;
import com.cards.wsdl.GetCreditResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class ServiceClient extends WebServiceGatewaySupport {
  public GetCreditResponse getCredit(String name) {
    GetCreditRequest request = new GetCreditRequest();
    request.setName(name);
    GetCreditResponse response =
        (GetCreditResponse)
            getWebServiceTemplate()
                .marshalSendAndReceive(
                    request,
                    new SoapActionCallback(
                        "http://spring.io/guides/gs-producing-web-service/GetCardRequest"));
    return response;
  }
  public GetAllCardsResponse getAllCards() {
    GetAllCardsRequest request = new GetAllCardsRequest();
    GetAllCardsResponse response =
        (GetAllCardsResponse)
            getWebServiceTemplate()
                .marshalSendAndReceive(
                    //"http://localhost:8080/ws/cards",
                    request,
                    new SoapActionCallback(
                        "http://spring.io/guides/gs-producing-web-service/GetCRequest"));
    return response;
  }
}
