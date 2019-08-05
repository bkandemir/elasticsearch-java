package edu.sabanciuniv.berkay.elasticsearch.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import edu.sabanciuniv.berkay.elasticsearch.domain.User;



@Repository
public interface UserRepository extends ElasticsearchRepository<User, String> {
	
	public List<User> findByFirstNameContaining(String firstName);

}
