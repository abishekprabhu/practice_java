package coder.abishekprabhu.springsample.repository;

import coder.abishekprabhu.springsample.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,Long> {
}
