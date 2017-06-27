package com.jumawax.helper;

public class Distance {
	static final double toMiles = 1.1515;
	static final double toMeters = 1609.34;
	public static double distance(double storeLat,double storeLon,double agentLat,double agentLon) {
		double theta = storeLon - agentLon;
		double dist = Math.sin(degToRad(storeLat)) * Math.sin(degToRad(agentLat)) + Math.cos(degToRad(storeLat) * Math.cos(degToRad(theta)));
		dist = Math.acos(dist);
		dist = radToDeg(dist);
		// convert to meters
		dist = dist * 60 * toMiles * toMeters;
		return dist;
	}
	
	private static double degToRad(double deg) {
		return (deg * Math.PI / 180.0);
	}
	
	private static double radToDeg(double rad) {
		return (rad * 180.0 /Math.PI);
	}
	
}
