
package program_processing_java;
import java.util.Scanner;
import java.util.Arrays;

class menu {
    private static  Scanner scanner = new Scanner(System.in,"CP1251");
    private static Matrix matrix;
    private static Addition matrixA;
    private static StringNew s1;
    private static int [][] matrixB;
    
    public static void start(){
        System.out.println("Приветствую вас в своей программе");
        int pick;
        
        do{
            System.out.println("Выберите одно из указанных деййствий:");
            System.out.println("1 - Сложить главную и второстепенную диагональ матрицы");
            System.out.println("2 - Проверка строки на число");
            System.out.println("3 - Сложение двух матриц");
            System.out.println("4 - Закончить выполнение программы");
            
            
            pick = Control.input(1,4);
            
                    switch (pick) {
                        case 1: 
                            openMatrix();
                            doMatrix();
                            break; 
                        case 2:
                            openString();
                            doString();
                            break; 
                        case 3:
                            openTwoMatrix();
                            doTwoMatrix();

                        break; 
                    }
                   
                
        } 
                while (pick != 4);
                             System.out.println("Завершение работы");
        
    }

    
    
    private static void openMatrix() {
         System.out.println("Выберете ввод матрицы");
         System.out.println("1 - Ввод через консоль");
         System.out.println("2 - Ввод через текстовый документ");
         
         
         switch (Control.input(1,2)){
             case 1:
                 System.out.println("Введите размерность матрицы");
                 int size = scanner.nextInt();
                 matrix = new Matrix (size);
                 
                 System.out.println("Введите элементы матрицы");
                 for (int i = 0; i<size;i++) 
                    for (int j = 0; j<size;j++)
                        {
                        int value = scanner.nextInt();
                        matrix.setElement(i,j,value);
                        }
                        
                        
                        
                            System.out.println("\nСохранить данные в файл?\n 1 - Да, 2 - Нет");
                            System.out.print("Выбор действия >> ");
                            
                            if (Control.input(1,2) == 1) {
                                System.out.print("Введите название файла: ");
                                scanner = new Scanner(System.in, "CP1251");                         
                            WriteReadFile.saveInt(matrix.getMatrix(), "save\\" +  scanner.nextLine());

                                 if (WriteReadFile.hasSaving()) System.out.println("Файл успешно сохранен!");
                                else System.out.println("Ошибка сохранения!");
                            }

                            
                            
                     
                 break;
             case 2:
                 System.out.println("Введите название файла");
                 scanner = new Scanner(System.in, "CP1251");
                 int [] openFile = WriteReadFile.loadInt("save\\" + scanner.nextLine());
                 
                 matrix = new Matrix((int) Math.sqrt(openFile.length));
                 for (int i = 0; i < openFile.length; i++) {
                     matrix.setElement(i/matrix.size(), i%matrix.size(), openFile[i]);
                 }
             break;
         }
         
         
         
         
         
    }

    
    
    private static void doMatrix() {
                System.out.println("Матрица: ");
                    for (int i = 0; i < matrix.size(); i++) {
                        for (int j=0;j<matrix.size();j++) {
                            System.out.print(matrix.getElement(i, j) + " ");
                        }
                        System.out.println();   
                    }  
                System.out.println("sum1 = " + matrix.sum1()); 
                System.out.println("sum2 = " + matrix.sum2()); 
    }
    

    
    
    
    
