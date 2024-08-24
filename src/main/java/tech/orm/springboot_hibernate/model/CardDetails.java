package tech.orm.springboot_hibernate.model;


import java.math.BigInteger;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table (name="plastic_card_details")
public class CardDetails {

  @Id
  @GeneratedValue(strategy =GenerationType.SEQUENCE)
  @Column(name = "card_id")
  private BigInteger cardId;

  @Column(name = "card_holder_name")
  private String cardHolderName;

  @Column(name = "card_number")
  private BigInteger cardNumber;

  @Column(name = "validity_start_date")
  private Date validityStartDate;

  @Column(name = "validity_end_date")
  private Date validityEndDate;

  @Column(name = "ccv_number")
  private Integer ccvNumber;

}
