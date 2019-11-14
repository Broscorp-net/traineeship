
* Сборщик мусора срабатывает впервые при скоплении достаточно большого количества объектов. 

* Сборщик мусора наиболее вероятно удалит недостижимые объекты, которые были созданы недавно. 
    
        19:45:41.544 #47578
        19:45:41.707 #179799
        19:45:41.707 #179798
        19:45:41.708 #179797


* Добавленные `reusableWaste` объекты остаются достижимыми после итерации цикла. Сборщик мусора не срабатывает на достижимых объектах.

 ```java   
    public static ArrayList<SomeObject> produceSomeWaste(int n, int reuseFrom, int reuseTo) {
    
        ArrayList<SomeObject> reusableWaste = new ArrayList<>();

        for (int id = 0; id < n; id++) {
            String strID = Integer.toString(id);
            SomeObject someObj = new SomeObject(strID);
            if (id > reuseFrom && id < reuseTo) {
                reusableWaste.add(someObj);
            }
        }
        return reusableWaste;
    }
```

        17:43:36.993 #255324
        17:43:36.993 #255323
        17:43:37.025 #412480
        17:43:37.025 #438161
    
    
* Eсли в блоке финализации снова сделать объект достижимым `_copy`, то он получает иммунитет от сбощика мусора.

 ```java  
     @Override
        protected void finalize() throws Throwable {
            super.finalize();
            super.id += "_copy";
            SomeObject someCopiedObj = this;
        }
```

* Пары объектов, которые ссылаются друг на друга, будут удалены вместе.

 ```java  
    public static void producePairsOfWaste(int n) {
    
        for(int id = 0; id < n; id++) {
            String strID = Integer.toString(id);
            SomeOtherObject someObj = new SomeOtherObject(strID + "_1");
            SomeOtherObject someOtherObj = new SomeOtherObject(strID + "_2");
            someObj.other = someOtherObj;
            someOtherObj.other = someObj;
        }
    }
```

        18:58:40.636 #182840_1
        18:58:40.636 #182839_2

