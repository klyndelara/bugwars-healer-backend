package com.example.bugwarshealerbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bugs")
public class Bug {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "bug_name", nullable = false)
    private String bugName;

    @Column(name = "script", columnDefinition = "TEXT")
    private String script;

    @Column(name = "sprite_image_path")
    private String spriteImagePath;

}
