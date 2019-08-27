package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

@Component
public class LoginRepositoryImpl implements LoginRepository{

	@Autowired
   MongoTemplate mongoTemplate;
	 
	@Override
	public List<Users> findUserByName(String name,String password) {
		Query query = new Query();
		System.out.println(name);
		System.out.println(password);

		query.addCriteria(Criteria.where("Username").is(name).and("Password").is(password));
		List<Users> users = mongoTemplate.find(query, Users.class);
		return users;
	}

	@Override
	public <S extends Users> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Users> findAll() {
		// TODO Auto-generated method stub
		return mongoTemplate.findAll(Users.class);
	}

	@Override
	public List<Users> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Users> S insert(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Users> List<S> insert(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Users> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Users> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Users> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Users> S save(S entity) {
		
		System.out.println("Saved");
		Query query = new Query();
				query.addCriteria(Criteria.where("Username").is(entity.getUsername()).and("logged").is(false));
				query.fields().include("Username");

				Users userTest3 = mongoTemplate.findOne(query, Users.class);
				System.out.println("userTest3 - " + userTest3);

				Update update = new Update();
				update.set("logged",true);

				mongoTemplate.updateFirst(query, update, Users.class);

				//returns everything
				Query query1 = new Query();
				query1.addCriteria(Criteria.where("name").is("appleC"));

				Users userTest3_1 = mongoTemplate.findOne(query1, Users.class);
				System.out.println("userTest3_1 - " + userTest3_1);
				
				return (S) userTest3_1;

		
	}

	@Override
	public Optional<Users> findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Users> findAllById(Iterable<String> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Users entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends Users> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Users> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Users> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Users> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Users> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Users findByUsername(String username) {
		Query query = new Query();
		query.addCriteria(Criteria.where("Username").is(username));
		List<Users> users = mongoTemplate.find(query, Users.class);
		return users.get(0);
	}

}
