package com.candy.geek.week05.jdbc.hikari.repository;

import com.candy.geek.week05.jdbc.hikari.entity.SysDept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zh0809
 * @date 2020/11/17 8:26
 **/
@Repository
public interface DeptRepository extends JpaRepository<SysDept, String> {
}
