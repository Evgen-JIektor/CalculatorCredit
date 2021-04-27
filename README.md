# CalculatorCredit

Установка и запуск

В консоли выполняем команду
git clone https://github.com/Evgen-JIektor/CalculatorCredit.git

Предварительно на ПК должен быть установлен Maven

Переходим в папку с проектом и выполняем команду (cd CalculatorCredit)
mvn clean install

Переходим в паку target выполняем команду (cd target)
java -jar serving-web-content-0.0.1-SNAPSHOT.jar

переходим в браузер в http://localhost:8080/calc
