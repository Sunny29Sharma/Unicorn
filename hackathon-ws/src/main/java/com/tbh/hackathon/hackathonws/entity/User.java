package com.tbh.hackathon.hackathonws.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

@Table(name="users")
@Entity
public class User {
//properties
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private String userName;
private Long userId;
private Boolean logisticsEnabled;
private Boolean promotionsEnabled;
private Boolean dueRemainderEnabled;
private Integer rowstate;

}