// Структура класса Ноутбук для магазина техники

package fanur;

import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        Logger logger = Logger.getAnonymousLogger();
        Laptop modelsLine = new Laptop();
        modelsLine.addModelLaptop(800,4,256,13);
        modelsLine.addModelLaptop(950,6,256,14);
        modelsLine.addModelLaptop(1100,8,500,15);
        modelsLine.addModelLaptop(1350,16,500,15);
        modelsLine.addModelLaptop(1380,16,500,16);
        modelsLine.addModelLaptop(1490,16,750,16);
        modelsLine.addModelLaptop(1600,32,750,17);
        logger.info(modelsLine.searchModels());
    }
}