package pru.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pru.demo.entities.PlayerAccount;

@Repository
public interface PlayerAccountRepo extends JpaRepository<PlayerAccount, Integer>{
    
}

