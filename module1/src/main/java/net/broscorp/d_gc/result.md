                                      Вывод 1

При удалении ссылок на объекты, не факт что будет вызван Сборщик мусора, он вызывается JVM при заполнении ее памяти. Также нельзя спрогнозировать сколько объектов будет
удалено, что показывает LOG ниже, при  создании и потере ссылок на 20 обьектов,
по факту метод finalize() вызвался только у 6.

Nov 11, 2019 9:13:32 PM GarbageCollectionConcept showGarbageCollection
INFO: Object: 1554547125 has been created 1
Nov 11, 2019 9:13:32 PM GarbageCollectionConcept showGarbageCollection
INFO: Object: 1554547125 has been created 1
Nov 11, 2019 9:13:33 PM GarbageCollectionConcept showGarbageCollection
INFO: Object: 250421012 has been created 2
Nov 11, 2019 9:13:33 PM GarbageCollectionConcept showGarbageCollection
INFO: Object: 250421012 has been created 2
Nov 11, 2019 9:13:33 PM GarbageCollectionConcept showGarbageCollection
INFO: Object: 1915318863 has been created 3
Nov 11, 2019 9:13:33 PM GarbageCollectionConcept showGarbageCollection
INFO: Object: 1915318863 has been created 3
Nov 11, 2019 9:13:33 PM GarbageCollectionConcept showGarbageCollection
INFO: Object: 1283928880 has been created 4
Nov 11, 2019 9:13:33 PM GarbageCollectionConcept showGarbageCollection
INFO: Object: 1283928880 has been created 4
Nov 11, 2019 9:13:33 PM GarbageCollectionConcept showGarbageCollection
INFO: Object: 295530567 has been created 5
Nov 11, 2019 9:13:33 PM GarbageCollectionConcept showGarbageCollection
INFO: Object: 295530567 has been created 5
Nov 11, 2019 9:13:33 PM GarbageCollectionConcept showGarbageCollection
INFO: Object: 2003749087 has been created 6
Nov 11, 2019 9:13:33 PM GarbageCollectionConcept showGarbageCollection
INFO: Object: 2003749087 has been created 6
Nov 11, 2019 9:13:33 PM GarbageCollectionConcept showGarbageCollection
INFO: Object: 1324119927 has been created 7
Nov 11, 2019 9:13:33 PM GarbageCollectionConcept showGarbageCollection
INFO: Object: 1324119927 has been created 7
Nov 11, 2019 9:13:33 PM GarbageCollectionConcept showGarbageCollection
INFO: Object: 990368553 has been created 8
Nov 11, 2019 9:13:33 PM GarbageCollectionConcept showGarbageCollection
INFO: Object: 990368553 has been created 8
Nov 11, 2019 9:13:33 PM GarbageCollectionConcept showGarbageCollection
INFO: Object: 1096979270 has been created 9
Nov 11, 2019 9:13:33 PM GarbageCollectionConcept showGarbageCollection
INFO: Object: 1096979270 has been created 9
Nov 11, 2019 9:13:33 PM GarbageCollectionConcept showGarbageCollection
INFO: Object: 1078694789 has been created 10
Nov 11, 2019 9:13:33 PM GarbageCollectionConcept showGarbageCollection
INFO: Object: 1078694789 has been created 10
Nov 11, 2019 9:13:33 PM GarbageCollectionConcept showGarbageCollection
INFO: Object: 1831932724 has been created 11
Nov 11, 2019 9:13:33 PM GarbageCollectionConcept showGarbageCollection
INFO: Object: 1831932724 has been created 11
Nov 11, 2019 9:13:33 PM GarbageCollectionConcept showGarbageCollection
INFO: Object: 1747585824 has been created 12
Nov 11, 2019 9:13:33 PM GarbageCollectionConcept showGarbageCollection
INFO: Object: 1747585824 has been created 12
Nov 11, 2019 9:13:33 PM GarbageCollectionConcept showGarbageCollection
INFO: Object: 1023892928 has been created 13
Nov 11, 2019 9:13:33 PM GarbageCollectionConcept showGarbageCollection
INFO: Object: 1023892928 has been created 13
Nov 11, 2019 9:13:33 PM GarbageCollectionConcept showGarbageCollection
INFO: Object: 558638686 has been created 14
Nov 11, 2019 9:13:33 PM GarbageCollectionConcept showGarbageCollection
INFO: Object: 558638686 has been created 14
Nov 11, 2019 9:13:33 PM GarbageCollectionConcept showGarbageCollection
INFO: Object: 1149319664 has been created 15
Nov 11, 2019 9:13:33 PM GarbageCollectionConcept showGarbageCollection
INFO: Object: 1149319664 has been created 15
Nov 11, 2019 9:13:33 PM GarbageCollectionConcept showGarbageCollection
INFO: Object: 2093631819 has been created 16
Nov 11, 2019 9:13:33 PM GarbageCollectionConcept showGarbageCollection
INFO: Object: 2093631819 has been created 16
Nov 11, 2019 9:13:33 PM GarbageCollectionConcept showGarbageCollection
INFO: Object: 2074407503 has been created 17
Nov 11, 2019 9:13:33 PM GarbageCollectionConcept showGarbageCollection
INFO: Object: 2074407503 has been created 17
Nov 11, 2019 9:13:33 PM GarbageCollectionConcept showGarbageCollection
INFO: Object: 999966131 has been created 18
Nov 11, 2019 9:13:33 PM GarbageCollectionConcept showGarbageCollection
INFO: Object: 999966131 has been created 18
Nov 11, 2019 9:13:33 PM GarbageCollectionConcept showGarbageCollection
INFO: Object: 1989780873 has been created 19
Nov 11, 2019 9:13:33 PM GarbageCollectionConcept showGarbageCollection
INFO: Object: 1989780873 has been created 19
Nov 11, 2019 9:13:33 PM GarbageCollectionConcept showGarbageCollection
INFO: Object: 1480010240 has been created 20
Nov 11, 2019 9:13:33 PM GarbageCollectionConcept showGarbageCollection
INFO: Object: 1480010240 has been created 20
Nov 11, 2019 9:13:33 PM GarbageCollectionConcept finalize
INFO: Object; 1096979270 has been deleted 1
Nov 11, 2019 9:13:33 PM GarbageCollectionConcept finalize
INFO: Object; 1096979270 has been deleted 1
Nov 11, 2019 9:13:33 PM GarbageCollectionConcept finalize
INFO: Object; 990368553 has been deleted 2
Nov 11, 2019 9:13:33 PM GarbageCollectionConcept finalize
INFO: Object; 990368553 has been deleted 2
Nov 11, 2019 9:13:33 PM GarbageCollectionConcept finalize
INFO: Object; 1324119927 has been deleted 3
Nov 11, 2019 9:13:33 PM GarbageCollectionConcept finalize
INFO: Object; 1324119927 has been deleted 3
Nov 11, 2019 9:13:33 PM GarbageCollectionConcept finalize
INFO: Object; 2003749087 has been deleted 4
Nov 11, 2019 9:13:33 PM GarbageCollectionConcept finalize
INFO: Object; 2003749087 has been deleted 4
Nov 11, 2019 9:13:33 PM GarbageCollectionConcept finalize
INFO: Object; 295530567 has been deleted 5
Nov 11, 2019 9:13:33 PM GarbageCollectionConcept finalize
INFO: Object; 295530567 has been deleted 5
Nov 11, 2019 9:13:33 PM GarbageCollectionConcept finalize
INFO: Object; 1283928880 has been deleted 6



                                 Вывод 2
 Так что же будет если сделать обьект достижимыми? В классе Resurection, происходит заполнение статического Листа примитивами в первом блоке for. Во втором блоке происходит удаление Листа и вызов Сборщика мусора.В  логе видно, что при первой итерации второго блока, объекты снова заполняют Лист, но уже при второй и последующих итерациях Лист пустой, это должно свидетельствовать о том, что метод finflize() вызывается только один раз на объекте, обьект попадает с флагом финализации в очередь, и как только он становится “видимым” для Сборщика Мусора снова, тот его удаляет, без повторного вызова финализации. Конечно идея кода не моя, но благодаря его простоте стало понятнее как это работает.



