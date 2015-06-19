package com.theastrologist.rest.domain;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AspectCalculator {

    public static final AspectCalculator INSTANCE = new AspectCalculator();

    /**
     * Calcul des aspects sur une carte du ciel
     * @param skyPosition la carte du ciel de r�f�rence
     * @return une map contenant par plan�te une map avec correspondance entre l'aspect et la plan�te compar�e
     */
    public Map<Planet, Map<Planet, AspectPosition>> createAspectsForSkyPosition(SkyPosition skyPosition) {

        Map<Planet, Map<Planet, AspectPosition>> aspectMapForPlanet = new HashMap<Planet, Map<Planet, AspectPosition>>();

        for (Planet planet : Planet.values()) {
            PlanetPosition planetPosition = skyPosition.getPlanetPosition(planet);
            Map<Planet, AspectPosition> aspectMap;
            if (!aspectMapForPlanet.containsKey(planet)) {
                aspectMap = new HashMap<Planet, AspectPosition>();
                aspectMapForPlanet.put(planet, aspectMap);
            } else {
                aspectMap = aspectMapForPlanet.get(planet);
            }

            for (Planet planetComparison : Planet.values()) {
                if (planet != planetComparison) {
                    PlanetPosition planetComparisonPosition = skyPosition.getPlanetPosition(planetComparison);
                    AspectPosition aspectPosition = AspectPosition.createAspectPosition(planet, planetComparison, planetPosition, planetComparisonPosition);
                    if(aspectPosition != null) {
                        aspectMap.put(planetComparison, aspectPosition);
                    }
                }
            }
        }

        return aspectMapForPlanet;
    }

    /**
     * Calcul des aspects pour une synastrie
     * @param skyPosition la carte du ciel servant de r�f�rence
     * @param skyPositionComparison la carte du ciel � comparer
     * @return une map contenant par plan�te une map avec correspondance entre l'aspect et la plan�te compar�e
     */
    public Map<Planet, Map<Planet, AspectPosition>> createAspectsForComparison(SkyPosition skyPosition, SkyPosition skyPositionComparison) {

        return null;
    }


    /**
     * Calcul des aspects pour un transit (orbes diff�rentes)
     * @param skyPosition la carte du ciel servant de r�f�rence
     * @param transitPosition la carte du ciel � comparer
     * @return une map contenant par plan�te une map avec correspondance entre l'aspect et la plan�te compar�e
     */
    public Map<Planet, Map<Planet, AspectPosition>> createAspectsForTransit(SkyPosition skyPosition, SkyPosition transitPosition) {

        return null;
    }
}
