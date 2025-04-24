package frozen.ingredientManagement;

import java.time.LocalDate;

public class Application {
    public static void main(String[] args) {
        managemenntService managemenntService = new managemenntService();
        Management mena = new Management(LocalDate.now(),1,3,"양배추");
        managemenntService.updateDelete(mena);
    }
}
