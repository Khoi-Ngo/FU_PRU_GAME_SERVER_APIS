package pru.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import pru.demo.entities.PlayerAccount;

public interface PlayerAccountRepo extends JpaRepository<PlayerAccount, Integer>{
    
}

