package multiFeatureTasks.tasksOrders;

public class OrdersApp {
    static void main() {

        OrdersManager om = new OrdersManager();
        om.addOrder(new Order("Karolina Wolnik", 56.21));
        om.addOrder(new Order("Marta Wajzer", 124.36));
        om.addOrder(new Order("Agata bednarz", 87.26));
        om.addOrder(new Order("Kasia Nowakowska", 224.36));
        om.addOrder(new Order("Kamil Bednarek", 4.36));
        om.addOrder(new Order("Andrzej Kisiel", 98.27));

        System.out.println("--- Wszystkie zamówienia:");
        om.showAllOrders();
        System.out.println("---Zamówienia powyżej 100zł");
        om.showBig();
        om.takeOrder(1);
        om.ready(1);
        om.takeOrder(2);
        om.takeOrder(3);
        om.takeOrder(4);
        om.totalActiveValue();
        om.countActive();
        om.showActive();
        om.showReadyOrders();



    }
}
