package com.youcode.Pharmacie.dao;


import com.youcode.Pharmacie.model.Article;

import java.sql.SQLException;
import java.util.List;

public interface DAO {


    public void save(Article user) throws SQLException;
    public Article getById(int id);
    public List<Article> getAll();
    public boolean delete(int id) throws SQLException;
    public boolean update(Article item) throws SQLException;

}
