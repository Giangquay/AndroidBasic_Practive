package vn.minhgiang.RoomdataBase.DAO;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import vn.minhgiang.RoomdataBase.DTO.User;


@Dao
public interface UserDao {

    @Insert
    void insertUser(User user);

    @Query("SELECT * FROM user")
    List<User> getlistUser();

    @Query("SELECT * FROM user where userName= :username")
    List<User> checkUser(String username);
    @Update
    void updateUser(User user);
    @Delete
    void deleteUser(User user);
    @Query("DELETE  FROM user")
    void deleteAllUser();
    @Query("SELECT * FROM user where userName Like '%' || :name || '%' ")
    List<User> searchName(String name);
}
