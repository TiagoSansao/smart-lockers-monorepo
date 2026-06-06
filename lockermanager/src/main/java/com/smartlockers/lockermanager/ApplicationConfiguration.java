package com.smartlockers.lockermanager;

import com.smartlockers.lockermanager.domain.ports.inbound.CreateLockerUseCase;
import com.smartlockers.lockermanager.domain.ports.inbound.ListLockersUseCase;
import com.smartlockers.lockermanager.domain.ports.inbound.ReserveLockerShelfUseCase;
import com.smartlockers.lockermanager.domain.ports.inbound.UnlockLockerShelfUseCase;
import com.smartlockers.lockermanager.domain.ports.outbound.LockerRepository;
import com.smartlockers.lockermanager.domain.ports.outbound.LockerShelfRepository;
import com.smartlockers.lockermanager.domain.service.LockerService;
import com.smartlockers.lockermanager.domain.service.LockerShelfService;
import com.smartlockers.lockermanager.drivers.persistence.adaptee.JpaLockerRepository;
import com.smartlockers.lockermanager.drivers.persistence.adaptee.JpaLockerShelfRepository;
import com.smartlockers.lockermanager.drivers.persistence.adapter.JpaRepositoryToLockerRepositoryAdapter;
import com.smartlockers.lockermanager.drivers.persistence.adapter.JpaRepositoryToLockerShelfRepositoryAdapter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public LockerRepository lockerRepository(JpaLockerRepository jpaLockerRepository) {
        return new JpaRepositoryToLockerRepositoryAdapter(jpaLockerRepository);
    }

    @Bean
    public LockerShelfRepository lockerShelfRepository(JpaLockerShelfRepository jpaLockerShelfRepository) {
        return new JpaRepositoryToLockerShelfRepositoryAdapter(jpaLockerShelfRepository);
    }

    @Bean
    public CreateLockerUseCase createLockerUseCase(LockerRepository lockerRepository) {
        return new LockerService(lockerRepository);
    }

    @Bean
    public ListLockersUseCase listLockersUseCase(LockerRepository lockerRepository) {
        return new LockerService(lockerRepository);
    }

    @Bean
    public ReserveLockerShelfUseCase reserveLockerShelfUseCase(LockerShelfRepository lockerShelfRepository) {
        return new LockerShelfService(lockerShelfRepository);
    }

    @Bean
    public UnlockLockerShelfUseCase unlockLockerShelfUseCase(LockerShelfRepository lockerShelfRepository) {
        return new LockerShelfService(lockerShelfRepository);
    }
}
