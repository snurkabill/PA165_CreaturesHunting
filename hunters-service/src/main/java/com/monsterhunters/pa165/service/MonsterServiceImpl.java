package com.monsterhunters.pa165.service;

import com.monsterhunters.pa165.dao.MonsterDao;
import com.monsterhunters.pa165.entity.Location;
import com.monsterhunters.pa165.entity.Monster;
import com.monsterhunters.pa165.enums.MonsterType;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Miroslava Voglova
 */
@Service
public class MonsterServiceImpl implements MonsterService {

    @Autowired
    private MonsterDao monsterDao;

    @Override
    public Monster createMonster(Monster m) {
        monsterDao.create(m);
        return m;
    }

    @Override
    public void deleteMonster(Monster m) {
        monsterDao.delete(m);
    }

    @Override
    public Monster updateMonster(Monster m) {
        monsterDao.update(m);
        return m;
    }

    @Override
    public Monster findById(Long id) {
        return monsterDao.findById(id);
    }

    @Override
    public List<Monster> findAll() {
        return monsterDao.findAll();
    }

    @Override
    public void addType(MonsterType type, Monster m) {
        m.addType(type);
        monsterDao.update(m);
    }

    @Override
    public void removeType(MonsterType type, Monster m) {
        m.removeType(type);
        monsterDao.update(m);
    }

    @Override
    public void relocateMonster(Location newLocation, Monster m) {
        if (m.getLocation().equals(newLocation)) {
            return;
        }
        m.setLocation(newLocation);
        monsterDao.update(m);
    }

    @Override
    public List<Location> getLocationsWithMostMonsterType(MonsterType type) {
        List<Monster> monsters = monsterDao.findByType(type);
        Map<Location, Integer> locations = new HashMap<>();

        for (Monster m : monsters) {
            Integer valueInMap = locations.get(m.getLocation());
            locations.put(m.getLocation(), valueInMap == null ? 0 : valueInMap + 1);
        }
        
        List<Location> mostLocation = new LinkedList<>();
        if (locations.isEmpty()){
            return mostLocation;
        }
        
        int highestCount = Collections.max(locations.values());


        for (Location loc : locations.keySet()) {
            if (locations.get(loc).equals(highestCount)) {
                mostLocation.add(loc);
            }
        }

        return mostLocation;
    }
}
