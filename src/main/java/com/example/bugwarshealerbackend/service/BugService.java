package com.example.bugwarshealerbackend.service;

import com.example.bugwarshealerbackend.exceptions.ScriptLimitExceededException;
import com.example.bugwarshealerbackend.jpa.BugRepository;
import com.example.bugwarshealerbackend.model.Bug;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BugService {

    @Autowired
    private BugRepository bugRepository;

    public int countUserScripts(long userId) {
        return BugRepository.countByUserId(userId);
    }

    public void saveBugScript(Bug script) {
        int scriptCount = countUserScripts(script.getUser().getId());
        if (scriptCount >= 5) {
            throw new ScriptLimitExceededException("You cannot save more than 5 scripts. Please delete an existing one first.");
        }
        bugRepository.save(script);
    }

    public void deleteBug(Long bugId) {
        bugRepository.deleteById(bugId);
    }
}
