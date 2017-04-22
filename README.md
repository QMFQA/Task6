# Task6

Основываясь на коде класса Main, необходимо реализовать следующие классы:
<ul>
<li>абстрактный класс QMFObject;</li>
<li>классы Form, Query и Procedure должны быть потомками класса QMFObject;</li>
<li>класс ObjectList, инкапсулирующий список эксземпляров List&lt;QMFObject&gt;;</li>
<li>класс Logger:
<ul>
<li>реализует методы логирования info и error, логирование ведется в файл log.txt, находящийся в корне проекта;</li>
<li>реализует метод parseError, возвращающий список форматированных строк из файла log.txt, которые соответсвуют ошибкам в соответствующем классе.</li>
</ul></li>
</ul>

Ожидаемый вывод в результате выполнения программы:
<pre>Query errors:
(2017-04-20 15:18) Object with name 'Query1' is not exist
Form errors:
(2017-04-20 15:18) Cannot run form
(2017-04-20 15:18) Object with name 'Form1' is already exist
Procedure errors:
(2017-04-20 15:18) Object 'Procedure1' is not created and cannot be run
(2017-04-20 15:18) Object with name 'Procedure1' is not exist</pre>

Ожидаемое содержимое файла log.txt в результате выполнения программы:
<pre>[ERROR][2017-04-20 15:18]Query: Object with name 'Query1' is not exist
[INFO][2017-04-20 15:18]Query: 'Query1' with SQL 'SELECT * FROM Q.STAFF' is created
[INFO][2017-04-20 15:18]Query: 'Query1' with SQL 'SELECT * FROM Q.STAFF' is run
[INFO][2017-04-20 15:18]Query: 'Query1' with SQL 'SELECT * FROM Q.STAFF' is run
[INFO][2017-04-20 15:18]Form: 'Form1' is created
[ERROR][2017-04-20 15:18]Form: Cannot run form
[ERROR][2017-04-20 15:18]Form: Object with name 'Form1' is already exist
[ERROR][2017-04-20 15:18]Procedure: Object 'Procedure1' is not created and cannot be run
[INFO][2017-04-20 15:18]Procedure: 'Procedure1' with text 'DISPLAY QUERY' is created
[INFO][2017-04-20 15:18]Procedure: 'Procedure1' with text 'DISPLAY QUERY' is run
[INFO][2017-04-20 15:18]Procedure: 'Procedure1' with text 'DISPLAY QUERY' is deleted
[ERROR][2017-04-20 15:18]Procedure: Object with name 'Procedure1' is not exist</pre>

<h3>Темы для изучения:</h3>
<ul>
<li>Регулярные выражения</li>
<li>Запись в файл</li>
</ul>
