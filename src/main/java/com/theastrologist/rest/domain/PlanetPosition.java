package com.theastrologist.rest.domain;

import util.CalcUtil;

public class PlanetPosition {
    private final SignDecan decanInSign;
    private final HouseDecan decanInHouse;
    private Degree degree;
    private Sign sign;
    private House house;
    private Degree degreeInSign;
    private Degree degreeInHouse;
    private boolean retrograde = false;

    public PlanetPosition(Degree degree, Sign sign, House house, Degree degreeInSign, Degree degreeInHouse) {
        this.degree = degree;
        this.sign = sign;
        this.house = house;
        this.degreeInSign = degreeInSign;
        this.decanInSign = SignDecan.getDecan(degreeInSign, sign);
        this.degreeInHouse = degreeInHouse;
        this.decanInHouse = HouseDecan.getDecan(degreeInHouse, house);
    }

    public static PlanetPosition createPlanetPosition(Degree degree, Degree asDegree) {
        return new PlanetPosition(
                degree,
                CalcUtil.getSign(degree),
                CalcUtil.getHouse(degree, asDegree),
                CalcUtil.getDegreeInSign(degree),
                CalcUtil.getDegreeInHouse(degree, asDegree)
        );
    }

    public SignDecan getDecanInSign() {
        return decanInSign;
    }

    public HouseDecan getDecanInHouse() {
        return decanInHouse;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public Sign getSign() {
        return sign;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public Degree getDegreeInSign() {
        return degreeInSign;
    }

    public Degree getDegreeInHouse() {
        return degreeInHouse;
    }

    public void setRetrograde(boolean retrograde) {
        this.retrograde = retrograde;
    }

    public boolean isRetrograde() {
        return retrograde;
    }
}
