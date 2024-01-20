package com.example.bugwarshealerbackend.jpa;

import com.example.bugwarshealerbackend.model.Bug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BugRepository extends JpaRepository<Bug, Long> {

    // Example custom query (modify as needed)
    @Query("SELECT COUNT(bs) FROM Bug bs WHERE bs.user.id = :userId")
    int countByUserId(Long userId);

}
