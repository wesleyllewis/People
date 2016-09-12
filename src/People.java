import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Reads a csv file and maps country name to a list of people who are from that country.
 * Then, for each list sorts by last name.
 */
public class People {

    static List<Person> personList = new ArrayList<>();
    static HashMap<String, List<Person>> personMap = new HashMap<>();

    public static void main(String[] args) throws Exception {
        readFile();
        writeFile("people.json", personMap);
    }

    static void readFile() throws Exception {
        File f = new File("people.csv");
        Scanner fileScanner = new Scanner(f);
        while (fileScanner.hasNext()) {
            String line = fileScanner.nextLine();
            String[] columns = line.split(",");
            Person person = new Person(columns[4], columns[2], columns[1], columns[0], columns[3], columns[5]);
            String personMapKey = person.getCountry();

            if (personMap.containsKey(personMapKey)) {
                personList = personMap.get(personMapKey);
                personList.add(person);
                Collections.sort(personList);
            } else {
                personList = new ArrayList<>();
                personList.add(person);
                personMap.put(personMapKey, personList);
                Collections.sort(personList);
            }
        }
        fileScanner.close();
        System.out.println(personMap);
    }

    static void writeFile(String fileName, Map fileContent) throws IOException {
        File f = new File(fileName);
        FileWriter fw = new FileWriter(f);
        JsonSerializer serializer = new JsonSerializer();
        String json = serializer.include("*").serialize(fileContent);
        fw.write(json);
        fw.close();
    }

}
