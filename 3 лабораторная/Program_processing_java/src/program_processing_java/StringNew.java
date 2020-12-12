
package program_processing_java;


class StringNew {
//Поле 
    private String s1;
    
    //Констроктор по умолчанию
    public StringNew(){
        this("-123");
    }
    
    
    
    
    //Конструктор с параметром 
    public StringNew(String s1) {
        this.s1 = s1;
    }

    
    
    //Конструктор копирования
    public StringNew (StringNew stringNew2){
        //Вспомогательный класс StringBuilder - работает со строками
        //sb - имя объекта
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < stringNew2.s1.length(); i++) {//Прохожусь по старой строке
            sb.append(stringNew2.s1.charAt(i));   //Копирую в Sb         
        }
        //С sb в новую строку
        s1 = sb.toString();//Приведение к строке
    }
    
    
    
    public boolean isDigitalSrting(){
       boolean number = true;
       
        
        if((s1.charAt(0)<48 || s1.charAt(0)>57) && s1.charAt(0) != 45) //CharAt - берет символ по указанному индексу 
            number = false;
        
        if (number)
        {
           for(int i=1;i<s1.length();i++)// length - длина строки 
            {
                if (s1.charAt(i)<48 || s1.charAt(i)>57) //charAt - берем отдельный символ
                {
                    number = false;
                    break;
                }
            } 
        }
        return number;
    }  
    
    public String getString() {
        return s1;
    }
}
