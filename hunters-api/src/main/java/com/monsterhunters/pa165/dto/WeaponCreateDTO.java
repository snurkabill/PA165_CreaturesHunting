package com.monsterhunters.pa165.dto;


import com.monsterhunters.pa165.enums.MonsterType;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by babcang on 17.11.2016.
 *
 * @author Babcan G
 */
public class WeaponCreateDTO {

    @NotNull
    @Size(min = 2, max = 60)
    private String name;

    @Min(0)
    private int gunReach;

    @Min(0)
    private int ammo;

    @Min(0)
    @Max(100)
    private int damage;

    private Set<MonsterType> effectiveAgainst = new HashSet<>();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGunReach() {
        return gunReach;
    }

    public void setGunReach(int gunReach) {
        this.gunReach = gunReach;
    }

    public int getAmmo() {
        return ammo;
    }

    public void setAmmo(int ammo) {
        this.ammo = ammo;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public Set<MonsterType> getEffectiveAgainst() {
        return effectiveAgainst;
    }

    public void setEffectiveAgainst(Set<MonsterType> effectiveAgainst) {
        this.effectiveAgainst = effectiveAgainst;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        WeaponCreateDTO other = (WeaponCreateDTO) obj;
        if (name == null) {
            if (other.getName() != null)
                return false;
        } else if (!name.equals(other.getName()))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "WeaponCreateDTO{" +
                ", name='" + name + '\'' +
                ", gunReach=" + gunReach +
                ", ammo=" + ammo +
                ", damage=" + damage +
                ", effectiveAgainst=" + effectiveAgainst +
                '}';
    }
}
