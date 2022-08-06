package com.example.hibernatedemo.hibernate;

import com.example.hibernatedemo.contracts.RepositoryInterface;
import com.example.hibernatedemo.dto.Team;
import com.example.hibernatedemo.utilities.DbContext;

import java.util.List;

public class TeamRepository implements RepositoryInterface<Team> {

    @Override
    public void create(Team entity) {
        var session = DbContext.getSession();
        session.getTransaction();

        try {
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
            session.close();

        } catch (Exception e) {
            e.printStackTrace();
            session.close();
        }
    }

    @Override
    public Team get(int id) {
        return null;
    }

    @Override
    public List<Team> get() {
        return null;
    }

    @Override
    public void update(int id, Team entity) {

    }

    @Override
    public void delete(int id) {

    }
}