Nov 11, 2019 9:29:10 PM Resurrection main
INFO: HAVEN: [Zombie [number=0], Zombie [number=1], Zombie [number=2]]
Nov 11, 2019 9:29:10 PM Resurrection$Zombie finalize
INFO: Resurect: 2
Nov 11, 2019 9:29:10 PM ResurrecNov 11, 2019 9:45:13 PM MutualReference main
INFO: mR1: 2055281021
Nov 11, 2019 9:45:14 PM MutualReference main
INFO: mR2: 250421012
Nov 11, 2019 9:45:14 PM MutualReference main
INFO: mR1: 1915318863
Nov 11, 2019 9:45:14 PM MutualReference main
INFO: mR2: 1283928880
Nov 11, 2019 9:45:14 PM MutualReference finalize
INFO: finalize: 2055281021
Nov 11, 2019 9:45:14 PM MutualReference finalize
INFO: finalize: 1283928880
Nov 11, 2019 9:45:14 PM MutualReference finalize
INFO: finalize: 1915318863
Nov 11, 2019 9:45:14 PM MutualReference finalize
INFO: finalize: 250421012tion$Zombie finalize
INFO: Resurect: 1
Nov 11, 2019 9:29:10 PM Resurrection$Zombie finalize
INFO: Resurect: 0
Nov 11, 2019 9:29:11 PM Resurrection main
INFO: HAVEN: [Zombie [number=2], Zombie [number=1], Zombie [number=0]]
Nov 11, 2019 9:29:12 PM Resurrection main
INFO: HAVEN: []
Nov 11, 2019 9:29:13 PM Resurrection main
INFO: HAVEN: []
Nov 11, 2019 9:29:14 PM Resurrection main
INFO: HAVEN: []
Nov 11, 2019 9:29:15 PM Resurrection main
INFO: HAVEN: []



                                 Вывод 3
 Пары объектов, которые ссылаются друг на друга удаляются. 



Nov 11, 2019 9:45:13 PM MutualReference main
INFO: mR1: 2055281021
Nov 11, 2019 9:45:14 PM MutualReference main
INFO: mR2: 250421012
Nov 11, 2019 9:45:14 PM MutualReference main
INFO: mR1: 1915318863
Nov 11, 2019 9:45:14 PM MutualReference main
INFO: mR2: 1283928880
Nov 11, 2019 9:45:14 PM MutualReference finalize
INFO: finalize: 2055281021
Nov 11, 2019 9:45:14 PM MutualReference finalize
INFO: finalize: 1283928880
Nov 11, 2019 9:45:14 PM MutualReference finalize
INFO: finalize: 1915318863
Nov 11, 2019 9:45:14 PM MutualReference finalize
INFO: finalize: 250421012


