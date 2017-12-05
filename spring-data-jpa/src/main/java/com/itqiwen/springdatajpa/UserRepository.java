package com.itqiwen.springdatajpa;

import com.itqiwen.springdatajpa.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityResult;
import javax.transaction.Transactional;
import java.util.List;

/**
 * PagingAndSortingRepository
 * JpaRepository
 *
 * JpaRepository 继承至 PagingAndSortingRepository
 * PagingAndSortingRepository 继承自 CrudRepository
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    /**
     * ?1  表示索引位，这里的默认位置和 hibernate 不太一样，hibernate 的
     * setParameter(0, "xxx")是从 0 开始的，这里是从 1 开始
     *
     * 执行的还是 HQL 语句
     * @param name
     * @return
     */
    @Query("select u from User u where u.name = ?1")
    User findUserByName(String name);
    @Query(value = "select u from User u where u.name =:name")
    User findUserByName2(@Param("name") String name);

    //使用原生的 sql 进行查询，不再是orm
    @Query(value = "select * from user as u where u.name = ?1", nativeQuery = true)
    User findUserByName3(String name);


    //传递多个参数
    @Query("select u from User u where u.name = ?1 and u.sex= ?2")
    User findUserByNameAndSex(String name, String sex);

    //CrudRepository 默认提供的
    List<User> findUserByNameLike(String name);

    @Query("select u from User u")
    List<User> findAll();




    //修改，需要加事务
    @Modifying
    @Transactional
    @Query("update User u set u.name = ?1 where u.uid = ?2")
    void updateUser(String name, Long uid);


    @Modifying
    @Transactional
    @Query("delete from User u where u.uid = ?1")
    void deleteUser(Long uid);


    //自定义分页方法
    Page<User> findAll(Pageable pageable);
}
