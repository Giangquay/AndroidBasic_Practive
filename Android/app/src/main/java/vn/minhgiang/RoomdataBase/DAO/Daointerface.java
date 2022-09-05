package vn.minhgiang.RoomdataBase.DAO;

import java.util.ArrayList;
import java.util.List;

public interface Daointerface <T>{
    public int insert(T t);

    public int update(T t);

    public int delete(T t);

    public List<T> selectAll();

    public T selectById(T t);

    public ArrayList<T> selectByCondition(String condition);
}
