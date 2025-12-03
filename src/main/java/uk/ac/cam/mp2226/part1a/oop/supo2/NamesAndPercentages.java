package uk.ac.cam.mp2226.part1a.oop.supo2;

import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

record NameAndMark(String name, Double mark) implements Comparable<NameAndMark> {
    @Override
    public int compareTo(NameAndMark o) {
        // '-' so largest first
        return Comparator.comparing((NameAndMark x) -> -x.mark)
                .thenComparing(x -> x.name)
                .compare(this, o);
    }
}

public class NamesAndPercentages {
    // Absolutely overengineered code for just an OOP supervision
    private TreeMap<String, Double> marksByName;
    private TreeSet<NameAndMark> sortedNames;

    public NamesAndPercentages() {
        marksByName = new TreeMap<>();
        sortedNames = new TreeSet<>();
    }

    public void addMark(String name, double mark) {
        marksByName.put(name, mark);
        sortedNames.add(new NameAndMark(name, mark));
    }

    public List<String> sortedNames() {
        return marksByName.keySet().stream().toList();
    }
    public List<String> topPPercent(double p) {
        int n = (int)(marksByName.size() * p / 100);
        return sortedNames.stream()
                .limit(n)
                .map(NameAndMark::name)
                .toList();
    }
    public double medianMark() {
        // This could be a lot more efficient!
        int s = marksByName.size();
        if(s % 2 == 1) {
            int n = (s - 1) / 2;
            return sortedNames.stream()
                    .skip(n)
                    .findFirst()
                    .map(NameAndMark::mark)
                    .orElse(Double.NaN);
        }
        int n0 = (s - 2) / 2;  // floor((s - 1) / 2)
        // int n1 = s / 2;  // ceil((s - 1) / 2)
        // Average of 2 middle items at n0 and n1
        return sortedNames.stream()
                .skip(n0)
                .limit(2)
                .map(NameAndMark::mark)
                .collect(Collectors.averagingDouble(x -> x));
    }
}
