
package program_processing_java;


public class Addition {
    //Поле
     
     private int [][] matrixA;
     private final int size;// Создал внутреннюю переменную(Чтобы ее можно было видеть внутри класса)
     
    //Получаем элемент матрицы по указанным индексам
     public int getElement(int i, int j){
         return matrixA[i][j];
     }
     //Добавляем новый элемент value в матрицу по указанным индексам i и j
     public  void setElement(int i,int j, int value){
         if (i<size && j <size)
             matrixA[i][j]=value;
     }
     
     
     //Конструктор по умолчанию
     public Addition (){
         this(3);// this - вызывает конструктор с параметрами
     }
     
     public Addition(int [][] matrix) {         
         this(matrix.length);
         for (int i = 0; i<size;i++) 
            for (int j = 0; j<size;j++)       
                matrixA[i][j]= matrix[i][j];                 
     }
     
     
     //Конструктор с параметрами
     public Addition (int size){
         matrixA = new int [size][size];
         this.size = size;//this указывает на принадлежность данному классу,является его полем
                           // Внутренней переменной присвоил значение входного параметра
     }
     
     
     
     //Конструктор копирования
     public Addition(Addition addcopirov){
         size=addcopirov.size;
         matrixA = new int[size][size];
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrixA[i][j] = addcopirov.matrixA[i][j];
                    
                }
             
         }
                 
     }
     
    public int size() {
        return size;            
    }
     
     
     public int [][] sumTwoMatrix(int [][] matrixB) {
         
       int [][] matrixC = new int [matrixA.length][matrixA.length]; //Беру у любой матрицы ее размер(В данном случае матрицы А) 
          if (matrixA.length== matrixB.length) 
            {
                int count=matrixA.length;//Cound - размер матрицы
                for (int i=0; i<count;i++)
                    for (int j=0;j<count;j++)   
                       matrixC[i][j]=matrixA[i][j]+matrixB[i][j];                  
            }
          else  
              System.out.println("Ошибка");
          
          return matrixC;          
} 
     
    
    public int [] getMatrix() {
    int size = matrixA.length;
     int [] tempArray = new int [size * size];
//пересчет индексов из одномерного массива в двумерный 
     for (int i = 0; i < size; i++)
         for (int j = 0; j < size; j++)
             //Копирование массивов из одного массива в другой
             tempArray[i*size+j] = matrixA[i][j] ;
     
     return tempArray;
}
   
   public int [][] getSquareMatrix() {
    return matrixA;
}

}