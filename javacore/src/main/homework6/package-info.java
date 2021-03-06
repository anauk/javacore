package main.homework6;
/*Сделайте все поля приватными.
        Создайте и опишите класс Семья (Family). Будем считать, что семья может создаваться 2-мя людьми, которые не расходятся и могут рождать/усыновлять своих детей. Дети могут взрослеть и уходить из семьи, создавая свою собственную.
Технические требования:

        Объявите все поля существующих классов как приватные. Добавьте геттеры и сеттеры; сделайте рефакторинг существующих методов с учетом изменений.
        Опишите у класса Family следующие поля:

        мама mother (тип Human)
        папа father (тип Human)
        дети children (массив Human)
        домашний любимец pet (тип Pet)


        Добавьте геттеры, сеттеры; переопределите toString так чтобы он показывал всю информацию о всех членах семьи.
        В классе Family создайте конструктор:

        единственным условием создания новой семьи является наличие 2-х родителей, при этом у родителей должна устанавливаться ссылка на текущую новую семью, а семья создается с пустым массивом детей.


        Сделайте рефакторинг класса Human с учетом структуры Family:

        удалите из Human всю информацию, дублирующуюся в классе Family (Human должен хранить только информацию описывающую себя)
        добавьте поле family (тип Family) (теперь оно хранит всю информацию о семейных данных человека)
        добавьте необходимые геттеры, сеттеры, конструкторы; удалите неактуальные конструкторы и методы; сделайте рефакторинг методов поприветствовать своего любимца, описать своего любимца, накормить

        сделайте рефакторинг метода toString(). Он должен выводить информацию в следующем формате: Human{name='Name', surname='Surname', year=1, iq=1, schedule=[[day, task], [day_2, task_2]]}

        В Family опишите методы:

        добавить ребенка addChild (принимает тип Human и добавляет его в массив детей; добавляет ребенку ссылку на текущую семью)
        удалить ребенка deleteChild (принимает индекс массива и удаляет данный элемент; возвращает логическое значение - был ли удален элемент)
        получить количество человек в семье countFamily (родители в семье никогда не изменяются; если происходит изменение родительского состава - это уже другая семья)
        переопределите метод toString()
        Методы должны не просто добавлять/удалять элементы в массив Human но и производить необходимые модификации (добавленному/удаленном элементу установить/удалить ссылку на текущую семью). При удалении элемента, в массиве не должно оставаться пустых мест - необходимо создать новый массив.

        Не обязательное задание продвинутой сложности:
        В Family опишите метод удалить ребенка(deleteChild) (принимает тип Human и удаляет соответствующий элемент)
        Подсказка: для того, чтобы удалить верный элемент из массива Human'ов вам необходимо делать сравнения по полям идентифицирующим именно данного человека (подумайте, какие поля для этого подходят).
        */
/*int i;
        int len=children.length;
        for(i=0; i<len; i++){
            if(i == index);
            break;
        }
        for(int k=i; k<len-1; k++) {
            children[k]= children[k+1];
            len--;
        }*/