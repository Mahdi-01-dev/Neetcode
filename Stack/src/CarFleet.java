import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CarFleet {
  public int carFleet(int target, int[] position, int[] speed) {
    Map<Integer, Double> times = new HashMap<>();
    for (int i = 0; i < position.length; i++) {
      double time = ((double) target - position[i]) / speed[i];
      times.put(position[i], time);
    }

    double headOfFleetTime = -1;
    int fleets = 0;
    Arrays.sort(position);
    for (int i = position.length - 1; i > -1; i--) {
      double time = times.get(position[i]);
      if (time > headOfFleetTime) {
        fleets++;
        headOfFleetTime = time;
      }
    }
    return fleets;
  }
}
