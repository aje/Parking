package com.dao;

import com.models.Spot;

import java.util.List;

public interface SpotDao {
    Boolean add(Spot spot);                           // insert into database
    Boolean save(Spot spot, int id);                  // save with having Id
    Boolean save(Spot spot);                          // saving without having Id
    Boolean delete(int id);                         // delete lot / change status to 0
    Spot get(int id);                                // fetch one lot
    List<Spot> get(String queryString);              // fetch list of lots

    Number countSpots(String queryString);
}
