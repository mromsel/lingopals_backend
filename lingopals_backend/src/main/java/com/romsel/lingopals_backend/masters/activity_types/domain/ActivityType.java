package com.romsel.lingopals_backend.masters.activity_types.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "activity_types")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActivityType {

    @Id
    @GeneratedValue
    @Column(name = "id_activity_type")
    private Integer idActivityType;

    @Column(name = "type", unique = true, nullable = false)
    private String type;
}
