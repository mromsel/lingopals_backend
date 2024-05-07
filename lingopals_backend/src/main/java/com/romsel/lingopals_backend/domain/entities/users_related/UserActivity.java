package com.romsel.lingopals_backend.domain.entities.users_related;

import java.time.ZonedDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users_activity")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_user_activity")
    private Long idUserActivity;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    @Column(name = "activity_date", nullable = false)
    private ZonedDateTime date;

    /**
     * NOTE: use Activity enum for this property
     * 
     * @see com.romsel.lingopals_backend.domain.entities.elements.Activity;
     */
    @Column(name = "activity_type", nullable = false)
    private String type;

    @Column(name = "lesson", nullable = true)
    private Integer idLesson;

    @Column(name = "xp_gained")
    private Integer xpGained;

    @Transient
    private List<ActivityResult> results;
}
