# NBP API Client

Celem zadania rekrutacyjnego jest utworzenie aplikacji, który będzie pobierał waluty z API NBP, a następnie przetwarzał te dane. </br>

Link do API NBP: </br>
https://api.nbp.pl/ 

Aplikacja musi być aplikacją konsolową, która jako parametr przyjmuje walutę w formie pełnej nazwy tekstowej oraz zakres dat: początkowa i końcowa. 

Dla uproszczenia zadania można przyjąć, że obecnie serwis będzie sprawdzany jedynie dla walut:

- Rubel rosyjski
- Dolar amerykański
- Euro

Format daty wejściowej serwisu jest dowolny.

Serwis po wysłania zapytania do API NBP powinien otrzymać dane dotyczące cen kupna i sprzedaży podanej waluty w oczekiwanym zakresie dat.

Następnie na podstawie otrzymanych danych należy wskazać najniższą cenę kupna i najwyższą sprzedaży, wraz z dotyczącymi ich datami wystąpienia w podanym zakresie. Dodatkowo należy te dane zapisać w bazie danych w taki sposób, by przy kolejnych wywołaniach serwisu o podany zakres dat i walutę otrzymać wynik z bazy danych, bez odpytywania API NBP.

## How to build/use
To build/run application, enter following commands into command line:
```
mvn package                                             ## to build application
java -jar target/api_rekrutacyjne-1.0-SNAPSHOT.jar      ## to run application
```


## Author
JavaGdy4 @ 2020

 