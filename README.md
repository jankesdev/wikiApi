# WikiApi

The app uses the wikipedia api. The application get a short description of the football club and a link to the wikipedia source based on the club name.

#### Installation

```bash
git clone https://github.com/jankesdev/wikiApi
```

#### Run the application - mvn

1. `cd wikiApi`
2. `mvn install`
3. `mvn spring-boot:run`

#### Run in Docker

1. Build project
`cd wikiApi`
2. `docker build -t wikiapi/wikiapi .`
2. `docker run -p 8080:8080 wikiapi/wikiapi`

#### Documentation API - swagger

```bash
http://localhost:8080/swagger-ui.html
```