package com.example.myapp2.repositories;
import com.example.myapp2.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
