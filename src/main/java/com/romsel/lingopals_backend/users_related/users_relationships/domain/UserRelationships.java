package com.romsel.lingopals_backend.users_related.users_relationships.domain;

import java.sql.Date;

import com.romsel.lingopals_backend.users_related.users.domain.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users_relationships")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRelationships {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRelationship;

    @ManyToOne
    @JoinColumn(name = "id_user1")
    private User user1;

    @ManyToOne
    @JoinColumn(name = "id_user2")
    private User user2;

    @Column(name = "connection_date")
    private Date connectionDate;

}
