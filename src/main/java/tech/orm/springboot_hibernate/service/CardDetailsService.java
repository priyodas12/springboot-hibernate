package tech.orm.springboot_hibernate.service;


import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.orm.springboot_hibernate.dao.CardDetailsDao;
import tech.orm.springboot_hibernate.model.CardDetails;

@Service
public class CardDetailsService {

  @Autowired
  private CardDetailsDao cardDetailsDao;

  public CardDetails saveCardDetails (CardDetails cardDetails) {
    return cardDetailsDao.createCardDetails (cardDetails);
  }

  public CardDetails fetchCardDetails (BigInteger cardId) {
    return cardDetailsDao.getCardDetails (cardId);
  }

}
