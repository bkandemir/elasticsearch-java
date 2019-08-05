package edu.sabanciuniv.berkay.elasticsearch;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.sabanciuniv.berkay.elasticsearch.domain.User;
import edu.sabanciuniv.berkay.elasticsearch.repository.UserRepository;

@SpringBootApplication
public class ElasticsearchApplication {
	
    @Autowired
    private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(ElasticsearchApplication.class, args);
	}
	
    @PostConstruct
    private void init()
    {
        userRepository.save(new User("1", "Ross", "Geller", 53, "New York","Manhattan"));
        userRepository.save(new User("2", "Monica", "Geller",55, "New York","Manhattan"));
        userRepository.save(new User("3", "Chandler", "Bing",50, "New York", "Manhattan"));
        userRepository.save(new User("4", "Joey", "Tribbiani",52, "New York","Manhattan"));
        userRepository.save(new User("5", "Rachel", "Green",50, "New York", "Manhattan"));
        userRepository.save(new User("6", "Phoebe", "Buffay",56, "New York","Manhattan"));
        userRepository.save(new User("7", "Mike", "Hannigan",50, "New York", "Manhattan"));
        userRepository.save(new User("8", "Jack", "Geller",81, "New York", "Manhattan"));
        userRepository.save(new User("9", "Judy", "Geller",84, "New York","Manhattan"));
        userRepository.save(new User("10", "Janice", "Wheeler",58, "New York", "Manhattan"));
        userRepository.save(new User("11", "Carol", "Willick",57, "New York","Manhattan"));
        userRepository.save(new User("12", "Estelle", "Leonard",74, "New York", "Manhattan"));
        userRepository.save(new User("13", "Charlie", "Wheeler",57, "New York","Manhattan"));
        
    }

}
