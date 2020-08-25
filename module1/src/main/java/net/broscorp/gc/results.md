**1. Простой случай**
Генерирую 10 миллионов объектов. Сборщик в процессе генерации самостоятельно вызывается 2 раза,
практически сразу же со стартом генерации. Несмотря на это потребление памяти все равно растет...
Проходит секунд 20-30 после конца генерации когда снова срабатывает сборщик.
    Если выполнить System.firstGc() - срабатывает со 2-3 раза. Если не срабатывает - потребление памяти растет.
Вызов Perform GC вызывает сборщик сразу же. При этом очищаются Eden и Survivor Space (System.firstGc() 
чистит в основном Eden, и слегка Survivor Space). Old Generation оба способа не трогают (наверное
потому, что мои объекты до него не доживают...)

**2. Сохраняем ссылку в finalize**
Почти сразу получаем java.lang.StackOverflowError.
По той причине, что finalize повторно не вызывается и объект будет не доступен для GC.
На момент получения еррора памяти все еще достаточно, но программа все равно падает.

**3. Объекты со взаимными ссылками**
Поведение аналогичное п.1. GC не найдет в корнях ссылки на эти объекты, поэтому они будут удалены.



**пример лога**
finalize called on net.broscorp.gc.SecondGC@4290faf6
finalize called on net.broscorp.gc.SecondGC@4e635f6a
finalize called on net.broscorp.gc.SecondGC@3172a8f1
finalize called on net.broscorp.gc.FirstGC@437a9bf1
finalize called on net.broscorp.gc.FirstGC@6f88e22
finalize called on net.broscorp.gc.FirstGC@52341998
finalize called on net.broscorp.gc.FirstGC@76a5060f
finalize called on net.broscorp.gc.FirstGC@6117ae39
finalize called on net.broscorp.gc.SecondGC@235ca5a7
finalize called on net.broscorp.gc.SecondGC@5156808d
finalize called on net.broscorp.gc.FirstGC@f1d71d6
finalize called on net.broscorp.gc.FirstGC@5327706a
finalize called on net.broscorp.gc.SecondGC@15909634
finalize called on net.broscorp.gc.SecondGC@70a73ee3
finalize called on net.broscorp.gc.FirstGC@14d072e0
finalize called on net.broscorp.gc.SecondGC@7c1cf430
finalize called on net.broscorp.gc.SecondGC@6d2cecb1
finalize called on net.broscorp.gc.FirstGC@24b597d1
finalize called on net.broscorp.gc.FirstGC@3365b6d5
