package com.romsel.lingopals_backend.masters.xp_levels.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface XPLevelRepository extends CrudRepository<XPLevel, Integer> {

    @Query("SELECT xpl FROM XPLevel xpl " +
            "WHERE xpl.xpRangeStart >= :xpPoints " +
            "AND xpl.xpRangeEnd <= :xpPoints")
    XPLevel findByXpPoints(Integer xpPoints);
}
