import java.io.*;

public class SchoolReport {

    public static void main(String[] args) {

        // Reading student data from file
        try {
            BufferedReader br = new BufferedReader(new FileReader("students.txt"));

            BufferedWriter bw = new BufferedWriter(
                    new FileWriter("reportcard.txt", true)); // append mode

            String line;

            while ((line = br.readLine()) != null) {

                // Format in file:
                // Rahul,80,90,70

                String[] data = line.split(",");

                String name = data[0];

                int m1 = Integer.parseInt(data[1]);
                int m2 = Integer.parseInt(data[2]);
                int m3 = Integer.parseInt(data[3]);

                double avg = (m1 + m2 + m3) / 3.0;

                bw.write("Student Name : " + name);
                bw.newLine();
                bw.write("Average Marks : " + avg);
                bw.newLine();
                bw.write("------------------------");
                bw.newLine();
            }

            br.close();
            bw.close();

            System.out.println("Report card generated successfully.");

        } catch (FileNotFoundException e) {

            System.out.println("Student file not found.");

        } catch (IOException e) {

            System.out.println("Error while reading/writing file.");
        }
    }
}