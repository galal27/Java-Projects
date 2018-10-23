import java.io.IOException;
import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

public class DataAnalysis_12mmg3 {

	// Read file, parse it and create an array of data for analysis
	public static double[][] readCSV(String inputFile) {
		String line;
		Path file = Paths.get(inputFile);
		double[][] data = new double[1000][];
		int row = 0;
		try (BufferedReader reader = Files.newBufferedReader(file)) {
			while ((line = reader.readLine()) != null) {
				// parse to doubles for analysis
				data[row] = parseDoubles(line.split(","));
				row++;
			}
		} catch (IOException err) {
			System.err.println(err.getMessage());
		} catch (NumberFormatException err) {
			System.err.println(err.getMessage());
		}
		return data;
	}

	// Method to parse string values to doubles for analysis
	public static double[] parseDoubles(String[] array) {
		double[] parsed = new double[array.length];
		for (int i = 0; i < array.length; i++)
			parsed[i] = Double.parseDouble(array[i]);
		return parsed;
	}

	// Does analysis for each motor
	public static StringBuffer analysis(double[][] data, int motor) {
		// buffer variable appended throughout analysis to fill report
		StringBuffer buffer = new StringBuffer("\n");
		// variable to monitor if motor not used
		int notUsed = -1;

		for (int i = 0; i < data.length; i++) {
			// Motors do not draw more than one amp when they are not running.
			// If motor > 1 amps, list the average current and time of operation
			// for each current pulse. If motor > 8 amps, make special note.
			// Also indicates if motor not used.
			if (data[i][motor] > 1) {
				int startTime = i;
				int runTime = 0;
				notUsed = 0;
				double sum = 0;
				buffer.append("Pulse startTime (sec) = " + startTime);
				if (data[i][motor] > 8)
					buffer.append(", ***Current Exceeded*** \n");
				while (data[startTime][motor] > 1) {
					sum += data[startTime][motor];
					runTime++;
					startTime++;
				}
				buffer.append("; finishTime (sec) = " + startTime + "; avgCurrent (amps) = "
						+ (Math.floor(sum / runTime * 1000) / 1000) + "\n");
				i = startTime;
			} else if (i == 999 && notUsed == -1)
				buffer.append("Not used. \n");
		}
		return buffer;
	}

	// Create the report and header. If successfully created, indicate this in
	// console.
	// Then call fillReport method to fill the report.
	public static void createReport(String fileName, double[][] data, int i) {
		try {
			PrintWriter printWriter = new PrintWriter(fileName, "UTF-8");
			printWriter.println("Summary of Motor " + i + " Operations: \n");
			printWriter.close();
			System.out.println(fileName + " successfully created");
		} catch (IOException err) {
			System.err.println(err.getMessage());
		}
		fillReport(fileName, data, i);
	}

	// Analyse motor data and call writeReport for each motor
	public static void fillReport(String fileName, double[][] data, int i) {
		StringBuffer summary = analysis(data, i);
		writeReport(fileName, summary);
		System.out.println("Motor " + i + " report successfully filled");
	}

	// Write analysis content in the buffer to the motor report
	public static void writeReport(String fileName, StringBuffer summary) {
		BufferedWriter writer = null;
		// Typecast StringBuffer to String to work with BufferedWriter
		String s = new String(summary.toString());
		try {
			writer = new BufferedWriter(new FileWriter(fileName, true));
			writer.write(s);
		} catch (IOException err) {
			System.err.println(err.getMessage());
		} finally {
			if (writer != null)
				try {
					writer.close();
				} catch (IOException ioe2) {
					System.out.println(ioe2);
				}
		}
	}

	// Insert path for inputFile, read the data and createReport for each motor.
	public static void main(String[] args) {
		String inputFile = "src/Logger.csv";
		double[][] data = readCSV(inputFile);
		for (int i = 1; i < 8; i++) {
			String fileName = "motor" + i + ".csv";
			createReport(fileName, data, i);
		}

	}
}
