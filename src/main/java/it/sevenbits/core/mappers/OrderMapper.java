package it.sevenbits.core.mappers;

import it.sevenbits.core.domain.Order;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface OrderMapper {

    @Select("SELECT id, email, username, message \n" +
            "FROM orders \n" +
            "WHERE id = #{id}")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "email", property = "email"),
            @Result(column = "username", property = "name"),
            @Result(column = "message", property = "message")
    })
    Order find(@Param("id") final Integer id);

    @Select("SELECT id, email, username, message \n" +
            "FROM orders \n")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "email", property = "email"),
            @Result(column = "username", property = "name"),
            @Result(column = "message", property = "message")
    })
    List<Order> findAll();

    @Insert("INSERT INTO orders (email, username, message) \n" +
            "VALUES (#{email}, #{name}, #{message})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void save(final Order order);
}
