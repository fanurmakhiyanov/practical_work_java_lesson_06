// Структура класса Ноутбук для магазина техники

package fanur;

import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        Logger logger = Logger.getAnonymousLogger();
        Laptop modelsLine = new Laptop();
        modelsLine.addModelLaptop(900,32,500,16);
        modelsLine.addModelLaptop(300,4,400,14);
        modelsLine.addModelLaptop(1000,16,500,15);
        modelsLine.addModelLaptop(1100,8,256,13);
        modelsLine.addModelLaptop(1100,8,256,13);
        modelsLine.addModelLaptop(1100,8,256,13);
        modelsLine.addModelLaptop(1100,16,256,13);
        logger.info(modelsLine.searchModels());
    }
}