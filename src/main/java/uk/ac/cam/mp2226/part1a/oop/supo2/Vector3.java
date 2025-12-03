package uk.ac.cam.mp2226.part1a.oop.supo2;

// record = same as class but less boilerplate code
// (e.g. no need to provide setter & constructor)
public record Vector3(double x, double y, double z) implements Comparable<Vector3> {
    @Override
    public int compareTo(Vector3 o) {
        return Double.compare(
                z - o.z != 0 ? z - o.z
                : y - o.y != 0 ? y - o.y
                : x - o.x,
                0.0);
    }
}
