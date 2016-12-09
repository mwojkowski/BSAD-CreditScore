import java.util.*;
import java.io.*;
import java.io.FileReader.*;

public class Main {

    public static void main(String[] args) {
        ArrayList<Record> records = new ArrayList<Record>();

        ArrayList<Double> highAccuracies = new ArrayList<Double>();

        int female = 0; int student = 0;
        try{
            FileInputStream fstream = new FileInputStream("test.csv");
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            br.readLine();
            while ((strLine = br.readLine()) != null)   {
                // Print the content on the console
                String[] info = strLine.split(",");
                if(info[5].equals("Female")){
                    female = 1;
                }
                else{
                    female = 0;
                }
                if(info[6].equals("Yes")){
                    student = 1;
                }
                else{
                    student = 0;
                }
                records.add(new Record(info[0], info[9], info[2], info[4], info[3],
                        female, student, info[1]));


            }
            //Close the input stream
            in.close();


        }
        catch(Exception e){
            e.printStackTrace();
        }

        int faults = 0;
        for(int z=0; z< records.size(); z++)
        {

            double accuracy = Math.round(records.get(z).calculateAccuracy());
            System.out.println("Accuracy: " + accuracy + "%");

            if(accuracy > 10){
                highAccuracies.add(accuracy);
                faults ++;
            }

        }

        System.out.println("\n\n\n");
        System.out.println(highAccuracies.toString());
        System.out.println(faults + " faults out of " + records.size() + " records.");



        //Record record = new Record(21, 580, 1, 17, 50, 0, 0, 355);
        //double accuracy = record.calculateAccuracy();
        //System.out.println("Accuracy rating: " + Math.round(accuracy) + "%");

    }
}
