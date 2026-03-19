package com.exercicio.crud_06.repositories;

import com.exercicio.crud_06.models.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {

}
