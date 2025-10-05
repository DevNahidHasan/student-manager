package com.nahid.studentmanager.repo;

import com.nahid.studentmanager.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, String> {

}
