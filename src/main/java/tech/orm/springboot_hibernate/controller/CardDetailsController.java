package tech.orm.springboot_hibernate.controller;


import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tech.orm.springboot_hibernate.model.CardDetails;
import tech.orm.springboot_hibernate.service.CardDetailsService;

@RequestMapping("/api/credits")
@RestController
public class CardDetailsController {

  @Autowired
  CardDetailsService cardDetailsService;


  @PostMapping("/cards")
  public ResponseEntity<CardDetails> getCardDetails(@Validated @RequestBody CardDetails cardDetails){
   return ResponseEntity.ok ( cardDetailsService.saveCardDetails (cardDetails));
  }

  @GetMapping ("/cards/{cardId}")
  public ResponseEntity<CardDetails> getCardDetails(@Validated @PathVariable("cardId") BigInteger cardId){
    return ResponseEntity.ok ( cardDetailsService.fetchCardDetails (cardId));
  }

}
