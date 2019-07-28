package com.zique.demo.datasource;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session; //this is the required session object
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zique.demo.dto.Todo;

@Repository
public class TodoDaoHibernateImpl implements TodoDao {

	// Wire entitymanager with constructor
	private EntityManager entityManager;

	@Autowired
	public TodoDaoHibernateImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override
	public List<Todo> findAll() {
		System.out.println("===>>>This is findAll() from " + getClass().getName());
		// Get a hibernate session to database
		Session session = entityManager.unwrap(Session.class);

		// create a query for finding all Todos
		Query<Todo> query = session.createQuery("from Todo", Todo.class);

		// execute query
		List<Todo> todos = query.getResultList();

		// return results
		return todos;
	}

	@Override
	public Todo findById(long id) {
		// Get a hibernate session to database
		Session session = entityManager.unwrap(Session.class);

		// find the Todo by id
		Todo todo = session.get(Todo.class, id);

		// return results
		return todo;
	}

	@Override
	/**
	 * Will save or update depending on the id 0 is insert, non-zero is update
	 */
	public Todo save(Todo todo) {
		// Get a hibernate session to database
		Session session = entityManager.unwrap(Session.class);

		// create a query for saving or updating the Todo argument
		session.saveOrUpdate(todo);

		// return results
		return todo;
	}

	@Override
	public Todo deleteById(long id) {
		// Get a hibernate session to database
		Session session = entityManager.unwrap(Session.class);
		
		//find the todo by id and hold on to it for return
		Todo temp = this.findById(id);
		
		// create a query for deleting Todo entity by id
		Query query = 
				session.createQuery("delete from Todo where id=:id");
		
		query.setParameter("id", id);
		
		query.executeUpdate();
		
		return temp;
	}

}
