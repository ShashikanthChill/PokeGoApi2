/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thehumblefool.pokégoapi2.models.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author The_Humble_Fool
 */
@Entity
@Table(name = "type_effectiveness_list")
public class TypeEffectivenessEntityModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "type")
    private String type;

    @Column(name = "Normal")
    private double normal;

    @Column(name = "Fire")
    private double fire;

    @Column(name = "Water")
    private double water;

    @Column(name = "Electric")
    private double electric;

    @Column(name = "Grass")
    private double grass;

    @Column(name = "Ice")
    private double ice;

    @Column(name = "Fighting")
    private double fighting;

    @Column(name = "Poison")
    private double poison;

    @Column(name = "Ground")
    private double ground;

    @Column(name = "Flying")
    private double flying;

    @Column(name = "Psychic")
    private double psychic;

    @Column(name = "Bug")
    private double bug;

    @Column(name = "Rock")
    private double rock;

    @Column(name = "Ghost")
    private double ghost;

    @Column(name = "Dragon")
    private double dragon;

    @Column(name = "Dark")
    private double dark;

    @Column(name = "Steel")
    private double steel;

    @Column(name = "Fairy")
    private double fairy;

    public TypeEffectivenessEntityModel() {
    }

    public TypeEffectivenessEntityModel(Integer id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getNormal() {
        return normal;
    }

    public void setNormal(double normal) {
        this.normal = normal;
    }

    public double getFire() {
        return fire;
    }

    public void setFire(double fire) {
        this.fire = fire;
    }

    public double getWater() {
        return water;
    }

    public void setWater(double water) {
        this.water = water;
    }

    public double getElectric() {
        return electric;
    }

    public void setElectric(double electric) {
        this.electric = electric;
    }

    public double getGrass() {
        return grass;
    }

    public void setGrass(double grass) {
        this.grass = grass;
    }

    public double getIce() {
        return ice;
    }

    public void setIce(double ice) {
        this.ice = ice;
    }

    public double getFighting() {
        return fighting;
    }

    public void setFighting(double fighting) {
        this.fighting = fighting;
    }

    public double getPoison() {
        return poison;
    }

    public void setPoison(double poison) {
        this.poison = poison;
    }

    public double getGround() {
        return ground;
    }

    public void setGround(double ground) {
        this.ground = ground;
    }

    public double getFlying() {
        return flying;
    }

    public void setFlying(double flying) {
        this.flying = flying;
    }

    public double getPsychic() {
        return psychic;
    }

    public void setPsychic(double psychic) {
        this.psychic = psychic;
    }

    public double getBug() {
        return bug;
    }

    public void setBug(double bug) {
        this.bug = bug;
    }

    public double getRock() {
        return rock;
    }

    public void setRock(double rock) {
        this.rock = rock;
    }

    public double getGhost() {
        return ghost;
    }

    public void setGhost(double ghost) {
        this.ghost = ghost;
    }

    public double getDragon() {
        return dragon;
    }

    public void setDragon(double dragon) {
        this.dragon = dragon;
    }

    public double getDark() {
        return dark;
    }

    public void setDark(double dark) {
        this.dark = dark;
    }

    public double getSteel() {
        return steel;
    }

    public void setSteel(double steel) {
        this.steel = steel;
    }

    public double getFairy() {
        return fairy;
    }

    public void setFairy(double fairy) {
        this.fairy = fairy;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.type);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TypeEffectivenessEntityModel other = (TypeEffectivenessEntityModel) obj;
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TypeEffectivenessEntityModel: {" + "id=" + id + ", type=" + type + ", normal=" + normal + ", fire=" + fire + ", water=" + water + ", electric=" + electric + ", grass=" + grass + ", ice=" + ice + ", fighting=" + fighting + ", poison=" + poison + ", ground=" + ground + ", flying=" + flying + ", psychic=" + psychic + ", bug=" + bug + ", rock=" + rock + ", ghost=" + ghost + ", dragon=" + dragon + ", dark=" + dark + ", steel=" + steel + ", fairy=" + fairy + '}';
    }

}
