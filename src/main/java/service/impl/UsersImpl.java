package service.impl;

import entity.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import repo.UserRepo;
import service.UserService;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class UsersImpl implements UserService {

        private final UserRepo repo;
        public void insertUsers(Users users) {
            repo.save(users);
        }
        public List<Users> getAll() {
            return repo.findAll();
        }

        @Override
        public Long delete(Long id) {
            Optional<Users> optionalStudent=repo.findById(id);

            if (optionalStudent.isPresent()){
                Users users = optionalStudent.get();
                repo.delete(users);
            }
            else throw new NullPointerException(String.format("DELETE:с id %s не найдена", id));
            return id;
        }

        public void update(Long id, Users users) {
            Users existingStudent = repo.findById(id).orElse(null);
            if (existingStudent != null) {
                existingStudent.setName(users.getName());
                repo.save(existingStudent);
            }

        }
}

