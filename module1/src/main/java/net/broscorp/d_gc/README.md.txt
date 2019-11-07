1) Мы не можем быть уверенны до конца что Garbage Collector удалит все объекты без ссылок

1304836502 number 1
225534817 number 2
1878246837 number 3
929338653 number 4
1259475182 number 5
1300109446 number 6
1020371697 number 7
789451787 number 8
1950409828 number 9
1229416514 number 10
2016447921 number 11
666988784 number 12
1414644648 number 13
640070680 number 14
1510467688 number 15
1995265320 number 16
746292446 number 17
1072591677 number 18
1523554304 number 19
1175962212 number 20
918221580 number 21
2055281021 number 22
1554547125 number 23
617901222 number 24
1159190947 number 25
925858445 number 26
798154996 number 27
681842940 number 28
1392838282 number 29
523429237 number 30
664740647 number 31
804564176 number 32
1421795058 number 33
1555009629 number 34
41359092 number 35
149928006 number 36
713338599 number 37
168423058 number 38
821270929 number 39
1160460865 number 40
1247233941 number 41
258952499 number 42
603742814 number 43
1067040082 number 44
1325547227 number 45
980546781 number 46
2061475679 number 47
140435067 number 48
1450495309 number 49
1670782018 number 50
1706377736 number 51
468121027 number 52
1804094807 number 53
951007336 number 54
2001049719 number 55
1528902577 number 56
1927950199 number 57
868693306 number 58
1746572565 number 59
989110044 number 60
424058530 number 61
321001045 number 62
791452441 number 63
834600351 number 64
471910020 number 65
531885035 number 66
1418481495 number 67
303563356 number 68
135721597 number 69
142257191 number 70
1044036744 number 71
1826771953 number 72
1406718218 number 73
245257410 number 74
1705736037 number 75
455659002 number 76
250421012 number 77
1915318863 number 78
1283928880 number 79
295530567 number 80
2003749087 number 81
1324119927 number 82
990368553 number 83
1096979270 number 84
1078694789 number 85
1831932724 number 86
1747585824 number 87
1023892928 number 88
558638686 number 89
1149319664 number 90
2093631819 number 91
2074407503 number 92
999966131 number 93
1989780873 number 94
1480010240 number 95
81628611 number 96
1828972342 number 97
1452126962 number 98
931919113 number 99
1607521710 number 100
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called
Finalize has been called


2) Если при финализации сделать объект достижимым, то на этом обьекте не будет вызываться метод финализации, так как он (метод) вызывается всего один раз. Но у меня не получается сделать объект достижимым. Ниже исходный код, вроде логика правильная, но обьект только удаляется, не восстанавливается. File Test.java.  Метод Finalize вызывается я проверял это


3) Если обьекты одного класса ссылаются друг на друга, то  при присвоении null значения одному из них, сборщик удаляет тот обьект, которому присвоен null.  File ObjectRef.java

Log:

1304836502
Exception in thread "main" java.lang.NullPointerException
	at ObjectRef.main(ObjectRef.java:11)









 