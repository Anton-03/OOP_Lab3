
package program_processing_java;

import java.util.Scanner;


class Control {
    public static int input(int firstBorder, int endBorder){
        int put = firstBorder;
        
        
        do {
            Scanner scanner = new Scanner (System.in, "CP1251");
            
            if (!scanner.hasNextInt())
                System.out.print("Неправильный ввод. Введите значение еще раз");
            else {
                put = scanner.nextInt();
                    
                    if (put<firstBorder || endBorder<put)
                        System.out.print("Неправильный ввод. Введите значение еще раз");
            }
        }
         while (put<firstBorder || endBorder < put);
        
        return put;
    }
    
}
