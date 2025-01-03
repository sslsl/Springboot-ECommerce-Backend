package com.echo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.echo.models.Address;

@Repository
public interface AddressDao extends JpaRepository<Address, Integer>{

}
