package com.smartlockers.logManager.service;

import com.smartlockers.logManager.entity.Log;
import com.smartlockers.logManager.persistence.LogRepository;
import lombok.AllArgsConstructor;
import org.jspecify.annotations.NullMarked;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NullMarked
@AllArgsConstructor
public class LogService {

    private final LogRepository logRepository;

    public Long save(String event, Long lockerShelfId, Long actorId) {
        Log log = new Log();
        log.setEvent(event);
        log.setLockerShelfId(lockerShelfId);
        log.setActorId(actorId);

        logRepository.save(log);

        return log.getId();
    }

    public List<Log> list() {
        return logRepository.findAll();
    }
}
