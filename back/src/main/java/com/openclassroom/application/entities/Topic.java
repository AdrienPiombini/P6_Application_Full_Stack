package com.openclassroom.application.entities;

import com.openclassroom.application.entities.Enum.Title;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "Topic")
@NoArgsConstructor
public class Topic {
  @Id
  @Enumerated(EnumType.STRING)
  private Title title;

  private String description;
}
