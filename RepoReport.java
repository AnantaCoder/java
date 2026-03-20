import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.regex.*;

public class RepoReport {

    public static void main(String[] args) throws IOException {

        String path = "D:\\Java\\dsa_java\\";
        Map<Integer, String> problems = new TreeMap<>();
        Pattern pattern = Pattern.compile("leetcode-(\\d+)(.*)");
        Files.walk(Paths.get(path))
                .filter(Files::isRegularFile)
                .filter(p -> p.toString().endsWith(".java"))
                .forEach(p -> {
                    try {
                        List<String> lines = Files.readAllLines(p);
                        for (String line : lines) {
                            Matcher matcher = pattern.matcher(line);
                            while (matcher.find()) {
                                int number = Integer.parseInt(matcher.group(1));
                                String extra = matcher.group(2).trim();
                                extra = extra.replaceAll("^[^a-zA-Z0-9]+", "");
                                extra = extra.replaceAll("[^a-zA-Z0-9 ]+$", "");
                                problems.putIfAbsent(number, extra);
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });

        List<String> output = new ArrayList<>();
        for (Map.Entry<Integer, String> entry : problems.entrySet()) {
            if (entry.getValue().isEmpty()) {
                output.add(String.valueOf(entry.getKey()));
            } else {
                output.add(entry.getKey() + " - " + entry.getValue());
            }
        }
        Path outputPath = Paths.get("repo_report.txt");

        List<String> finalOutput = new ArrayList<>();
        finalOutput.add("Leetcode Report: -----------");
        finalOutput.add(""); 
        finalOutput.addAll(output);
        Files.write(outputPath, finalOutput);
        System.out.println("Report saved successfully!");
    }
}
