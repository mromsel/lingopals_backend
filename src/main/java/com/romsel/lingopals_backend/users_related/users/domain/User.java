package com.romsel.lingopals_backend.users_related.users.domain;

import java.sql.Date;
import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.romsel.lingopals_backend.images.domain.Image;
import com.romsel.lingopals_backend.masters.languages.domain.Language;
import com.romsel.lingopals_backend.masters.profiles.domain.Profile;
import com.romsel.lingopals_backend.users_related.users_languages.domain.UserLanguages;
import com.romsel.lingopals_backend.users_related.users_progress.domain.UserProgressData;
import com.romsel.lingopals_backend.users_related.users_relationships.domain.UserRelationships;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements UserDetails {

    // #region Properties

    @Id
    @GeneratedValue
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

    // @Column(name = "profile_image_url")
    // private String profileImageUrl;

    @JoinColumn(name = "id_profile_image")
    @ManyToOne(targetEntity = Image.class, optional = true, fetch = FetchType.LAZY)
    private Image profileImage;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_language")
    private Language preferredLanguage;

    @Column(name = "time_zone", nullable = false)
    private String timeZone;

    @OneToOne(orphanRemoval = true, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "id_user_progress_data", nullable = true)
    private UserProgressData userProgressData;

    @ManyToOne
    @JoinColumn(name = "id_profile")
    private Profile profile;

    @OneToMany(mappedBy = "user", orphanRemoval = true, cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<UserLanguages> userLanguages;

    @OneToMany(mappedBy = "user1")
    private Set<UserRelationships> relationships = new HashSet<>();

    /**
     * Adds a new relationship for this user with another user.
     *
     * @param otherUser      The other user involved in the relationship.
     * @param connectionDate The date when the relationship was established.
     */
    public void addRelationship(User otherUser, Date connectionDate) {
        UserRelationships relationship = new UserRelationships();
        relationship.setUser1(this);
        relationship.setUser2(otherUser);
        relationship.setConnectionDate(connectionDate);
        relationships.add(relationship);
    }

    // #endregion

    // #region UserDetails methods

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(profile.getName()));
    }

    @Override
    public String getPassword() {
        return passwordHash;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    // #endregion
}
