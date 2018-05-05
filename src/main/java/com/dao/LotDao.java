package com.dao;

import com.models.Lot;
import com.models.Spot;

import java.util.List;

public interface LotDao {
    Boolean add(Lot lot);                           // insert into database
    Boolean save(Lot lot, int id);                  // save with having Id
    Boolean save(Lot lot);                          // saving without having Id
    Boolean delete(int id);                         // delete lot / change status to 0
    Lot get(int id);                                // fetch one lot
    List<Lot> get(String queryString);              // fetch list of lots
    List<Spot> getSpots();
}
