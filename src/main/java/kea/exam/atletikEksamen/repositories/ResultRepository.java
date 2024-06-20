package kea.exam.atletikEksamen.repositories;

import kea.exam.atletikEksamen.entities.Result;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultRepository extends JpaRepository<Result, Integer> {
}
