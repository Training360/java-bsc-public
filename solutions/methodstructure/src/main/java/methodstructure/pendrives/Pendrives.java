package methodstructure.pendrives;

import java.util.List;

public class Pendrives {

    public Pendrive getBest(List<Pendrive> pendrives) {
        Pendrive min = pendrives.get(0);
        for (Pendrive p : pendrives) {
            if (min.comparePricePerCapacity(p) == 1) {
                min = p;
            }
        }
        return min;
    }

    public Pendrive getCheapest(List<Pendrive> pendrives) {
        Pendrive min = pendrives.get(0);
        for (Pendrive p : pendrives) {
            if (p.isCheaperThan(min)) {
                min = p;
            }
        }
        return min;
    }

    public void risePriceWhereCapacity(List<Pendrive> pendrives, int percent, int capacity) {
        for (Pendrive p : pendrives) {
            if (p.getCapacity() == capacity) {
                p.risePrice(percent);
            }
        }
    }
}
