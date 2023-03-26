package com.proyecto.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


import com.proyecto.api.entity.Hotels;

public interface HotelsRepository extends JpaRepository<Hotels, Integer>, JpaSpecificationExecutor<Hotels>{

}
