package com.example.bugwarshealerbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.bugwarshealerbackend.service.BugService;

@RestController
@RequestMapping("/api/bugs")
public class BugController {

    @Autowired
    private BugService bugService;

    @DeleteMapping("/{bugId}")
    public ResponseEntity<?> deleteBug(@PathVariable Long bugId) {
        try {
            bugService.deleteBug(bugId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error deleting bug: " + e.getMessage());
        }
    }
}
