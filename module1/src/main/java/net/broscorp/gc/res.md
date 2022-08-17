#### Когда создаються обьекты в большом количестве то сборщик муссора начинает срабатывать при количестве близкоим к __60 тысячи__
+ Human with id 54262 was finalized
+ Human with id 54270 was finalized
+ Human with id 54270 was finalized 

#### При создании и потери ссылок на обьекты сборщик муссора начинает срабатывать около 5000 количестве итераций
+ Human with id 5023 was finalized
+ Human with id 7116 was finalized
+ Human with id 7249 was finalized
+ Human with id 7312 was finalized
+ Human with id 7355 was finalized

#### После срабатывания finalize метода долступ к обьектам не теряеться

#### Удаление происходит без проблем при обнулении взаимосвязаных обьектов
+ Human with id 1 was finalized
+ Human with id 2 was finalized