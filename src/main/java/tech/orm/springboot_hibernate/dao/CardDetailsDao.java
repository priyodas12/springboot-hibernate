package tech.orm.springboot_hibernate.dao;


import java.math.BigInteger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.log4j.Log4j2;
import tech.orm.springboot_hibernate.model.CardDetails;

@Log4j2
@Repository
@Transactional
public class CardDetailsDao {

  @Autowired
  private SessionFactory sessionFactory;


  public CardDetails createCardDetails (CardDetails cardDetails) {
    try {
      // Save the card details
      BigInteger cardId = (BigInteger) getSession ().save (cardDetails);

      // Set the generated ID to the cardDetails object
      cardDetails.setCardId (cardId);

      log.info ("Card Details Created with ID::{},{}", cardId, cardDetails);
    } catch (Exception e) {
      log.error ("Error while creating card details:: {}", e.getMessage ());
    }

    return cardDetails; // Return the saved card details
  }

  public Session getSession () {
    Session session = sessionFactory.getCurrentSession ();
    if (session == null) {
      session = sessionFactory.openSession ();
      return session;
    } else {
      return session;
    }
  }

  public void closeSession () {
    Session session = sessionFactory.getCurrentSession ();
    session.close ();
  }

  public CardDetails getCardDetails (BigInteger cardId) {
    CardDetails cardDetails = null;

    try {
      cardDetails = getSession ().get (CardDetails.class, cardId);
      if (cardDetails != null) {
        log.info ("Card Details Fetched::{},{}", cardId, cardDetails);
        return cardDetails;
      } else {
        log.warn ("Card details not found for ID::{}", cardId);
      }
    } catch (IllegalArgumentException e) {
      log.warn ("Invalid card ID provided::{}", cardId, e);
    } catch (Exception e) {
      log.warn ("Error fetching card details for ID::{}", cardId, e);
    }
    return null;
  }

}
