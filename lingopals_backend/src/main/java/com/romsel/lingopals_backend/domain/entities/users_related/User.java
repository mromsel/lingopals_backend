package com.romsel.lingopals_backend.domain.entities.users_related;

import java.time.ZonedDateTime;
import java.util.List;

import com.romsel.lingopals_backend.domain.entities.words_related.Language;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user", nullable = false)
    private Long idUser;

    @Column(name = "username", unique = true, nullable = false)
    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters")
    @Pattern(regexp = "^[a-zA-Z0-9_-]+$", message = "Username can only contain letters, numbers, underscores (_), and hyphens (-)")
    private String username;

    @Column(name = "email", unique = true, nullable = false)
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Invalid email")
    private String email;

    @Column(name = "password_hash", nullable = false)
    @Size(min = 6, message = "Password must be at least 6 characters long")
    @ToString.Exclude
    private String passwordHash; // ignore in dto

    @Column(name = "registration_date")
    private ZonedDateTime registrationDate;

    @Column(name = "profile_image_url")
    private String profileImageUrl;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_language")
    private Language preferredLanguage;

    @OneToOne(optional = false, orphanRemoval = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user_progress_data", updatable = false)
    private UserProgressData userProgressData;

    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<UserActivity> activities;

}
