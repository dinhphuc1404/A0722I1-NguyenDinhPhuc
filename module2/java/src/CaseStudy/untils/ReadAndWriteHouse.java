package CaseStudy.untils;

import CaseStudy.models.Facility;
import CaseStudy.models.House;
import CaseStudy.models.Room;

import java.io.*;
import java.util.LinkedHashMap;

public class ReadAndWriteHouse {
    private static final String FILE_PATH="E:\\Codegym\\6 module\\module2\\java\\src\\CaseStudy\\data\\house.csv";
    public static LinkedHashMap<Facility, Integer> readCSV() throws IOException {
        LinkedHashMap<Facility, Integer> fac = new LinkedHashMap<>();
        FileReader fileReader = new FileReader(FILE_PATH);
        BufferedReader buff = new BufferedReader(fileReader);

        String line;
        String[] temp;
        House house;

        while ((line = buff.readLine()) != null){
            temp = line.split(",");
            String name = temp[0];
            double price = Double.parseDouble(temp[1]);
            int numberOfPeople = Integer.parseInt(temp[2]);
            String rentalTyle = temp[3];
            double usableArea = Double.parseDouble(temp[4]);
            String roomStandard = temp[5];
            int numberOfFloors = Integer.parseInt(temp[6]);
            house = new House(name,price,numberOfPeople,rentalTyle,usableArea,roomStandard,numberOfFloors);
            fac.put(house,0);
        }
        buff.close();
        return fac;
    }
    public static void writeCSV(LinkedHashMap<Facility,Integer> houseLinkdedHashMap) throws IOException {
        FileWriter fileWriter = new FileWriter(FILE_PATH);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for (Facility facility: houseLinkdedHashMap.keySet()){
            if(facility instanceof House){
                House house = new House();
                bufferedWriter.write(house.getName()+","+house.getPrice()+","+house.getNumberOfPeople()+","+house.getRentalType()+","+house.getUsableArea()+","+house.getRoomStandard()+","+house.getNumberOfFloors()+"\n");

            }
        }
        bufferedWriter.close();

    }
}