    private static void openString() {
         System.out.println("Выберете ввод строки");
         System.out.println("1 - Ввод через консоль");
         System.out.println("2 - Ввод через текстовый документ");
         
         
         switch (Control.input(1,2)){
             case 1:
                 System.out.println("Введите строку");
                 scanner = new Scanner(System.in, "CP1251"); 
                 s1 = new StringNew(scanner.nextLine());
                 System.out.println("Данная строка: " + s1.getString());
                 
                 System.out.println("\nСохранить данные в файл?\n 1 - Да, 2 - Нет");
                            System.out.print("Выбор действия >> ");
                            
                            if (Control.input(1,2) == 1) {
                                System.out.print("Введите название файла: ");
                                scanner = new Scanner(System.in, "CP1251");                         
                                WriteReadFile.saveString(s1.getString(), "save\\" +  scanner.nextLine());

                                if (WriteReadFile.hasSaving()) System.out.println("Файл успешно сохранен!");
                                else System.out.println("Ошибка сохранения!");
                            }
                 
             break;
             
             case 2:
                 
                 System.out.println("Введите название файла");
                 scanner = new Scanner(System.in, "CP1251");
                 String openFile = WriteReadFile.loadString("save\\" + scanner.nextLine());
                 s1 = new StringNew(openFile);
                 
             break;
        }

    }     
         
         
         
         
    private static void doString() {
        boolean number = s1.isDigitalSrting();
        System.out.println("Данная строка:" + s1.getString());
        System.out.println(number? "Строка является числом": "Строка не является числом");
    }

    
    
    
    
    
    private static void openTwoMatrix() {
         System.out.println("Выберете ввод матрицы");
         System.out.println("1 - Ввод через консоль");
         System.out.println("2 - Ввод через текстовый документ");
         
         
         
         switch (Control.input(1,2)){
             case 1:
                 System.out.println("Введите размерность матриц");
                 int size = scanner.nextInt();
                 matrixA = new Addition(size);
                 
                 System.out.println("Введите Значения матрице А");
                 for (int i = 0; i<size;i++) 
                    for (int j = 0; j<size;j++)
                        {
                        int value = scanner.nextInt();
                        matrixA.setElement(i,j,value);
                        }
                 
                 System.out.println("Введите Значения матрице B");
                 scanner = new Scanner(System.in, "CP1251");   
                 matrixB = new int[size][size];
                 for (int i = 0; i<size;i++) 
                    for (int j = 0; j<size;j++)
                        {
                        int value = scanner.nextInt();
                        matrixB[i][j]= value;
                        }
                 
                 
                 
                 System.out.println("Матрица А:");
                    System.out.println(Arrays.deepToString(matrixA.getSquareMatrix()));
                 System.out.println("Матрица B:");
                    System.out.println(Arrays.deepToString(matrixB));   
                    
                    
                    
                    System.out.println("\nСохранить данные в файл?\n 1 - Да, 2 - Нет");
                            System.out.print("Выбор действия >> ");
                            
                            if (Control.input(1,2) == 1) {
                                System.out.print("Введите название файла для сохранения матрицы А: ");
                                scanner = new Scanner(System.in, "CP1251");                         
                                WriteReadFile.saveInt(matrixA.getMatrix(), "save\\" +  scanner.nextLine());

                                if (WriteReadFile.hasSaving()) System.out.println("Файл успешно сохранен!");
                                else System.out.println("Ошибка сохранения!");
                                              
                             
                            
                                System.out.print("Введите название файла для сохранения матрицы В: ");
                                scanner = new Scanner(System.in, "CP1251");                         
                                WriteReadFile.saveInt(new Addition(matrixB).getMatrix(), "save\\" +  scanner.nextLine());

                                if (WriteReadFile.hasSaving()) System.out.println("Файл успешно сохранен!");
                                else System.out.println("Ошибка сохранения!");
                            }
                     
              break;
              
              case 2:
                  
                    System.out.println("Введите название файла c матрицей А");
                    scanner = new Scanner(System.in, "CP1251");
                    int [] openFile = WriteReadFile.loadInt("save\\" + scanner.nextLine());
                 
                    matrixA = new Addition((int) Math.sqrt(openFile.length));
                    for (int i = 0; i < openFile.length; i++) {
                        matrixA.setElement(i/matrixA.size(), i%matrixA.size(), openFile[i]);
                 }
                 
                 
                    System.out.println("Вывод матрицы A:");
                    System.out.println(Arrays.deepToString(matrixA.getSquareMatrix()));
                 
                    
                    
                    
                    System.out.println("Введите название файла с Матрицей В ");
                    scanner = new Scanner(System.in, "CP1251");
                    int [] openFile2 = WriteReadFile.loadInt("save\\" + scanner.nextLine());
                    
                    size = (int) Math.sqrt(openFile2.length); 
                        matrixB = new int [size][size];
                   
                    for (int i = 0; i < openFile2.length; i++) {
                      matrixB[i/matrixB.length][i%matrixB.length] = openFile2[i];
                     
                 }
                
                 System.out.println("Вывод матрицы B:");
                    System.out.println(Arrays.deepToString(matrixB));   
         }         
    }

    
    private static void doTwoMatrix() {

        int [][] matrixC = matrixA.sumTwoMatrix(matrixB);
        System.out.println("Матрица C:");
            for (int i=0; i<matrixC.length;i++)
            {
                for (int j=0;j<matrixC.length;j++)
                {
                   System.out.print(matrixC[i][j] + " ");
                }
               System.out.println();   
            }
            
            System.out.print("\nСохранить сумму в файл?\n 1 - Да, 2 - Нет \n");
            
            if (Control.input(1,2) == 1) {
            System.out.print("Введите название файла куда сохранить сумму: ");
                WriteReadFile.saveInt(new Addition(matrixC).getMatrix(), "save\\" + scanner.nextLine());
                if (WriteReadFile.hasSaving()) System.out.println("Файл успешно сохранен!");
                else System.out.println("Ошибка сохранения!");     
            }    
    }  
}
