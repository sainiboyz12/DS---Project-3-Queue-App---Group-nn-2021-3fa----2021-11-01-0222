package edu.wit.scds.comp2000.queue.app;
import java.security.cert.CertPathParameters;
import java.util.ArrayList;

public class Statistics {

	@SuppressWarnings("rawtypes")
	private ArrayList[][][][] trainsStats;
	private int[][][] stationStats;
	private int numOfTrains;

   
	public void CTSStats(CertPathParameters ctsP) {
		trainsStats = new ArrayList[numOfTrains][4][2][2];
		stationStats = new int[4][2][3];
	}


   
	@SuppressWarnings({ "unchecked", "rawtypes", "removal" })
	public void setStartup() {
		trainsStats = new ArrayList[numOfTrains][4][2][2];
		for(int i=0; i<numOfTrains; i++) {
			for (int x=0; x<4; x++) {
				for (int y=0; y<2; y++) {
					for (int z=0; z<2; z++) {
						trainsStats[i][x][y][z] = new ArrayList();
						trainsStats[i][x][y][z].add(new Integer(0));
					}
				}
			}
		}
	}


    
	@SuppressWarnings({ "unchecked", "removal" })
	synchronized public void setStats(int stsType, int stationNo, int plat, int type, int statsNum, int trainNo) {
		switch (stsType) {
			case 0: trainsStats[trainNo][stationNo][plat][type].add(new Integer(statsNum)); break;
			case 1: stationStats[stationNo][plat][type] += statsNum; break;
		}
	}


   
	synchronized public String getStats(int stationNo, int plat, char type) {
		String s="";
		switch(type) {
			case 'p': s=Integer.toString(stationStats[stationNo][plat][0]); break;
			case 't': s=Integer.toString(stationStats[stationNo][0][0]+stationStats[stationNo][1][0]); break;
			case 'e': s=Integer.toString(stationStats[stationNo][0][2]+stationStats[stationNo][1][2]); break;
		}
		return s;
	}

    
	synchronized public String getPanelStats(int trainNo, int stationNo, int plat, int type) {
		Integer anInt = (Integer) trainsStats[trainNo][stationNo][plat][type].get(trainsStats[trainNo][stationNo][plat][type].size()-1);
		return anInt.toString();
	}
} 
