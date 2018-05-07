package com.services;

import com.dao.LotDao;
import com.models.Lot;
import com.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LotService {

    @Autowired
    private LotDao lotDao;

    public boolean add(Lot lot) {
        return this.lotDao.add(lot);
    }

    public boolean update(Lot lot, int id) {
        return this.lotDao.save(lot, id);
    }

    public Boolean delete(int id, Boolean flag) {
        return this.lotDao.delete(id);
    }

    public List<Lot> get(String queryString) {
        return this.lotDao.get(queryString);
    }

    public Number countLots(String queryString) {
        return lotDao.countLots("WHERE status = 1 " + queryString);
    }

    public Lot mostUsedLot(User user) {
        Lot lot = new Lot();
        lot.setName("Khunamun");
        return lot;
    }
}
