package com.example.multipleds.Repository.oracle;

import com.example.multipleds.Model.oracle.ActiveMqLock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActiveMqLockRepository extends JpaRepository<ActiveMqLock, Long> {


}
