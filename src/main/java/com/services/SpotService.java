package com.services;

import com.dao.SpotDao;
import com.models.Spot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SpotService {

    @Autowired
    private final SpotDao spotDao;

    public SpotService(SpotDao spotDao) {
        this.spotDao = spotDao;
    }

    public boolean add(Spot spot) {
        return this.spotDao.add(spot);
    }

    public boolean save(Spot spot, int id) {
        return this.spotDao.save(spot, id);
    }

    public Boolean delete(int id) {
        return this.spotDao.delete(id);
    }

    public List<Spot> get(String queryString) {
        return this.spotDao.get(queryString);
    }

    public Spot get(int id) {
        return this.spotDao.get(id);
    }
}
