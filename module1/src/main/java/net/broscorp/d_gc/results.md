
* Сборщик мусора срабатывает впервые при скоплении достаточно большого количества объектов. 

* Сборщик мусора наиболее вероятно удалит недостижимые объекты, которые были созданы недавно. 
    
        19:45:41.544 #47578
        19:45:41.707 #179799
        19:45:41.707 #179798
        19:45:41.708 #179797


* Добавленные `list` объекты остаются достижимыми после итерации цикла. Сборщик мусора не срабатывает на достижимых объектах.

 ```java   
    ArrayList<SomeObject> list = new ArrayList<>();
    
    for(int id = 0; id < 500000; id++) {`
    
        SomeObject someObj = new SomeObject(id);
        if(id > 300000 && id < 400000) {
            list.add(someObj);
        }
    }
```

        17:43:36.993 #255324
        17:43:36.993 #255323
        17:43:37.025 #412480
        17:43:37.025 #438161
    
* Eсли при финализации `finalize()` снова сделать объект достижимым `_copy`, то он получает иммунитет от сбощика мусора на какое-то время.




 ```java  
    ArrayList<SomeObject> list = new ArrayList<>();
    
    for(int id = 0; id < 500000; id++) {
        String strID = Integer.toString(id);
        SomeObject someObj = new SomeObject(strID);
    
        if(id > 290000 && id < 300000) {
            try {
                Date date = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss.SSS");
                String dateTime = formatter.format(date);
                System.out.println(dateTime + " " + someObj.getId() + " finalize()");
                someObj.finalize();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
    
            someObj.setId(someObj.getId() + "_copy");
            SomeObject someOtherObj = someObj;
        }
    }
```

        19:29:00.856 #290170 finalize()
        …
        19:29:01.131 #290170_copy

* Пары объектов, которые ссылаются друг на друга, будут удалены вместе.

 ```java  
    SomeObject someObj = new SomeObject(id + "_1");
    SomeObject someOtherObj = new SomeObject(id + "_2");
    
    someObj.other = someOtherObj;
    someOtherObj.other = someObj;
```

        18:58:40.636 #182840_1
        18:58:40.636 #182839_2
