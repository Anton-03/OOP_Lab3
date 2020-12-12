
package program_processing_java;


public class Matrix {
    //Поля(Переменные класса)
    // Создал внутреннюю переменную(Чтобы ее можно было видеть внутри класса)
    private final int [][] matrix;
    
    //получаем элемент матрицы по указанным индексам
    public int getElement(int i, int j) {
       return matrix[i][j];
    }
    //Добавляем новый элемент value в матрицу по указанным индексам i и j
    public void setElement(int i, int j, int value) {
        
        if (i < matrix.length && j < matrix.length)
            matrix[i][j] = value;
    }
    
    
    
    
    
    //Конструктор по умолчанию, который создает новый обхект 
    public Matrix(){
        this(2);// this - вызывает конструктор с параметрами 
    }
    
    //Возврат длины
    public int size() {
        return matrix.length;
    }
    
    
    
    //Конструктор с параметрами
    public Matrix(int size){
        matrix = new int[size][size];
         //this указывает на принадлежность данному классу,является его полем
                           // Внутренней переменной присвоил значение входного параметра
    } 
   
    


//Конструктор копирования - создает копию существующего объекта 
    //Присваиваю новому объекту значения из старого
    public Matrix(Matrix kopirovan){
        int size = kopirovan.matrix.length;
        matrix =  new int[size][size];
    //Передает значения в матрицу нового объекта    
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j]= kopirovan.matrix[i][j];
            }
            
        }
    }
    
    
    
    
    
    
//Метод нахождения суммы диагоналей
    public int sum1()
    {
        int sum1 = 0;
        for(int i = 0; i<matrix.length; i++)
            for(int j = 0; j<matrix.length; j++)
                if (i==j)
                    sum1+=matrix[i][j]; 
        return sum1; 
    }
    
    public int sum2(){
        int sum2 = 0;
        for(int i = 0; i<matrix.length; i++)
            for(int j = 0; j<matrix.length; j++)
                if(j==matrix.length-i-1)
                  sum2+=matrix[i][j];
        return sum2;
    }
    
    public int [] getMatrix() {
    int size = matrix.length;
     int [] tempArray = new int [size * size];
//пересчет индексов из одномерного массива в двумерный 
     for (int i = 0; i < size; i++)
         for (int j = 0; j < size; j++)
             //Копирование массивов из одного массива в другой
             tempArray[i*size+j] = matrix[i][j] ;
     
     return tempArray;
}
    
    
    
    
    
}


    