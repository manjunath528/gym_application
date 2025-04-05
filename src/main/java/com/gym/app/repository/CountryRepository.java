package com.gym.app.repository;



import com.gym.app.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Manjunath Reddy
 */
public interface CountryRepository extends JpaRepository<Country, Long> {

}