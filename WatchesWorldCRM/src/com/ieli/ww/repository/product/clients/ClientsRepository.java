package com.ieli.ww.repository.product.clients;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ieli.ww.model.product.parties.Client;

@Repository("clientsRepository")
@Transactional
public interface ClientsRepository extends JpaRepository<Client, Long> {

	Long countByGenderAndEnabled(String gender, Boolean enabled);

}
