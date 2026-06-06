package com.smartlockers.lockermanager;

import com.smartlockers.lockermanager.domain.ports.inbound.CreateLockerUseCase;
import com.smartlockers.lockermanager.domain.ports.inbound.ListLockersUseCase;
import com.smartlockers.lockermanager.domain.ports.outbound.LockerRepository;
import com.smartlockers.lockermanager.domain.service.LockerService;
import com.smartlockers.lockermanager.drivers.persistence.JpaLockerRepository;
import com.smartlockers.lockermanager.drivers.persistence.JpaRepositoryToLockerRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public LockerRepository lockerRepository(JpaLockerRepository jpaLockerRepository) {
        return new JpaRepositoryToLockerRepositoryAdapter(jpaLockerRepository);
    }

    @Bean
    public CreateLockerUseCase createLockerUseCase(LockerRepository lockerRepository) {
        return new LockerService(lockerRepository);
    }

    @Bean
    public ListLockersUseCase listLockersUseCase(LockerRepository lockerRepository) {
        return new LockerService(lockerRepository);
    }
}
