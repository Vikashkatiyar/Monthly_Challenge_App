/**
 * 
 */
package com.boot.ChallengeApp;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author vikash katiyar
 *
 */
public interface ChallengeRepository extends JpaRepository<Challenge, Long> {

	/**
	 * @param month
	 * @return
	 */
	Optional<Challenge> findByMonthIgnoreCase(String month);
  
}
