package org.springboot_study.mybatis;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {

    @Select("SELECT * FROM USER WHERE ID = #{id}")
    User find(@Param("id") int id);

    @Insert("INSERT INTO USER(ID, NAME) VALUES(#{id}, #{name})")
    int insert(User user);

    @Update("UPDATE USER SET NAME = #{name} WHERE ID = #{id}")
    void update(User user);

    @Delete("DELETE FROM USER WHERE ID = #{id}")
    void delete(int id);
}