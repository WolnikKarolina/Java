package multiFeatureTasks.garden;

public class Garden {
    static void main() {


        PlantApp p = new PlantApp();

        p.addPlant("Róża", 50, true);
        p.addPlant("Tulipan", 30, false);
        p.addPlant("Fiołek", 15, true);
        p.addPlant("Stokrotka", 20, false);
        p.addPlant("Słonecznik", 200, true);
        p.addPlant("Lawenda", 40, true);
        p.addPlant("Fikus", 180, false);
        p.addPlant("Aloes", 25, false);
        p.addPlant("Lilia", 60, true);
        p.addPlant("Orchidea", 35, true);

        p.showAllPlants();
        p.showBloomPlant();
        p.countBloomPlants();
        p.highestPlant();


    }
}
