package com.test.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

@Entity
@Data
@Table(name = "stock_status")
public class StockStatus {

  @Id
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "status", nullable = false)
  private String status;

  @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
  @Column(name = "time_modified", nullable = false)
  private DateTime timeModified;

  @Column(name = "time_created", nullable = true)
  @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
  private DateTime timeCreated;

}
