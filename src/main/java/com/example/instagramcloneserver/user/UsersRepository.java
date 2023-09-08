package com.example.instagramcloneserver.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users, Integer> {

    @Query(value = "Select * from Users as u where u.id != :id && u.id not in (Select followee from Friends where follower = :id)", nativeQuery = true)
    List<Users> findRandomUsers(@Param("id") int id);

    @Query(value = "Select * from Users as u where u.id != :id && u.id in (Select follower from Friends where followee = :id)", nativeQuery = true)
    List<Users> findFollowers(@Param("id") int id);

    @Query(value = "Select * from Users as u where u.id != :id && u.id in (Select followee from Friends where follower = :id)", nativeQuery = true)
    List<Users> findFollowings(@Param("id") int id);

    @Query(value = "Select * from Users as u where u.name like :pattern% or u.uname like :pattern%", nativeQuery = true)
    List<Users> findByPattern(@Param("pattern") String pattern);
}
