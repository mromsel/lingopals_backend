package com.romsel.lingopals_backend.domain.entities.masters;

import java.util.List;

import com.romsel.lingopals_backend.domain.entities.users_related.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "profiles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profile", nullable = false)
    private Integer idProfile;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "profiles")
    private List<User> users;

}
