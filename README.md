# spring-resource-resolver-spa-example

Resource resolver example for spa applications. For example i've added angular2 and react app starter builds.  

## Run

```
mvn clean install

cd app

mvn spring-boot:run
```

## Using

There is no cookie set by default at startup. 

* To enable Angular2 resources use

GET /changeclient/angular/

* To enable react resources use 

GET /changeclient/react/
